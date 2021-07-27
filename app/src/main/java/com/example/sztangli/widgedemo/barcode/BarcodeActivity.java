package com.example.sztangli.widgedemo.barcode;

import android.os.Bundle;

import com.example.sztangli.widgedemo.R;
import com.example.mvvmlibrary.base.data.BaseViewModel;
import com.example.sztangli.widgedemo.databinding.ActivityBaseBinding;
import com.example.sztangli.widgedemo.utils.ActivityUtils;
import com.guyuan.handlein.base.databinding.ActivityWithToolbarBinding;
import com.guyuan.handlein.base.ui.activity.BaseActivity;
import com.guyuan.handlein.base.ui.activity.BaseToolbarActivity;

public class BarcodeActivity extends BaseToolbarActivity<ActivityWithToolbarBinding, BaseViewModel> {

    private BarcodeFragment barcodeFragment;

    @Override
    protected void initFragment(Bundle savedInstanceState) {
        barcodeFragment = BarcodeFragment.newInstance();
        ActivityUtils.addFragmentToActivity(fragmentManager, barcodeFragment,R.id.container ,BarcodeFragment.TAG);
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
