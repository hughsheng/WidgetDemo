package com.guyuan.handlein.base.ui.activity;

import android.os.Bundle;

import androidx.databinding.ViewDataBinding;

import com.example.mvvmlibrary.base.data.BaseViewModel;


/**
 * @author : com.tl
 * @description :
 * @since: 2020/9/7
 * @company : 固远（深圳）信息技术有限公司
 **/
public abstract class BaseNoToolbarActivity<V extends ViewDataBinding, VM extends BaseViewModel> extends BaseActivity<V, VM> {

    @Override
    protected void init(Bundle savedInstanceState) {
        initFragment(savedInstanceState);
    }

    protected abstract void initFragment(Bundle savedInstanceState);
}
