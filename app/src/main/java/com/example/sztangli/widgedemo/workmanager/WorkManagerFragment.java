package com.example.sztangli.widgedemo.workmanager;

import android.os.Bundle;

import com.guyuan.handlein.base.ui.fragment.BaseFragment;


/**
 * created by com.tl
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
    public void initialization() {

    }

    @Override
    protected int getVariableId() {
        return 0;
    }

    @Override
    protected int getLayoutID() {
        return 0;
    }
}
