package com.example.sztangli.widgedemo.utils;

import android.support.design.widget.Snackbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sztangli.widgedemo.R;

/**
 * Created by sztangli on 2017/6/29.
 */

public class SnackbarUtil {

public static void shownormalbar(View view,String content){
    Snackbar.make(view,content,Snackbar.LENGTH_SHORT).show();
}
public static void showDefineBar(View view,int layoutId,String content){
    Snackbar snackbar=Snackbar.make(view,content,Snackbar.LENGTH_SHORT);
    Snackbar.SnackbarLayout layout= (Snackbar.SnackbarLayout) snackbar.getView();
    View add_view = LayoutInflater.from(snackbar.getContext()).inflate(layoutId,null);
    LinearLayout.LayoutParams p = new LinearLayout.LayoutParams( LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
    p.gravity= Gravity.CENTER_VERTICAL;
    layout.addView(add_view);
}

public static void showColorbar(View view,String content,int acolor,int bcolor,int ccolor){
    Snackbar snackbar=Snackbar.make(view,content,Snackbar.LENGTH_SHORT);
    Snackbar.SnackbarLayout layout= (Snackbar.SnackbarLayout) snackbar.getView();
    snackbar.setAction(" ", new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    });
    layout.setBackgroundColor(bcolor); //设置Snackbar的背景色
    TextView textView = (TextView) layout.findViewById(R.id.snackbar_text);
    Button btn= (Button) layout.findViewById(R.id.snackbar_action);
    btn.setBackgroundResource(R.mipmap.ic_launcher_round);
    textView.setTextColor(ccolor);  //设置Snackbar文字的颜色
    snackbar.setActionTextColor(acolor); //设置Aciton的字体颜色值
    snackbar.show();
}
}
