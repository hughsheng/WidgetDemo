package com.example.sztangli.widgedemo.weather.data;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.MutableLiveData;

import com.example.mvvmlibrary.base.data.BaseViewModel;
import com.example.sztangli.widgedemo.weather.api.WeatherApiService;
import com.guyuan.handlein.base.api.RxJavaHelper;

import kotlin.jvm.internal.PropertyReference0Impl;

/**
 * @author : 唐力
 * @description :
 * @since: 2020/12/29 17:06
 * @company : 固远（深圳）信息技术有限公司
 **/

public class WeatherViewModel extends BaseViewModel {
    private WeatherApiService weatherApiService;
    private MutableLiveData<WeatherBean> weatherBeanMLD = new MutableLiveData<>();

    @ViewModelInject
    public WeatherViewModel(WeatherApiService weatherApiService) {
        this.weatherApiService = weatherApiService;
    }

    //获取天气
    public void getWeather(String city) {
        RxJavaHelper.build(this, weatherApiService.getWeather(city))
                .getHelper().flow(weatherBeanMLD);
    }
}