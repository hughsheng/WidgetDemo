package com.example.sztangli.widgedemo.base.activity;

import android.os.Bundle;
import androidx.annotation.Nullable;

/**
 * created by tl on 2018-10-23
 * 没有toolbar的activity基类
 */
public abstract class BaseNoToolBarActivity extends BaseActivity {
  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    initalFragment(savedInstanceState);
  }

  public abstract void initalFragment(Bundle savedInstanceState);
}
