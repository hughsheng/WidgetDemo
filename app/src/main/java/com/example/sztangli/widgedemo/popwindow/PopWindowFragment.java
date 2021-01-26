package com.example.sztangli.widgedemo.popwindow;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.example.mvvmlibrary.base.data.BaseViewModel;
import com.example.sztangli.widgedemo.R;
import com.example.sztangli.widgedemo.customViews.MyCustomView;
import com.example.sztangli.widgedemo.databinding.FragmentPopwindowBinding;
import com.guyuan.handlein.base.ui.fragment.BaseFragment;

import butterknife.BindView;

/**
 * Created by sztangli on 2017/8/10.
 */

public class PopWindowFragment extends BaseFragment<FragmentPopwindowBinding, BaseViewModel> {

    public static final String TAG = "PopWindowFragment";

    public static PopWindowFragment newInstance() {

        Bundle args = new Bundle();

        PopWindowFragment fragment = new PopWindowFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initialization() {
        View contentView = LayoutInflater.from(getContext()).inflate(R.layout.popwindow_layout, null);
        final PopupWindow popWnd = new PopupWindow(getContext());
        popWnd.setContentView(contentView);
        popWnd.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        popWnd.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (popWnd.isShowing()) {
                    popWnd.dismiss();
                } else {
                    popWnd.showAtLocation(binding.bottom, Gravity.TOP, 0, 0);
                }
            }
        });

        binding.et.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {
                    //  Toast.makeText(getContext(), "输入了回车", Toast.LENGTH_SHORT).show();
                    Log.i("mylog", "输入了回车");
                    return true;
                }
                return false;
            }
        });

        binding.testApiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    protected int getVariableId() {
        return 0;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_popwindow;
    }
}
