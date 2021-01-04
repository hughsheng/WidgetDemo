package com.example.sztangli.widgedemo.articleShow;

import android.os.Bundle;

import com.example.sztangli.widgedemo.home.MainToolBarActivity;
import com.example.sztangli.widgedemo.R;
import com.example.sztangli.widgedemo.utils.ActivityUtils;
import com.guyuan.handlein.base.ui.activity.BaseToolbarActivity;

/**
 * Created by sztangli on 2017/9/15.
 */

public class ArticleToolBarActivity extends BaseToolbarActivity {

    @Override
    protected void initFragment(Bundle savedInstanceState) {
        setTitleCenter(getIntent().getStringExtra(MainToolBarActivity.TITLE));
        ArticFragment fragment=ArticFragment.newInstance();
        ActivityUtils.addFragmentToActivity(fragmentManager,fragment,R.id.container,ArticFragment.TAG);
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
