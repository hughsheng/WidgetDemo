package com.example.sztangli.widgedemo.video;

import android.os.Bundle;
import android.view.View;

import com.example.sztangli.widgedemo.R;
import com.example.sztangli.widgedemo.base.activity.BaseToolBarActivity;
import com.example.sztangli.widgedemo.utils.ActivityUtils;
import com.example.sztangli.widgedemo.video.views.CustomVideoView;

import cn.jzvd.Jzvd;

/**
 * created by tl on 2019-1-21
 */
public class VideoActivity extends BaseToolBarActivity {
  @Override
  public void initalFragment(Bundle savedInstanceState) {

    // VideoFragment videoFragment = VideoFragment.newInstance();
    VideoJZFragment videoFragment = VideoJZFragment.newInstance();
    ActivityUtils.addFragmentToActivity(mFragmentManager, videoFragment,
        R.id.container, VideoFragment.TAG);

    back_iv.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (Jzvd.backPress()) {
          return;
        }
        finish();
      }
    });

  }

  @Override
  public int getLayoutResId() {
    return R.layout.activity_base;
  }


  public void onBackPressed() {
    if (Jzvd.backPress()) {
      return;
    }
    super.onBackPressed();
  }


  public void onPause() {
    super.onPause();
    Jzvd.releaseAllVideos();
  }
}
