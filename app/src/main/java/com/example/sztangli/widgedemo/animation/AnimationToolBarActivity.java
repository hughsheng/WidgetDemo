package com.example.sztangli.widgedemo.animation;

import android.os.Bundle;
import android.transition.Explode;
import android.transition.Slide;
import android.view.Gravity;

import com.example.sztangli.widgedemo.home.MainToolBarActivity;
import com.example.sztangli.widgedemo.R;
import com.example.sztangli.widgedemo.base.activity.BaseToolBarActivity;
import com.example.sztangli.widgedemo.utils.ActivityUtils;

/**
 * Created by tl on 2018-9-25
 */
public class AnimationToolBarActivity extends BaseToolBarActivity {

  private AnimationFragment animationFragment;
  private MotionLayoutFragment motionLayoutFragment;

  @Override
  public int getLayoutResId() {
    return R.layout.activity_base;
  }


  @Override
  public void initalFragment(Bundle savedInstanceState) {
    // setJumpAnimation(R.transition.slide, R.transition.explode);
    //进入退出效果 注意这里 创建的效果对象是 Explode()
    Slide slide = new Slide();
    slide.setDuration(1000);
    slide.setSlideEdge(Gravity.TOP);
    getWindow().setEnterTransition(slide);
    getWindow().setExitTransition(new Explode().setDuration(1000));
    setTitleCenter(getIntent().getStringExtra(MainToolBarActivity.TITLE));
  //  animationFragment = AnimationFragment.newInstance();
    motionLayoutFragment = MotionLayoutFragment.newInstance();
    ActivityUtils.addFragmentToActivity(mFragmentManager, motionLayoutFragment, R.id.container,
        AnimationFragment.TAG);
  }


  //界面绘制完成监听
//  @Override
//  public void onWindowFocusChanged(boolean hasFocus) {
//    super.onWindowFocusChanged(hasFocus);
//    if (hasFocus) {
//
//    }
//  }
}
