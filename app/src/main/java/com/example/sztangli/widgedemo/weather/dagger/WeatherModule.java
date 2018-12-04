package com.example.sztangli.widgedemo.weather.dagger;

import com.example.sztangli.widgedemo.base.scope.FragmentScoped;
import com.example.sztangli.widgedemo.weather.api.WeatherApiService;
import com.example.sztangli.widgedemo.weather.mvp.WeatherContract;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * created by tl on 2018-10-23
 */
@Module
public class WeatherModule {
  private WeatherContract.IView mIView;

  public WeatherModule(WeatherContract.IView mIView) {
    this.mIView = mIView;
  }

  @FragmentScoped
  @Provides
  WeatherContract.IView providesWeatherContractIView() {
    return mIView;
  }

  @FragmentScoped
  @Provides
  WeatherApiService getWeatherApiService(Retrofit retrofit) {
    return retrofit.create(WeatherApiService.class);
  }

}
