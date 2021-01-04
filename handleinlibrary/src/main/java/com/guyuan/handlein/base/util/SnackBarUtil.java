package com.guyuan.handlein.base.util;

import android.view.View;

import com.google.android.material.snackbar.Snackbar;

/**
 * @author : 唐力
 * @description :
 * @since: 2020/12/28 15:16
 * @company : 固远（深圳）信息技术有限公司
 **/

public class SnackBarUtil {
    public static void showSnackBarTip(View rootView, String message) {
        Snackbar.make(rootView, message, Snackbar.LENGTH_SHORT).show();
    }

    public static void showSnackBarTip(View rootView,int resId) {
        Snackbar.make(rootView, resId, Snackbar.LENGTH_SHORT).show();
    }
}