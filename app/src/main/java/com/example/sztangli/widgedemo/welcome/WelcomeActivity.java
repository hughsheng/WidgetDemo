package com.example.sztangli.widgedemo.welcome;

import android.content.Intent;
import android.os.Bundle;

import com.example.mvvmlibrary.base.data.BaseViewModel;
import com.example.sztangli.widgedemo.home.MainToolBarActivity;
import com.guyuan.handlein.base.databinding.ActivityWithoutToolbarBinding;
import com.guyuan.handlein.base.ui.activity.BaseNoToolbarActivity;

/**
 * created by com.tl on 2018-12-4
 */
public class WelcomeActivity extends BaseNoToolbarActivity<ActivityWithoutToolbarBinding, BaseViewModel> {
    @Override
    protected void initFragment(Bundle savedInstanceState) {
        startActivity(new Intent(this, MainToolBarActivity.class));
        finish();
    }

    @Override
    protected int getLayoutID() {
        return 0;
    }

    @Override
    protected int getVariableId() {
        return 0;
    }
}
