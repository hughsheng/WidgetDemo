package com.example.sztangli.widgedemo.base.activity;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sztangli.widgedemo.R;
import com.example.sztangli.widgedemo.utils.ScreenUtil;

import butterknife.BindView;

/**
 * Created by sztangli on 2017/7/13.
 * 包含toolbar的activity基类
 */

public abstract class BaseToolBarActivity extends BaseActivity {

  @BindView(R.id.title_center)
  protected TextView titleCenter;
  @BindView(R.id.toolbar)
  protected Toolbar toolbar;
  @BindView(R.id.back_iv)
  protected ImageView back_iv;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    initalFragment(savedInstanceState);
    initToolBar();
  }

  protected void initToolBar() {
    back_iv.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        finish();
      }
    });
  }

  @Override
  public void hideStatusBar() {
    super.hideStatusBar();
    toolbar.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
      @Override
      public void onSystemUiVisibilityChange(int visibility) {
        toolbar.setPadding(toolbar.getPaddingLeft(), 0, toolbar.getPaddingRight(), toolbar
            .getPaddingBottom() - ScreenUtil.getStatusHeight(BaseToolBarActivity.this));
      }
    });
  }

  @Override
  public void showStatusBar() {
    super.showStatusBar();
    toolbar.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
      @Override
      public void onSystemUiVisibilityChange(int visibility) {

        toolbar.setPadding(toolbar.getPaddingLeft(), ScreenUtil.getStatusHeight
            (BaseToolBarActivity.this), toolbar.getPaddingRight(), toolbar.getPaddingBottom() +
            ScreenUtil.getStatusHeight(BaseToolBarActivity.this));
      }
    });
  }

  public void setTitleCenter(String title) {
    titleCenter.setText(title);
  }

  public abstract void initalFragment(Bundle savedInstanceState);

}
