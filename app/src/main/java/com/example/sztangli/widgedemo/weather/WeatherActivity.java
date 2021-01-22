package com.example.sztangli.widgedemo.weather;

import android.os.Bundle;

import com.example.sztangli.widgedemo.home.MainToolBarActivity;
import com.example.sztangli.widgedemo.R;
import com.example.sztangli.widgedemo.utils.ActivityUtils;
import com.example.sztangli.widgedemo.weather.data.WeatherViewModel;
import com.guyuan.handlein.base.databinding.ActivityWithToolbarBinding;
import com.guyuan.handlein.base.databinding.ActivityWithoutToolbarBinding;
import com.guyuan.handlein.base.ui.activity.BaseNoToolbarActivity;
import com.guyuan.handlein.base.ui.activity.BaseToolbarActivity;


import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

/**
 * created by com.tl on 2018-10-23
 */
@AndroidEntryPoint
public class WeatherActivity extends BaseNoToolbarActivity<ActivityWithoutToolbarBinding, WeatherViewModel> {

    @Override
    protected void initFragment(Bundle savedInstanceState) {

        String title = getIntent().getStringExtra(MainToolBarActivity.TITLE);
        //setTitleCenter(title);

        WeatherFragment mFragment = WeatherFragment.newInstance();
        ActivityUtils.addFragmentToActivity(fragmentManager, mFragment, R.id.fragment_container, WeatherFragment.TAG);
    }


    @Override
    protected int getLayoutID() {
        return R.layout.activity_without_toolbar;
    }

    @Override
    protected int getVariableId() {
        return 0;
    }

}
