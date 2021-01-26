package com.example.sztangli.widgedemo.pay;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatRadioButton;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.mvvmlibrary.base.data.BaseViewModel;
import com.example.sztangli.widgedemo.BuildConfig;
import com.example.sztangli.widgedemo.R;
import com.example.sztangli.widgedemo.databinding.FragmentPayBinding;
import com.example.sztangli.widgedemo.pay.alipay.AliPayUtil;
import com.example.sztangli.widgedemo.pay.alipay.PayResult;
import com.guyuan.handlein.base.ui.fragment.BaseFragment;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import java.util.Map;

import butterknife.BindView;

public class PayFragment extends BaseFragment<FragmentPayBinding, BaseViewModel> implements CompoundButton.OnCheckedChangeListener,
        AliPayUtil.AliPayResponseListener {

    public static final String TAG = "PayFragment";
    private AliPayUtil aliPayUtil;
    private IWXAPI api;

    public static PayFragment newInstance() {

        Bundle args = new Bundle();

        PayFragment fragment = new PayFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void initialization() {
        aliPayUtil = new AliPayUtil(getActivity());
        aliPayUtil.setPaySuccessListener(this);
        api = WXAPIFactory.createWXAPI(getContext(), BuildConfig.WEIXIN_KEY);
        api.registerApp(BuildConfig.WEIXIN_KEY);
        binding.rbtnWx.setOnCheckedChangeListener(this);
        binding.rbtnZfb.setOnCheckedChangeListener(this);
        binding.payBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.rbtnWx.isChecked()) {//微信支付
                    PayReq request = new PayReq();
                    request.appId = BuildConfig.WEIXIN_KEY;
                    request.partnerId = "1900000109";
                    request.prepayId = "1101000000140415649af9fc314aa427";
                    request.packageValue = "Sign=WXPay";
                    request.nonceStr = "1101000000140429eb40476f8896f4c9";
                    request.timeStamp = "1398746574";
                    request.sign = "7FFECB600D7157C5AA49810D2D8F28BC2811827B";
                    api.sendReq(request);
                } else if (binding.rbtnZfb.isChecked()) {//支付宝支付
                    aliPayUtil.payV2(binding.rbtnZfb);
                }
            }
        });
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.rbtn_wx:
                if (isChecked) {
                    binding.rbtnZfb.setChecked(false);
                }

                break;

            case R.id.rbtn_zfb:
                if (isChecked) {
                    binding.rbtnWx.setChecked(false);
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

    //判断是否安装微信
    private boolean isWXAppInstalledAndSupported() {
        return api.isWXAppInstalled() && api.getWXAppSupportAPI() >= Build.PAY_SUPPORTED_SDK_INT;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        aliPayUtil.destroy();
    }

    @Override
    protected int getVariableId() {
        return 0;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_pay;
    }
}

