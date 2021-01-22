package com.example.sztangli.widgedemo.base.app;

import com.example.httplibrary.BaseApiServiceModule;
import com.example.sztangli.widgedemo.BuildConfig;
import com.guyuan.handlein.base.app.HandleInApplication;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.hilt.android.HiltAndroidApp;
import retrofit2.Retrofit;

/**
 * @author : 唐力
 * @description :
 * @since: 2021/1/21 16:45
 * @company : 固远（深圳）信息技术有限公司
 **/

@HiltAndroidApp
public class WidgetDemoApplication extends HandleInApplication {
    @Inject
    Retrofit retrofit;
    @Inject
    @Named(BaseApiServiceModule.WITHOUT_CERTIFICATE)
    Retrofit debugRetrofit;


    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public Retrofit getRetrofit() {
        {
            if (DEBUG.equals(BuildConfig.BUILD_TYPE)) {
                return debugRetrofit;
            } else {
                return retrofit;
            }
        }
    }
}