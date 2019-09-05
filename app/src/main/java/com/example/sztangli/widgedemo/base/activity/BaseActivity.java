package com.example.sztangli.widgedemo.base.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.annotation.Nullable;
import com.google.android.material.snackbar.Snackbar;
import androidx.fragment.app.FragmentManager;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.sztangli.widgedemo.base.api.ApiServiceComponent;
import com.example.sztangli.widgedemo.base.app.AppApplication;
import com.example.sztangli.widgedemo.dialog.LoadingDialogFragment;
import com.example.sztangli.widgedemo.utils.ActivityUtils;
import com.example.sztangli.widgedemo.utils.ScreenUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * created by tl on 2018-10-23
 * activity基类
 */
public abstract class BaseActivity extends AppCompatActivity {
  protected Unbinder mUnbinder;
  protected AppApplication mApplication;
  protected FragmentManager mFragmentManager;
  protected LoadingDialogFragment loadingDialogFragment;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getLayoutResId() != 0) {
      setContentView(getLayoutResId());
    }
    mApplication = (AppApplication) getApplication();
    mFragmentManager = getSupportFragmentManager();
    loadingDialogFragment = LoadingDialogFragment.newInstance();
    mUnbinder = ButterKnife.bind(this);
    ActivityUtils.addActivity(this.getClass().getSimpleName(), this);
  }

  public View getRootView() {
    return ((ViewGroup) findViewById(android.R.id.content)).getChildAt(0);
  }


  public abstract int getLayoutResId();


  protected ApiServiceComponent getApiServiceComponent() {
    return mApplication.getApiServiceComponent();
  }

  public void showToastTip(int resId) {
    Toast.makeText(this, getString(resId), Toast.LENGTH_SHORT).show();
  }

  public void showToastTip(String message) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
  }

  public void showSnackBarTip(String message) {
    Snackbar.make(getRootView(), message, Snackbar.LENGTH_SHORT).show();
  }

  public void showSnackBarTip(int resId) {
    Snackbar.make(getRootView(), resId, Snackbar.LENGTH_SHORT).show();
  }

  public void showLoading(FragmentManager manager) {
    loadingDialogFragment.show(manager, LoadingDialogFragment.TAG);
  }

  public void showLoadingWithStatus(FragmentManager manager, String status) {
    loadingDialogFragment.showWithStatus(manager, status);
  }

  public void hideLoading() {
    loadingDialogFragment.dismiss();
  }

  @Override
  public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
    super.onSaveInstanceState(outState, outPersistentState);
  }

  //显示状态栏
  public void showStatusBar() {
    View view = getWindow().getDecorView();
    ScreenUtil.showSystemUI(view);
  }

  //隐藏状态栏
  public void hideStatusBar() {
    View view = getWindow().getDecorView();
    ScreenUtil.hideSystemUI(view);
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    ActivityUtils.removeActivity(this.getClass().getSimpleName());
    if (mUnbinder != null) {
      mUnbinder.unbind();
      mUnbinder = null;
    }
  }

}
