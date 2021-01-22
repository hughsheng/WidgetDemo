package com.example.sztangli.widgedemo.base.api;

import com.example.sztangli.widgedemo.base.app.WidgetDemoApplication;
import com.guyuan.handlein.base.app.HandleInApplication;
import retrofit2.Retrofit;

/**
 * @author : tl
 * @description : module基类，提供一些通用对象
 * @since: 2020/9/7
 * @company : 固远（深圳）信息技术有限公司
 **/

public class BaseModule {
    public Retrofit retrofit = WidgetDemoApplication.getInstance().getRetrofit();
}
