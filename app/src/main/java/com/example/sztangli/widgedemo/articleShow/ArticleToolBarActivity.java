package com.example.sztangli.widgedemo.articleShow;

import android.os.Bundle;

import com.example.sztangli.widgedemo.MainToolBarActivity;
import com.example.sztangli.widgedemo.R;
import com.example.sztangli.widgedemo.base.activity.BaseToolBarActivity;
import com.example.sztangli.widgedemo.utils.ActivityUtils;

/**
 * Created by sztangli on 2017/9/15.
 */

public class ArticleToolBarActivity extends BaseToolBarActivity {
    @Override
    public int getLayoutResId() {
        return R.layout.activity_base;
    }

    @Override
    public void initalFragment(Bundle savedInstanceState) {
        setTitleCenter(getIntent().getStringExtra(MainToolBarActivity.TITLE));
        ArticFragment fragment=ArticFragment.newInstance();
        ActivityUtils.addFragmentToActivity(mFragmentManager,fragment,R.id.container,ArticFragment.TAG);
    }
}
