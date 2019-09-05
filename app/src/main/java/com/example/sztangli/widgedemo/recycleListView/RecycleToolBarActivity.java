package com.example.sztangli.widgedemo.recycleListView;

import android.os.Bundle;

import com.example.sztangli.widgedemo.home.MainToolBarActivity;
import com.example.sztangli.widgedemo.R;
import com.example.sztangli.widgedemo.base.activity.BaseToolBarActivity;
import com.example.sztangli.widgedemo.utils.ActivityUtils;

/**
 * Created by sztangli on 2017/8/15.
 */

public class RecycleToolBarActivity extends BaseToolBarActivity {
    @Override
    public int getLayoutResId() {
        return R.layout.activity_base;
    }

    @Override
    public void initalFragment(Bundle savedInstanceState) {
       setTitleCenter(getIntent().getStringExtra(MainToolBarActivity.TITLE));
       RecycleFragment fragment=RecycleFragment.newInstance();
        ActivityUtils.addFragmentToActivity(mFragmentManager,fragment,R.id.container,RecycleFragment.TAG);
    }
}
