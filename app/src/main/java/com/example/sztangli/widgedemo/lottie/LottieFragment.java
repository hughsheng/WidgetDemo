package com.example.sztangli.widgedemo.lottie;

import android.os.Bundle;
import android.view.View;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.LottieTask;
import com.example.sztangli.widgedemo.R;
import com.example.mvvmlibrary.base.data.BaseViewModel;
import com.example.sztangli.widgedemo.base.app.WidgetDemoApplication;
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
        LottieDrawable lottieDrawable = new LottieDrawable();
        LottieTask<LottieComposition> lottieTask = LottieCompositionFactory.
                fromRawRes(WidgetDemoApplication.getInstance(), R.raw.type1);
        lottieTask.addListener(new LottieListener<LottieComposition>() {
            @Override
            public void onResult(LottieComposition result) {
                lottieDrawable.setComposition(result);
                binding.iv.setImageDrawable(lottieDrawable);
                lottieDrawable.start();
            }
        });

        binding.iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lottieDrawable.start();
            }
        });
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
