package com.example.sztangli.widgedemo.video;

import android.os.Bundle;
import android.view.View;

import com.example.sztangli.widgedemo.R;
import com.example.sztangli.widgedemo.utils.ActivityUtils;
import com.guyuan.handlein.base.ui.activity.BaseToolbarActivity;

import cn.jzvd.Jzvd;

/**
 * created by com.tl on 2019-1-21
 */
public class VideoActivity extends BaseToolbarActivity {

    public void onBackPressed() {
        if (Jzvd.backPress()) {
            return;
        }
        super.onBackPressed();
    }


    public void onPause() {
        super.onPause();
        Jzvd.releaseAllVideos();
    }

    @Override
    protected void initFragment(Bundle savedInstanceState) {

        // VideoFragment videoFragment = VideoFragment.newInstance();
        VideoJZFragment videoFragment = VideoJZFragment.newInstance();
        ActivityUtils.addFragmentToActivity(fragmentManager, videoFragment,
                R.id.container, VideoFragment.TAG);

        back_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Jzvd.backPress()) {
                    return;
                }
                finish();
            }
        });

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
