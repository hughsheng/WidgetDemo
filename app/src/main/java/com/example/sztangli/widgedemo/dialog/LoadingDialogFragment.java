package com.example.sztangli.widgedemo.dialog;

import android.app.Dialog;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.example.sztangli.widgedemo.R;

/**
 * created by tl on 2018-10-23
 * 加载框
 */
public class LoadingDialogFragment extends DialogFragment {

  public static final String TAG = "LoadingDialogFragment";

  private String status;
  private int color;

  public static LoadingDialogFragment newInstance() {
    return new LoadingDialogFragment();
  }


  @NonNull
  @Override
  public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
    View view = LayoutInflater.from(getActivity()).inflate(R.layout.loading, null);
    TextView status_tv = view.findViewById(R.id.status_tv);
    ContentLoadingProgressBar load_progress = view.findViewById(R.id.load_progress);
    if (status != null) {
      status_tv.setVisibility(View.VISIBLE);
      status_tv.setText(status);
    }

    if (color != 0) {
      load_progress.getIndeterminateDrawable().setColorFilter(ContextCompat.getColor(getActivity(),
          color), PorterDuff.Mode.MULTIPLY);
    }
    Dialog dialog = new Dialog(getActivity(), R.style.DialogFragment);
    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
    dialog.setContentView(view);
    dialog.setCancelable(false);
    dialog.setCanceledOnTouchOutside(false);
    return dialog;
  }


  public void showWithStatus(FragmentManager manager, String tag, String status) {
    this.status = status;
    if (!isAdded()) {
      show(manager, tag);
    }
  }

  public void setColor(int color) {
    this.color = color;
  }

}
