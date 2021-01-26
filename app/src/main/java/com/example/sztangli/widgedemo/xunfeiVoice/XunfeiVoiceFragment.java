package com.example.sztangli.widgedemo.xunfeiVoice;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mvvmlibrary.base.data.BaseViewModel;
import com.example.sztangli.widgedemo.R;
import com.example.sztangli.widgedemo.databinding.FragmentXunfeivoiceBinding;
import com.guyuan.handlein.base.ui.fragment.BaseFragment;

import butterknife.BindView;

/**
 * Created by sztangli on 2017/8/31.
 */

public class XunfeiVoiceFragment extends BaseFragment<FragmentXunfeivoiceBinding, BaseViewModel> implements View.OnClickListener {

    public static final String TAG = "XunfeiVoiceFragment";

    public static XunfeiVoiceFragment newInstance() {
        Bundle args = new Bundle();
        XunfeiVoiceFragment fragment = new XunfeiVoiceFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initialization() {
        binding.startRecognizeBtn.setOnClickListener(this);
        binding.stopRecognizeBtn.setOnClickListener(this);
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

    @Override
    protected int getVariableId() {
        return 0;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_xunfeivoice;
    }
}
