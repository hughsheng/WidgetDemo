package com.example.sztangli.widgedemo.lottie;

import android.os.Bundle;

import com.example.sztangli.widgedemo.R;

import com.example.mvvmlibrary.base.data.BaseViewModel;
import com.example.sztangli.widgedemo.utils.ActivityUtils;
import com.guyuan.handlein.base.databinding.ActivityWithToolbarBinding;
import com.guyuan.handlein.base.ui.activity.BaseToolbarActivity;

public class LottieActivity extends BaseToolbarActivity<ActivityWithToolbarBinding, BaseViewModel> {
    @Override
    protected void initFragment(Bundle savedInstanceState) {
        LottieFragment lottieFragment = LottieFragment.newInstance();
        ActivityUtils.addFragmentToActivity(fragmentManager, lottieFragment, R.id.container, LottieFragment.TAG);
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_base;
    }

    @Override
    protected int getVariableId() {
        return 0;
    }
}
