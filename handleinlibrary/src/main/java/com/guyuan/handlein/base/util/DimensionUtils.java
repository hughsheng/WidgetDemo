package com.guyuan.handlein.base.util;

import android.util.DisplayMetrics;

import com.guyuan.handlein.base.app.HandleInApplication;

/**
 * @author: 廖华凯
 * @description:
 * @since: 2020/10/13 16:18
 * @company: 固远（深圳）信息技术有限公司
 **/
public class DimensionUtils {
    public static float dp2px(float dp) {
        DisplayMetrics metrics = HandleInApplication.getInstance().getDisplayMetrics();
        float density = metrics.density;
        return dp * density;
    }
}
