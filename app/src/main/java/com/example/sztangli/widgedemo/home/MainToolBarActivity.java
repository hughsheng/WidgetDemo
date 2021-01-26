package com.example.sztangli.widgedemo.home;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.example.mvvmlibrary.base.data.BaseViewModel;
import com.example.sztangli.widgedemo.R;
import com.example.sztangli.widgedemo.animation.AnimationToolBarActivity;
import com.example.sztangli.widgedemo.articleShow.ArticleToolBarActivity;
import com.example.sztangli.widgedemo.expandabelListView.ExpandableToolBarActivity;
import com.example.sztangli.widgedemo.recycleListView.RecycleToolBarActivity;
import com.example.sztangli.widgedemo.coordinatorsample.CoordinatorToolBarActivity;
import com.example.sztangli.widgedemo.floatingButtom.FloatingButtonToolBarActivity;
import com.example.sztangli.widgedemo.pay.PayToolBarActivity;
import com.example.sztangli.widgedemo.popwindow.PoPWindowActiivty;
import com.example.sztangli.widgedemo.shoppingCart.ShoppingCartActivity;
import com.example.sztangli.widgedemo.utils.ActivityUtils;
import com.example.sztangli.widgedemo.utils.ConstanceValue;
import com.example.sztangli.widgedemo.utils.SnackbarUtil;
import com.example.sztangli.widgedemo.video.VideoActivity;
import com.example.sztangli.widgedemo.weather.WeatherActivity;
import com.example.sztangli.widgedemo.workmanager.WorkManagerActivity;
import com.example.sztangli.widgedemo.xunfeiVoice.XunfeiVoiceToolBarActivity;
import com.guyuan.handlein.base.databinding.ActivityWithToolbarBinding;
import com.guyuan.handlein.base.ui.activity.BaseToolbarActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class MainToolBarActivity extends BaseToolbarActivity<ActivityWithToolbarBinding, BaseViewModel> implements MainFragment.MainListener {

    private String[] widges;
    public static final String TITLE = "title";


    @Override
    protected void initFragment(Bundle savedInstanceState) {
        // toolbar.setNavigationIcon(null);
        widges = getResources().getStringArray(R.array.widges);
        ArrayList<String> data = new ArrayList<>(Arrays.asList(widges));
        MainFragment mainFragment = MainFragment.newInstance(data);
        ActivityUtils.addFragmentToActivity(fragmentManager, mainFragment,
                R.id.fragment_container, MainFragment.TAG);
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_with_toolbar;
    }

    @Override
    public void showWidge(String type) {
        switch (type) {
            case ConstanceValue.SNACKBAR:
                SnackbarUtil.showColorbar(getRootView(), "test",
                        Color.BLACK, Color.RED, Color.YELLOW);
                break;
            case ConstanceValue.EXPANDABLELISTVIEW:
                show(ExpandableToolBarActivity.class, ConstanceValue.EXPANDABLELISTVIEW);
                break;
            case ConstanceValue.RECYCLELISTVIEW:
                show(RecycleToolBarActivity.class, ConstanceValue.RECYCLELISTVIEW);
                break;
            case ConstanceValue.FLOATINGBUTTON:
                show(FloatingButtonToolBarActivity.class, ConstanceValue.FLOATINGBUTTON);
                break;
            case ConstanceValue.CART:
                show(ShoppingCartActivity.class, ConstanceValue.CART);
                break;
            case ConstanceValue.POPWINDOW:
                show(PoPWindowActiivty.class, ConstanceValue.POPWINDOW);
                break;
            case ConstanceValue.VOICERECOGNIZE:
                show(XunfeiVoiceToolBarActivity.class, ConstanceValue.VOICERECOGNIZE);
                break;
            case ConstanceValue.ARTICLESHOW:
                show(ArticleToolBarActivity.class, ConstanceValue.ARTICLESHOW);
                break;
            case ConstanceValue.COORDINATORSAMPLE:
                show(CoordinatorToolBarActivity.class, ConstanceValue.COORDINATORSAMPLE);
                break;

            case ConstanceValue.PAY:
                show(PayToolBarActivity.class, ConstanceValue.PAY);
                break;

            case ConstanceValue.ANIMATION:
                Intent intent = new Intent(this, AnimationToolBarActivity.class);
                intent.putExtra(TITLE, ConstanceValue.ANIMATION);
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                break;

            case ConstanceValue.WEATHER:
                show(WeatherActivity.class, ConstanceValue.WEATHER);
                break;

            case ConstanceValue.VIDEO:
                show(VideoActivity.class, ConstanceValue.VIDEO);
                break;

            case ConstanceValue.WORK_MANAGER:
                show(WorkManagerActivity.class, ConstanceValue.WORK_MANAGER);
                break;
        }
    }

    private void show(Class<?> cls, String type) {
        Intent intent = new Intent(this, cls);
        intent.putExtra(TITLE, type);
        startActivity(intent);
    }

    @Override
    protected int getVariableId() {
        return 0;
    }
}
