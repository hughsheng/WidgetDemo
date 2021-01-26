package com.example.sztangli.widgedemo.recycleListView;

import android.os.Bundle;

import com.example.mvvmlibrary.base.data.BaseViewModel;
import com.example.sztangli.widgedemo.home.MainToolBarActivity;
import com.example.sztangli.widgedemo.R;
import com.example.sztangli.widgedemo.utils.ActivityUtils;
import com.guyuan.handlein.base.databinding.ActivityWithToolbarBinding;
import com.guyuan.handlein.base.ui.activity.BaseToolbarActivity;

/**
 * Created by sztangli on 2017/8/15.
 */

public class RecycleToolBarActivity extends BaseToolbarActivity<ActivityWithToolbarBinding, BaseViewModel> {


    @Override
    protected void initFragment(Bundle savedInstanceState) {
        setTitleCenter(getIntent().getStringExtra(MainToolBarActivity.TITLE));
        RecycleFragment fragment = RecycleFragment.newInstance();
        ActivityUtils.addFragmentToActivity(fragmentManager, fragment, R.id.fragment_container, RecycleFragment.TAG);
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_with_toolbar;
    }

    @Override
    protected int getVariableId() {
        return 0;
    }
}
