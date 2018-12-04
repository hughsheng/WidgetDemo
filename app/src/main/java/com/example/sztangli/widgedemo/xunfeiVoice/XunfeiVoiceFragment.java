package com.example.sztangli.widgedemo.xunfeiVoice;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sztangli.widgedemo.R;
import com.example.sztangli.widgedemo.base.fragment.BaseFragment;
import com.iflytek.cloud.RecognizerResult;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechRecognizer;
import com.iflytek.cloud.RecognizerListener;

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

    private void setVoiceRecognize() {
        //1.创建SpeechRecognizer对象，第二个参数：本地听写时传InitListener
        SpeechRecognizer mIat = SpeechRecognizer.createRecognizer(getContext(), null);
        //2.设置听写参数，详见《科大讯飞MSC API手册(Android)》SpeechConstant类
        mIat.setParameter(SpeechConstant.DOMAIN, "iat");
        mIat.setParameter(SpeechConstant.LANGUAGE, "zh_cn");
        mIat.setParameter(SpeechConstant.ACCENT, "mandarin ");
        //3.开始听写
        mIat.startListening(mRecoListener);
    }

    //听写监听器
    private RecognizerListener mRecoListener = new RecognizerListener() {
        //音量值0~30
        @Override
        public void onVolumeChanged(int i, byte[] bytes) {

        }

        //开始录音
        @Override
        public void onBeginOfSpeech() {

        }

        //结束录音
        @Override
        public void onEndOfSpeech() {

        }

        //听写结果回调接口(返回Json格式结果，用户可参见附录12.1)；
//一般情况下会通过onResults接口多次返回结果，完整的识别内容是多次结果的累加；
//关于解析Json的代码可参见MscDemo中JsonParser类；
//isLast等于true时会话结束。
        @Override
        public void onResult(RecognizerResult recognizerResult, boolean b) {

        }

        //会话发生错误回调接口
        @Override
        public void onError(SpeechError speechError) {

        }

        //扩展用接口
        @Override
        public void onEvent(int i, int i1, int i2, Bundle bundle) {

        }
    };
}
