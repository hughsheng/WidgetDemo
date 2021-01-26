package com.example.sztangli.widgedemo.floatingButtom;

import android.os.Bundle;

import com.example.mvvmlibrary.base.data.BaseViewModel;
import com.example.sztangli.widgedemo.databinding.FragmentFloatingbuttonBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import android.view.View;
import android.widget.Toast;

import com.example.sztangli.widgedemo.R;
import com.example.sztangli.widgedemo.utils.AnimationUtil;
import com.guyuan.handlein.base.ui.fragment.BaseFragment;

import butterknife.BindView;

/**
 * Created by sztangli on 2017/7/24.
 */

public class FloatingButtonFragment extends BaseFragment<FragmentFloatingbuttonBinding, BaseViewModel> {

    public static final String TAG = "FloatingButtonFragment";

    public static FloatingButtonFragment newInstance() {

        Bundle args = new Bundle();

        FloatingButtonFragment fragment = new FloatingButtonFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initialization() {
        binding.floatingActionButton.registerButton(binding.floatingActionButtonLiveness);
        binding.floatingActionButton.registerButton(binding.floatingActionButton2);
        binding.floatingActionButton.registerButton(binding.floatingActionButton3);
        binding.floatingActionButton.registerButton(binding.floatingActionButton4);
        binding.floatingActionButton.registerButton(binding.floatingActionButton5);
        binding.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                //弹出动态Button
                AnimationUtil.slideButtons(getActivity(), binding.floatingActionButton);
            }
        });
        binding.floatingActionButtonLiveness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {        //关闭动态Button
                AnimationUtil.slideButtons(getActivity(), binding.floatingActionButton);
                Toast.makeText(getContext(), "liveness", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected int getVariableId() {
        return 0;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_floatingbutton;
    }
}
