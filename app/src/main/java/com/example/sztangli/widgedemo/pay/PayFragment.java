package com.example.sztangli.widgedemo.pay;

import android.os.Bundle;
import android.support.v7.widget.AppCompatRadioButton;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.sztangli.widgedemo.R;
import com.example.sztangli.widgedemo.base.fragment.BaseFragment;
import com.example.sztangli.widgedemo.pay.alipay.AliPayUtil;
import com.example.sztangli.widgedemo.pay.alipay.PayResult;

import java.util.Map;

import butterknife.BindView;

public class PayFragment extends BaseFragment implements CompoundButton.OnCheckedChangeListener,
    AliPayUtil.AliPayResponseListener {

  @BindView(R.id.rbtn_wx)
  AppCompatRadioButton rbtn_wx;
  @BindView(R.id.rbtn_zfb)
  AppCompatRadioButton rbtn_zfb;
  @BindView(R.id.pay_btn)
  Button pay_btn;

  public static final String TAG = "PayFragment";
  private AliPayUtil aliPayUtil;

  public static PayFragment newInstance() {

    Bundle args = new Bundle();

    PayFragment fragment = new PayFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public int getLayoutResId() {
    return R.layout.fragment_pay;
  }

  @Override
  public void onUnBind() {

  }

  @Override
  public void initialization() {
    aliPayUtil = new AliPayUtil(getActivity());
    aliPayUtil.setPaySuccessListener(this);

    rbtn_wx.setOnCheckedChangeListener(this);
    rbtn_zfb.setOnCheckedChangeListener(this);
    pay_btn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (rbtn_wx.isChecked()) {//微信支付

        } else if (rbtn_zfb.isChecked()) {//支付宝支付
          aliPayUtil.payV2(rbtn_zfb);
        }
      }
    });
  }

  @Override
  public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
    switch (buttonView.getId()) {
      case R.id.rbtn_wx:
        if (isChecked) {
          rbtn_zfb.setChecked(false);
        }

        break;

      case R.id.rbtn_zfb:
        if (isChecked) {
          rbtn_wx.setChecked(false);
        }
        break;
    }
  }

  /**
   * 支付宝支付接口同步返回结果
   *
   * @param result (支付宝支付结果)
   */
  @Override
  public void onAliPayResult(Map<String, String> result) {
    @SuppressWarnings("unchecked")
    PayResult payResult = new PayResult((Map<String, String>) result);

    /**
     对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。
     */
    String resultInfo = payResult.getResult();// 同步返回需要验证的信息
    String resultStatus = payResult.getResultStatus();
    // 判断resultStatus 为9000则代表支付成功
    if (TextUtils.equals(resultStatus, "9000")) {
      // 该笔订单是否真实支付成功，需要依赖服务端的异步通知。
      Toast.makeText(getContext(), "支付成功", Toast.LENGTH_SHORT).show();
    } else {
      // 该笔订单真实的支付结果，需要依赖服务端的异步通知。
      Toast.makeText(getContext(), "支付失败", Toast.LENGTH_SHORT).show();
    }

  }


  @Override
  public void onDetach() {
    super.onDetach();
    aliPayUtil.destroy();
  }
}

