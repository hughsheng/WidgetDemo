package com.example.sztangli.widgedemo.wxapi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.FrameLayout;

import com.example.sztangli.widgedemo.BuildConfig;
import com.example.sztangli.widgedemo.R;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 微信支付回调activity
 */
public class WXPayEntryActivity extends FragmentActivity implements
    IWXAPIEventHandler {

  private static final String TAG = "WXPayEntryActivity";
  protected Unbinder mUnbinder;
  @BindView(R.id.wxpay_result_container)
  FrameLayout wxpay_result_container;
  private IWXAPI api;


  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.wxpay_result);
    mUnbinder = ButterKnife.bind(this);
    api = WXAPIFactory.createWXAPI(this, BuildConfig.WEIXIN_KEY);
    api.handleIntent(getIntent(), this);
    Log.e(TAG, "WXPayEntryActivity");
  }

  @Override
  protected void onNewIntent(Intent intent) {
    super.onNewIntent(intent);
    setIntent(intent);
    api.handleIntent(intent, this);
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    api.unregisterApp();
    api.detach();
    api = null;
    mUnbinder.unbind();
    mUnbinder = null;
  }

  @Override
  public void onReq(BaseReq req) {
  }


  /**
   * 是一个activity，去哪儿是用了一个dialog，然后把activity的风格变成了透明的窗口话!
   * <p/>
   * 微信支付没有同步返回相应的结果，只返回给了服务器
   */
  @Override
  public void onResp(BaseResp resp) {
    Log.e(TAG, "WXPayEntryActivity====onResp" + resp.toString());
    Log.e(TAG, "WXPayEntryActivity====onResp" + resp.errStr);

    if (resp.getType() == ConstantsAPI.COMMAND_PAY_BY_WX) {// 点击完成的时候执行
      int resultCode = resp.errCode;
      if (resultCode == 0) {// 成功

      }
    }
  }

  @Override
  public void onBackPressed() {
    super.onBackPressed();
  }

}