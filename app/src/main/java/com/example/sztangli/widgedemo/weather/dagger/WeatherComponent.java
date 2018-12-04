package com.example.sztangli.widgedemo.weather.dagger;

import com.example.sztangli.widgedemo.base.scope.FragmentScoped;
import com.example.sztangli.widgedemo.weather.WeatherActivity;

import dagger.Subcomponent;

/**
 * created by tl on 2018-10-23
 */
@FragmentScoped
@Subcomponent(modules = WeatherModule.class)
public interface WeatherComponent {
  void inject(WeatherActivity weatherActivity);
}
