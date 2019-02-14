package com.example.sztangli.widgedemo.weather;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.widget.TextView;

import com.example.sztangli.widgedemo.R;
import com.example.sztangli.widgedemo.base.api.bean.ErrorResultBean;
import com.example.sztangli.widgedemo.base.fragment.BaseFragment;
import com.example.sztangli.widgedemo.dialog.PunchDialog;
import com.example.sztangli.widgedemo.weather.mvp.EncryptToSHAUtils;
import com.example.sztangli.widgedemo.weather.mvp.WeatherBean;
import com.example.sztangli.widgedemo.weather.mvp.WeatherContract;

import butterknife.BindView;

/**
 * created by tl on 2018-10-23
 */
public class WeatherFragment extends BaseFragment implements WeatherContract.IView {

  public static final String TAG = "WeatherFragment";
  private WeatherContract.Presenter mPresenter;
  private PunchDialog punchDialog;

  @BindView(R.id.city_tv)
  TextView city_tv;
  @BindView(R.id.aqi_tv)
  TextView aqi_tv;
  @BindView(R.id.degree_tv)
  TextView degree_tv;
  @BindView(R.id.tip_tv)
  TextView tip_tv;

  public static WeatherFragment newInstance() {

    Bundle args = new Bundle();

    WeatherFragment fragment = new WeatherFragment();
    fragment.setArguments(args);
    return fragment;
  }


  @Override
  public int getLayoutResId() {
    return R.layout.fragment_weather;
  }

  @Override
  public void onUnBind() {
    mPresenter.unBindPresent();
  }


  @Override
  public void initialization() {
    //  mPresenter.getWeather("深圳");
    String token = "BCB53E10018841A0B2BB84CAC23BD601";
    String macDress = "60:cd:a9:02:8b:5a";
    String IMEI = "356718082533560";
    String version = "秒通3.1.8.2";
    String signature = EncryptToSHAUtils.encryptToSHA("token=" + token +
        "&key=C83V1#WJNEJCSF8FSN*RVY49HAM!692C");
    mPresenter.punch(token, macDress, IMEI, version, signature);
  }


  @Override
  public void getWeatherSuccess(WeatherBean weatherBean) {
    city_tv.setText("城市:" + weatherBean.getCity());
    aqi_tv.setText("api:" + weatherBean.getAqi());
    degree_tv.setText("温度:" + weatherBean.getWendu());
    tip_tv.setText("友情提示:" + weatherBean.getGanmao());
  }

  @Override
  public void punchSuccess(String result) {
    if (punchDialog == null) {
      punchDialog = PunchDialog.newInstance();
    }

    if (!punchDialog.isAdded()) {
      punchDialog.setPunchResult(result);
      punchDialog.show(childManager, PunchDialog.TAG);
    }

  }

  @Override
  public void setPresenter(@NonNull WeatherContract.Presenter presenter) {
    mPresenter = presenter;
  }

  @Override
  public void onLoadFail(ErrorResultBean.ErrorBean errorBean) {
    showToastTip(errorBean.getErrorResult());
  }

  @Override
  public void show() {
    showLoadingWithStatus(childManager, "获取天气中...");
  }

  @Override
  public void hide() {
    hideLoading();
  }

}
