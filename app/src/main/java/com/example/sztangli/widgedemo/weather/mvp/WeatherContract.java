package com.example.sztangli.widgedemo.weather.mvp;

import com.example.sztangli.widgedemo.base.mvp.BasePresenter;
import com.example.sztangli.widgedemo.base.mvp.BaseView;

/**
 * created by tl on 2018-10-23
 */
public interface WeatherContract {

  interface IView extends BaseView<Presenter> {
    void getWeatherSuccess(WeatherBean weatherBean);
  }

  interface Presenter extends BasePresenter {
    void getWeather(String city);
  }


}
