package com.example.sztangli.widgedemo.weather.hilt;

import com.example.sztangli.widgedemo.weather.api.WeatherApiService;
import com.guyuan.handlein.base.api.BaseModule;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;

/**
 * created by com.tl on 2018-10-23
 */
@Module
@InstallIn(ActivityComponent.class)
public class WeatherModule extends BaseModule {

    @Provides
    WeatherApiService getWeatherApiService() {
        return retrofit.create(WeatherApiService.class);
    }

}
