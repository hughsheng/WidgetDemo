package com.example.sztangli.widgedemo.floatingButtom;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.Toast;

import com.example.sztangli.widgedemo.R;
import com.example.sztangli.widgedemo.base.fragment.BaseFragment;
import com.example.sztangli.widgedemo.utils.AnimationUtil;

import butterknife.BindView;

/**
 * Created by sztangli on 2017/7/24.
 */

public class FloatingButtonFragment extends BaseFragment {
    @BindView(R.id.floatingActionButton)
    FloatingDraftButton floatingDraftButton;
    @BindView(R.id.floatingActionButton_liveness)
    FloatingActionButton liveness;
    @BindView(R.id.floatingActionButton_2)
    FloatingActionButton floatingActionButton2;
    @BindView(R.id.floatingActionButton_3)
    FloatingActionButton floatingActionButton3;
    @BindView(R.id.floatingActionButton_4)
    FloatingActionButton floatingActionButton4;
    @BindView(R.id.floatingActionButton_5)
    FloatingActionButton floatingActionButton5;
    public static final String TAG = "FloatingButtonFragment";

    public static FloatingButtonFragment newInstance() {

        Bundle args = new Bundle();

        FloatingButtonFragment fragment = new FloatingButtonFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_floatingbutton;
    }

    @Override
    public void onUnBind() {

    }

    @Override
    public void initialization() {
        floatingDraftButton.registerButton(liveness);
        floatingDraftButton.registerButton(floatingActionButton2);
        floatingDraftButton.registerButton(floatingActionButton3);
        floatingDraftButton.registerButton(floatingActionButton4);
        floatingDraftButton.registerButton(floatingActionButton5);
        floatingDraftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                //弹出动态Button
                AnimationUtil.slideButtons(getActivity(), floatingDraftButton);
            }
        });
        liveness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {        //关闭动态Button
                AnimationUtil.slideButtons(getActivity(), floatingDraftButton);
                Toast.makeText(getContext(), "liveness", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
