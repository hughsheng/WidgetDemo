package com.example.sztangli.widgedemo.dialog;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.example.sztangli.widgedemo.R;
import com.guyuan.handlein.base.ui.fragment.BaseDialogFragment;

/**
 * created by com.tl on 2019-1-7
 */
public class PunchDialog extends BaseDialogFragment {

  public static final String TAG = "PunchDialog";
  private String punchResult;

  public static PunchDialog newInstance() {

    Bundle args = new Bundle();
    PunchDialog fragment = new PunchDialog();
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  protected int getLayoutId() {
    return R.layout.dialog_punch;
  }

  @Override
  protected void setContentView(View view) {
    TextView result = view.findViewById(R.id.result_tv);
    result.setText(punchResult);
  }

  public void setPunchResult(String punchResult) {
    this.punchResult = punchResult;
  }

}
