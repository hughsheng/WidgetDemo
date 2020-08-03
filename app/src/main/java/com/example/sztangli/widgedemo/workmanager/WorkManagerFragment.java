package com.example.sztangli.widgedemo.workmanager;

import android.os.Bundle;

import com.example.sztangli.widgedemo.base.fragment.BaseFragment;

/**
 * created by tl
 * created at 2020/6/8
 */
public class WorkManagerFragment extends BaseFragment {

    public static final String TAG = "WorkManagerFragment";

    public static WorkManagerFragment newInstance() {

        Bundle args = new Bundle();

        WorkManagerFragment fragment = new WorkManagerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutResId() {
        return 0;
    }

    @Override
    public void onUnBind() {

    }

    @Override
    public void initialization() {

    }
}
