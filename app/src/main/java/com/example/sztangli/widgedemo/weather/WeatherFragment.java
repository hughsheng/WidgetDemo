package com.example.sztangli.widgedemo.weather;

import android.os.Bundle;

import com.example.sztangli.widgedemo.BR;
import com.example.sztangli.widgedemo.R;
import com.example.sztangli.widgedemo.databinding.FragmentWeatherBinding;
import com.example.sztangli.widgedemo.weather.data.WeatherViewModel;
import com.guyuan.handlein.base.ui.fragment.BaseFragment;

/**
 * created by com.tl on 2018-10-23
 */
public class WeatherFragment extends BaseFragment<FragmentWeatherBinding, WeatherViewModel> {
    public static final String TAG = "WeatherFragment";

    public static WeatherFragment newInstance() {

        Bundle args = new Bundle();

        WeatherFragment fragment = new WeatherFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initialization() {
        if (viewModel != null) {
            viewModel.getPoetry();
        }
    }

    @Override
    protected int getVariableId() {
        return BR.weatherViewModel;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_weather;
    }
}
