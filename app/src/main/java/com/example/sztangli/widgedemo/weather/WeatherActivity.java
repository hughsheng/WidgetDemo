package com.example.sztangli.widgedemo.weather;

import android.os.Bundle;

import com.example.sztangli.widgedemo.home.MainToolBarActivity;
import com.example.sztangli.widgedemo.R;
import com.example.sztangli.widgedemo.base.activity.BaseToolBarActivity;
import com.example.sztangli.widgedemo.utils.ActivityUtils;
import com.example.sztangli.widgedemo.weather.dagger.WeatherModule;
import com.example.sztangli.widgedemo.weather.mvp.WeatherPresenter;

import javax.inject.Inject;

/**
 * created by tl on 2018-10-23
 */
public class WeatherActivity extends BaseToolBarActivity {

  @Inject
  WeatherPresenter mPresenter;

  @Override
  public int getLayoutResId() {
    return R.layout.activity_base;
  }


  @Override
  public void initalFragment(Bundle savedInstanceState) {
    String title = getIntent().getStringExtra(MainToolBarActivity.TITLE);
    setTitleCenter(title);
    WeatherFragment mFragment = WeatherFragment.newInstance();
    ActivityUtils.addFragmentToActivity(mFragmentManager, mFragment, R.id.container,
        WeatherFragment.TAG);
    getApiServiceComponent().getWeatherComponent(new WeatherModule(mFragment))
        .inject(this);
  }

}
