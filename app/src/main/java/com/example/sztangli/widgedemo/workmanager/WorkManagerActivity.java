package com.example.sztangli.widgedemo.workmanager;

import android.os.Bundle;

import com.example.mvvmlibrary.base.data.BaseViewModel;
import com.example.sztangli.widgedemo.R;
import com.guyuan.handlein.base.databinding.ActivityWithToolbarBinding;
import com.guyuan.handlein.base.ui.activity.BaseToolbarActivity;


/**
 * created by com.tl
 * created at 2020/6/8
 */
public class WorkManagerActivity extends BaseToolbarActivity<ActivityWithToolbarBinding, BaseViewModel> {

    @Override
    protected void initFragment(Bundle savedInstanceState) {

    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_with_toolbar;
    }

    @Override
    protected int getVariableId() {
        return 0;
    }
}
