package com.example.sztangli.widgedemo.video;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.core.widget.ContentLoadingProgressBar;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;
import com.example.sztangli.widgedemo.R;
import com.guyuan.handlein.base.ui.fragment.BaseFragment;

import java.util.HashMap;
import butterknife.BindView;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;


/**
 * created by com.tl on 2019-1-21
 */
public class VideoFragment extends BaseFragment implements View.OnClickListener {

  public static final String TAG = "VideoFragment";

  @BindView(R.id.project_detail_video)
  VideoView project_detail_video;
  @BindView(R.id.pj_video_cover)
  ImageView pj_video_cover;
  @BindView(R.id.pj_play_icon)
  ImageView pj_play_icon;
  @BindView(R.id.load_progress)
  ContentLoadingProgressBar load_progress;

  private Disposable disposable;

  public static VideoFragment newInstance() {

    Bundle args = new Bundle();

    VideoFragment fragment = new VideoFragment();
    fragment.setArguments(args);
    return fragment;
  }


  @Override
  public void initialization() {
    String url = "https://mtnic.fangte.com/video/%E7%94%B5%E5%8D%95%E8%BD%A6%E8%A6%81%E9%98%B2%E6" +
        "%82%A3%E4%BA%8E%E6%9C%AA%E2%80%9D%E7%87%83%E2%80%9C.mp4";
    String urltest = "http://data.vod.itc.cn/?rb=1&key=jbZhEJhlqlUN-Wj_HEI8BjaVqKNFvDrn&prod" +
        "=flash&pt=1&new=/51/116/UdKGIuSjQIO8dynrybyS1E.mp4";
    loadVedio(project_detail_video, urltest);
  }


  private void loadVedio(VideoView videoView, String videoUrl) {
    Uri uri = Uri.parse(videoUrl);
    //初始化mediaController
    MediaController mediaController = new MediaController(getContext());
    //将videoView与mediaController建立关联
    videoView.setMediaController(mediaController);
    //将mediaController与videoView建立关联
    mediaController.setMediaPlayer(videoView);

    videoView.setOnPreparedListener(new MyPlayerOnPreparedListener(videoUrl));
    videoView.setOnErrorListener(new MyPalyerOnErrorListener());
    //设置视频路径
    videoView.setVideoURI(uri);
  }

  @Override
  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.pj_video_cover:
        project_detail_video.start();
        break;
    }
  }

  @Override
  protected int getVariableId() {
    return 0;
  }

  @Override
  protected int getLayoutID() {
    return R.layout.fragment_video;
  }

  class MyPlayerOnPreparedListener implements MediaPlayer.OnPreparedListener {

    private String videoUrl;

    public MyPlayerOnPreparedListener(String videoUrl) {
      this.videoUrl = videoUrl;
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
      createVideoThumbnail(videoUrl);
      mp.setOnInfoListener(new MediaPlayer.OnInfoListener() {
        @Override
        public boolean onInfo(MediaPlayer mp, int what, int extra) {
          if (what == MediaPlayer.MEDIA_INFO_VIDEO_RENDERING_START) {//视频帧真正展示到屏幕上了
            pj_video_cover.setVisibility(View.GONE);
            pj_play_icon.setVisibility(View.GONE);
          }

          return true;
        }
      });
    }
  }


  @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
  private void createVideoThumbnail(final String videoUrl) {
    disposable = Observable.just(videoUrl)
        .subscribeOn(Schedulers.io())
        .map(new Function<String, Bitmap>() {
          @Override
          public Bitmap apply(String s) throws Exception {
            Bitmap bitmap = null;
            MediaMetadataRetriever retriever = new MediaMetadataRetriever();
            if (videoUrl.startsWith("http")) {
              retriever.setDataSource(videoUrl, new HashMap<String, String>());
            } else {
              retriever.setDataSource(videoUrl);
            }
            bitmap = retriever.getFrameAtTime();
            if (bitmap == null) {
              bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.bg_default);
            }
            retriever.release();
            return bitmap;
          }
        })
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<Bitmap>() {
                     @Override
                     public void accept(Bitmap bitmap) {
                       load_progress.hide();
                       if (bitmap != null) {
                         pj_video_cover.setBackground(new BitmapDrawable(bitmap));
                       } else {
                         showToastTip("s");
                       }
                       pj_video_cover.setOnClickListener(VideoFragment.this);
                       pj_play_icon.setVisibility(View.VISIBLE);
                     }
                   }

        );

  }


  class MyPalyerOnErrorListener implements MediaPlayer.OnErrorListener {

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
      load_progress.hide();
      showToastTip("视频加载失败");
      return true;
    }
  }

}
