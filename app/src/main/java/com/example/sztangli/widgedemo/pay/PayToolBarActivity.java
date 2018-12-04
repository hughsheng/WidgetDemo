package com.example.sztangli.widgedemo.pay;

import android.os.Bundle;

import com.alipay.sdk.app.EnvUtils;
import com.example.sztangli.widgedemo.MainToolBarActivity;
import com.example.sztangli.widgedemo.R;
import com.example.sztangli.widgedemo.base.activity.BaseToolBarActivity;
import com.example.sztangli.widgedemo.utils.ActivityUtils;

public class PayToolBarActivity extends BaseToolBarActivity {
  @Override
  public int getLayoutResId() {
    return R.layout.activity_base;
  }

  @Override
  public void initalFragment(Bundle savedInstanceState) {
    //支付宝沙箱测试开启下面这行代码，正式环境必须去掉该行代码
    EnvUtils.setEnv(EnvUtils.EnvEnum.SANDBOX);
    setTitleCenter(getIntent().getStringExtra(MainToolBarActivity.TITLE));
    PayFragment payFragment = PayFragment.newInstance();
    ActivityUtils.addFragmentToActivity(mFragmentManager, payFragment, R.id.container,
        PayFragment.TAG);
  }
}
