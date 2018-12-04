package com.example.sztangli.widgedemo.floatingButtom;

import android.os.Bundle;

import com.example.sztangli.widgedemo.MainToolBarActivity;
import com.example.sztangli.widgedemo.R;
import com.example.sztangli.widgedemo.base.activity.BaseToolBarActivity;
import com.example.sztangli.widgedemo.utils.ActivityUtils;

/**
 * Created by sztangli on 2017/7/24.
 */

public class FloatingButtonToolBarActivity extends BaseToolBarActivity {

    @Override
    public int getLayoutResId() {
        return R.layout.activity_base;
    }

    @Override
    public void initalFragment(Bundle savedInstanceState) {
        setTitleCenter(getIntent().getStringExtra(MainToolBarActivity.TITLE));
      FloatingButtonFragment fragment=FloatingButtonFragment.newInstance();
        ActivityUtils.addFragmentToActivity(mFragmentManager,fragment,R.id.container,
                FloatingButtonFragment.TAG);
    }
}
