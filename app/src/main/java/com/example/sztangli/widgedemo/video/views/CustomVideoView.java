package com.example.sztangli.widgedemo.video.views;

import android.content.Context;
import android.util.AttributeSet;

import com.example.sztangli.widgedemo.R;

import cn.jzvd.JzvdStd;

/**
 * created by com.tl on 2019-1-22
 */
public class CustomVideoView extends JzvdStd {

  public CustomVideoView(Context context) {
    super(context);
  }

  public CustomVideoView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override
  public int getLayoutId() {
    return R.layout.video_layout;
  }
}
