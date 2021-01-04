package com.example.sztangli.widgedemo.floatingButtom;

import android.os.Bundle;

import com.example.sztangli.widgedemo.home.MainToolBarActivity;
import com.example.sztangli.widgedemo.R;
import com.example.sztangli.widgedemo.utils.ActivityUtils;
import com.guyuan.handlein.base.ui.activity.BaseToolbarActivity;

/**
 * Created by sztangli on 2017/7/24.
 */

public class FloatingButtonToolBarActivity extends BaseToolbarActivity {

    @Override
    protected void initFragment(Bundle savedInstanceState) {
        setTitleCenter(getIntent().getStringExtra(MainToolBarActivity.TITLE));
        FloatingButtonFragment fragment=FloatingButtonFragment.newInstance();
        ActivityUtils.addFragmentToActivity(fragmentManager,fragment,R.id.container,
                FloatingButtonFragment.TAG);
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_base;
    }

    @Override
    protected int getVariableId() {
        return 0;
    }
}
