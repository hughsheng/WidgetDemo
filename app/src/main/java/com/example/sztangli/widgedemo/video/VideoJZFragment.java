package com.example.sztangli.widgedemo.video;

import android.content.pm.ActivityInfo;
import android.nfc.tech.TagTechnology;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.sztangli.widgedemo.R;
import com.example.sztangli.widgedemo.base.fragment.BaseFragment;
import com.example.sztangli.widgedemo.video.views.CustomVideoView;

import butterknife.BindView;
import cn.jzvd.Jzvd;

/**
 * created by tl on 2019-1-22
 */
public class VideoJZFragment extends BaseFragment {

  public static final String TAG = "VideoJZFragment";

  @BindView(R.id.video_player)
  CustomVideoView video_player;

  public static VideoJZFragment newInstance() {

    Bundle args = new Bundle();

    VideoJZFragment fragment = new VideoJZFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public int getLayoutResId() {
    return R.layout.fragment_jz_video;
  }

  @Override
  public void onResume() {
    super.onResume();
    Jzvd.FULLSCREEN_ORIENTATION = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
    Jzvd.NORMAL_ORIENTATION = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
  }

  @Override
  public void onUnBind() {

  }

  @Override
  public void initialization() {
    String url = "https://mtnic.fangte.com/video/%E7%94%B5%E5%8D%95%E8%BD%A6%E8%A6%81%E9%98%B2%E6" +
        "%82%A3%E4%BA%8E%E6%9C%AA%E2%80%9D%E7%87%83%E2%80%9C.mp4";
    video_player.setUp(url, "测试标题", Jzvd.SCREEN_WINDOW_NORMAL);
    Glide.with(this)
        .load("http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640")
        .into(video_player.thumbImageView);
  }

}
