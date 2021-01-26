package com.example.sztangli.widgedemo.animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mvvmlibrary.base.data.BaseViewModel;
import com.example.sztangli.widgedemo.R;
import com.example.sztangli.widgedemo.databinding.FragmentAnimationBinding;
import com.example.sztangli.widgedemo.utils.AnimationUtils;
import com.guyuan.handlein.base.ui.activity.BaseToolbarActivity;
import com.guyuan.handlein.base.ui.fragment.BaseFragment;

import butterknife.BindView;

/**
 * Created by com.tl on 2018-9-25
 */
public class AnimationFragment extends BaseFragment<FragmentAnimationBinding, BaseViewModel> implements View.OnClickListener {

    public static final String TAG = "AnimationFragment";

    @BindView(R.id.animation_iv)
    TextView animationIv;
    @BindView(R.id.rotate_bt)
    Button rotateBt;
    @BindView(R.id.transparency_bt)
    Button transparencyBt;
    @BindView(R.id.crop_bt)
    Button cropBt;
    @BindView(R.id.shift_bt)
    Button shiftBt;
    @BindView(R.id.inandout_bt)
    Button inandoutBt;
    @BindView(R.id.scene_change_bt)
    Button sceneChangeBt;
    @BindView(R.id.jump_bt)
    Button jumpBt;
    @BindView(R.id.calculate_bt)
    Button calculate_bt;
    @BindView(R.id.show_btn)
    Button show_btn;
    @BindView(R.id.hide_btn)
    Button hide_btn;

    private ObjectAnimator animationIn;
    private ObjectAnimator animationOut;
    private ObjectAnimator animationRotateZ;
    private ObjectAnimator animationRotateX;
    private ObjectAnimator animationRotateY;
    private ObjectAnimator animationScaleX;
    private ObjectAnimator animationScaleY;
    private ObjectAnimator animationAlpha;
    private Animator animationShow;
    private BaseToolbarActivity baseToolBarActivity;
    private boolean hide = false;

    public static AnimationFragment newInstance() {

        Bundle args = new Bundle();

        AnimationFragment fragment = new AnimationFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initialization() {
        baseToolBarActivity = (BaseToolbarActivity) getActivity();
        rotateBt.setOnClickListener(this);
        transparencyBt.setOnClickListener(this);
        cropBt.setOnClickListener(this);
        shiftBt.setOnClickListener(this);
        inandoutBt.setOnClickListener(this);
        sceneChangeBt.setOnClickListener(this);
        jumpBt.setOnClickListener(this);
        calculate_bt.setOnClickListener(this);
        show_btn.setOnClickListener(this);
        hide_btn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.rotate_bt://旋转
                if (animationRotateZ == null) {
                    animationRotateZ = AnimationUtils.rotateZ(animationIv);
                    animationRotateZ.setDuration(1000);
                    animationRotateZ.start();
                } else {
                    animationRotateZ.start();
                }
                break;

            case R.id.transparency_bt://透明度
                if (animationAlpha == null) {
                    animationAlpha = AnimationUtils.alpha(animationIv);
                    animationAlpha.setDuration(1000);
                    animationAlpha.start();
                } else {
                    animationAlpha.start();
                }
                break;

            case R.id.crop_bt://缩放
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setDuration(1000);
                if (animationScaleX == null && animationScaleY == null) {
                    animationScaleX = AnimationUtils.scaleX(animationIv);
                    animationScaleY = AnimationUtils.scaleY(animationIv);
                    animatorSet.playTogether(animationScaleX, animationScaleY);
                    animatorSet.start();
                } else {
                    animatorSet.playTogether(animationScaleX, animationScaleY);
                    animatorSet.start();
                }
                break;

            case R.id.shift_bt://渐进
                if (animationShow == null) {
                    animationShow = AnimationUtils.showIncircle(animationIv);
                    animationShow.setDuration(1000);
                    animationShow.start();
                } else {

                }
                break;

            case R.id.inandout_bt://显示消失过渡
                if (!hide) {
                    if (animationOut == null) {
                        animationOut = AnimationUtils.outToTop(animationIv);
                        animationOut.setDuration(1000);
                        animationOut.start();
                    } else {
                        animationOut.start();
                    }
                    hide = true;
                } else {
                    if (animationIn == null) {
                        animationIn = AnimationUtils.inFromTop(animationIv);
                        animationIn.setDuration(1000);
                        animationIn.start();
                    } else {
                        animationIn.start();
                    }

                    hide = false;
                }
                break;

            case R.id.scene_change_bt://场景切换

                break;

            case R.id.jump_bt://跳转

                break;

            case R.id.calculate_bt://计算
                ValueAnimator animator = ValueAnimator.ofFloat(0, 2000);
                animator.setDuration(1000);
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float value = (float) valueAnimator.getAnimatedValue();
                        calculate_bt.setText(String.valueOf(value));
                    }
                });
                animator.start();
                break;

//      case R.id.show_btn:
//        if (baseToolBarActivity != null) {
//         baseToolBarActivity.showStatusBar();
//        }
//        break;
//
//      case R.id.hide_btn:
//        if (baseToolBarActivity != null) {
//          baseToolBarActivity.hideStatusBar();
//        }
//        break;
        }


    }

    @Override
    protected int getVariableId() {
        return 0;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_animation;
    }
}
