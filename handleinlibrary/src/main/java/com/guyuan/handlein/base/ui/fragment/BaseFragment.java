package com.guyuan.handlein.base.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentManager;

import com.example.mvvmlibrary.base.fragment.BaseDataBindingFragment;
import com.guyuan.handlein.base.util.AlertDialogUtils;
import com.guyuan.handlein.base.util.SnackBarUtil;
import com.guyuan.handlein.base.util.ToastUtil;
import com.example.mvvmlibrary.base.data.BaseViewModel;


/**
 * created by com.tl
 * created at 2020/8/12
 */
public abstract class BaseFragment<VB extends ViewDataBinding, VM extends BaseViewModel> extends
        BaseDataBindingFragment<VB, VM> {

    protected AlertDialog loadingDialog;
    protected View rootView;
    protected FragmentManager childFragmentManager;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        childFragmentManager = getChildFragmentManager();
        initialization();
    }


    protected abstract void initialization();

    public void showToastTip(int resId) {
        ToastUtil.showToastTip(getContext(), resId);
    }

    public void showToastTip(String message) {
        ToastUtil.showToastTip(getContext(), message);
    }

    public void showToastTip(String tip, int gravity) {
        ToastUtil.showToastTip(getContext(), tip, gravity);
    }


    public void showSnackBarTip(String message) {
        SnackBarUtil.showSnackBarTip(rootView, message);
    }

    public void showSnackBarTip(int resId) {
        SnackBarUtil.showSnackBarTip(rootView, resId);
    }

    public void showLoading(FragmentManager manager) {
        hideLoading();
        loadingDialog = AlertDialogUtils.showLoading(getContext(), null, null);
    }

    public void showLoadingWithStatus(FragmentManager manager, String status) {
        hideLoading();
        loadingDialog = AlertDialogUtils.showLoading(getContext(), null, status);
    }

    public void hideLoading() {
        if (loadingDialog != null) {
            loadingDialog.dismiss();
            loadingDialog = null;
        }
    }

}
