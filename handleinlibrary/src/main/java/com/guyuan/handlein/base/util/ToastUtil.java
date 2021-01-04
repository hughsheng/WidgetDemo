package com.guyuan.handlein.base.util;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

/**
 * @author : 唐力
 * @description :
 * @since: 2020/12/28 15:18
 * @company : 固远（深圳）信息技术有限公司
 **/

public class ToastUtil {
    public static void showToastTip(Context context, int resId) {
        String txt = context.getString(resId);
        showToastTip(context,txt);
    }

    public static void showToastTip(Context context, String message) {
        //第二个参数设为null，解决小米手机toast显示app名的问题
        Toast toast = Toast.makeText(context, null, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.setText(message);
        toast.show();
    }

    public static void showToastTip(Context context, String tip, int gravity) {
        Toast toast = Toast.makeText(context, null, Toast.LENGTH_SHORT);
        toast.setGravity(gravity, 0, 0);
        toast.setText(tip);
        toast.show();
    }
}