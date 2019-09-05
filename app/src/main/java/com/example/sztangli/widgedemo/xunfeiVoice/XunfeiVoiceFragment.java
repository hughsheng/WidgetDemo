package com.example.sztangli.widgedemo.xunfeiVoice;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sztangli.widgedemo.R;
import com.example.sztangli.widgedemo.base.fragment.BaseFragment;


import butterknife.BindView;

/**
 * Created by sztangli on 2017/8/31.
 */

public class XunfeiVoiceFragment extends BaseFragment implements View.OnClickListener {

    @BindView(R.id.resultText)
    EditText resultText;
    @BindView(R.id.start_recognize_btn)
    Button start;
    @BindView(R.id.stop_recognize_btn)
    Button stop;
    public static final String TAG = "XunfeiVoiceFragment";

    public static XunfeiVoiceFragment newInstance() {
        Bundle args = new Bundle();
        XunfeiVoiceFragment fragment = new XunfeiVoiceFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_xunfeivoice;
    }

    @Override
    public void onUnBind() {

    }

    @Override
    public void initialization() {
        start.setOnClickListener(this);
        stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start_recognize_btn:

                break;
            case R.id.stop_recognize_btn:
                break;
        }
    }

}
