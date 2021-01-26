package com.example.sztangli.widgedemo.animation;

import android.os.Bundle;
import android.transition.Explode;
import android.transition.Slide;
import android.view.Gravity;

import androidx.fragment.app.Fragment;

import com.example.mvvmlibrary.base.data.BaseViewModel;
import com.example.sztangli.widgedemo.home.MainToolBarActivity;
import com.example.sztangli.widgedemo.R;
import com.example.sztangli.widgedemo.utils.ActivityUtils;
import com.guyuan.handlein.base.databinding.ActivityWithToolbarBinding;
import com.guyuan.handlein.base.ui.activity.BaseToolbarActivity;

/**
 * Created by com.tl on 2018-9-25
 */
public class AnimationToolBarActivity extends BaseToolbarActivity<ActivityWithToolbarBinding, BaseViewModel> {

  private AnimationFragment animationFragment;
  private Fragment motionLayoutFragment;

  @Override
  protected void initFragment(Bundle savedInstanceState) {
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
    ActivityUtils.addFragmentToActivity(fragmentManager, motionLayoutFragment, R.id.fragment_container,
            AnimationFragment.TAG);
  }

  @Override
  protected int getLayoutID() {
    return R.layout.activity_with_toolbar;
  }

  @Override
  protected int getVariableId() {
    return 0;
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
