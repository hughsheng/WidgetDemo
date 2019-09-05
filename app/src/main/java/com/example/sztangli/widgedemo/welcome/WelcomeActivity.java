package com.example.sztangli.widgedemo.welcome;

import android.content.Intent;
import android.os.Bundle;

import com.example.sztangli.widgedemo.home.MainToolBarActivity;
import com.example.sztangli.widgedemo.base.activity.BaseNoToolBarActivity;

/**
 * created by tl on 2018-12-4
 */
public class WelcomeActivity extends BaseNoToolBarActivity {
  @Override
  public void initalFragment(Bundle savedInstanceState) {
    startActivity(new Intent(this, MainToolBarActivity.class));
    finish();
  }

  @Override
  public int getLayoutResId() {
    return 0;
  }
}
