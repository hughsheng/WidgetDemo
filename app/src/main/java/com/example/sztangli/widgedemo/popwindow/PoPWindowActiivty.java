package com.example.sztangli.widgedemo.popwindow;

import android.os.Bundle;

import com.example.sztangli.widgedemo.MainToolBarActivity;
import com.example.sztangli.widgedemo.R;
import com.example.sztangli.widgedemo.base.activity.BaseToolBarActivity;
import com.example.sztangli.widgedemo.utils.ActivityUtils;

/**
 * Created by sztangli on 2017/8/10.
 */

public class PoPWindowActiivty extends BaseToolBarActivity {
    @Override
    public int getLayoutResId() {
        return R.layout.activity_base;
    }

    @Override
    public void initalFragment(Bundle savedInstanceState) {
        setTitleCenter(getIntent().getStringExtra(MainToolBarActivity.TITLE));
        PopWindowFragment fragment=PopWindowFragment.newInstance();
        ActivityUtils.addFragmentToActivity(mFragmentManager,fragment,R.id.container,PopWindowFragment.TAG);
    }
}
