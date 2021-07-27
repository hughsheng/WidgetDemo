package com.example.sztangli.widgedemo.lottie;

import android.os.Bundle;

import com.example.sztangli.widgedemo.R;
import com.example.mvvmlibrary.base.data.BaseViewModel;
import com.example.sztangli.widgedemo.databinding.FragmentLottieBinding;
import com.guyuan.handlein.base.ui.fragment.BaseFragment;

public class LottieFragment extends BaseFragment<FragmentLottieBinding, BaseViewModel> {

    public static final String TAG = "LottieFragment";

    public static LottieFragment newInstance() {

        Bundle args = new Bundle();

        LottieFragment fragment = new LottieFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initialization() {

    }

    @Override
    protected int getVariableId() {
        return 0;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_lottie;
    }
}
