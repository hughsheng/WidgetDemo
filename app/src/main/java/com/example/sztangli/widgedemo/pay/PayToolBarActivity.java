package com.example.sztangli.widgedemo.pay;

import android.os.Bundle;

import com.alipay.sdk.app.EnvUtils;
import com.example.mvvmlibrary.base.data.BaseViewModel;
import com.example.sztangli.widgedemo.home.MainToolBarActivity;
import com.example.sztangli.widgedemo.R;
import com.example.sztangli.widgedemo.utils.ActivityUtils;
import com.guyuan.handlein.base.databinding.ActivityWithToolbarBinding;
import com.guyuan.handlein.base.ui.activity.BaseToolbarActivity;

public class PayToolBarActivity extends BaseToolbarActivity<ActivityWithToolbarBinding, BaseViewModel> {

    @Override
    protected void initFragment(Bundle savedInstanceState) {
        //支付宝沙箱测试开启下面这行代码，正式环境必须去掉该行代码
        EnvUtils.setEnv(EnvUtils.EnvEnum.SANDBOX);
        setTitleCenter(getIntent().getStringExtra(MainToolBarActivity.TITLE));
        PayFragment payFragment = PayFragment.newInstance();
        ActivityUtils.addFragmentToActivity(fragmentManager, payFragment, R.id.fragment_container,
                PayFragment.TAG);
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
