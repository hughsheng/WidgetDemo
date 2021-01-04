package com.example.sztangli.widgedemo.animation;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import com.example.sztangli.widgedemo.R;
import com.example.sztangli.widgedemo.home.WidgeAdapter;
import com.example.sztangli.widgedemo.utils.ConstanceValue;
import com.guyuan.handlein.base.ui.fragment.BaseFragment;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;

/**
 * @author : com.tl
 * @description :
 * @since: 2020/10/20 11:15
 * @company : 固远（深圳）信息技术有限公司
 **/

public class MotionLayoutFragment extends BaseFragment {

    @BindView(R.id.container)
    FrameLayout container;
    @BindView(R.id.rg)
    GridView rg;

    public static final String TAG = "MotionLayoutFragment";
    private String currentType;
    private AnimationToolBarActivity animationToolBarActivity;

    public static MotionLayoutFragment newInstance() {

        Bundle args = new Bundle();

        MotionLayoutFragment fragment = new MotionLayoutFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        animationToolBarActivity = (AnimationToolBarActivity) context;
    }

    @Override
    protected int getVariableId() {
        return 0;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_motion;
    }


    @Override
    public void initialization() {
        List<String> motionList = Arrays.asList(getResources().getStringArray(R.array.motion));
        currentType = motionList.get(0);
        setContent(R.layout.container_motion_button);
        animationToolBarActivity.setTitleCenter(currentType);
        WidgeAdapter adapter = new WidgeAdapter(getContext(), motionList);
        rg.setAdapter(adapter);
        rg.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String type = motionList.get(position);
                if (!currentType.equals(type)) {
                    currentType = type;
                    animationToolBarActivity.setTitleCenter(type);
                    setMotion(type);
                }
            }
        });

    }

    private void setMotion(String type) {
        animationToolBarActivity.setTitleCenter(type);
        container.removeAllViews();
        switch (type) {
            case ConstanceValue.MOTION_MOVE:
                setContent(R.layout.container_motion_button);
                //    motion_ml.loadLayoutDescription(R.xml.motion_move_scene);
                break;

            case ConstanceValue.MOTION_ATTRIBUTE:
                setContent(R.layout.container_motion_attribute);
                break;

            case ConstanceValue.MOTION_PIC_CHANGE:

                //    motion_ml.loadLayoutDescription(R.xml.motion_pic_scence);
                break;

            case ConstanceValue.MOTION_PAINT_POSITION:
                //    motion_ml.loadLayoutDescription(R.xml.motion_paint_position);
                break;

            case ConstanceValue.MOTION_PAINT_VALUE:
                //    motion_ml.loadLayoutDescription(R.xml.motion_paint_value);
                break;

            case ConstanceValue.MOTION_PAINT_CYCLE:
                //    motion_ml.loadLayoutDescription(R.xml.motion_paint_cycle);
                break;

            case ConstanceValue.MOTION_COORDINATOR_LAYOUT:
                //    motion_ml.loadLayoutDescription(R.xml.motion_cl_scence);
                break;

            case ConstanceValue.MOTION_DRAWER_LAYOUT:
                //    motion_ml.loadLayoutDescription(R.xml.motion_dl_scence);
                break;

            case ConstanceValue.MOTION_SIDE_BAR:
                //    motion_ml.loadLayoutDescription(R.xml.motion_side_bar);
                break;

            case ConstanceValue.MOTION_PARALLAX:
                //    motion_ml.loadLayoutDescription(R.xml.motion_parallax);
                break;

            case ConstanceValue.MOTION_VIEWPAGER:
                //     motion_ml.loadLayoutDescription(R.xml.motion_view_pager_scence);
                break;

            case ConstanceValue.MOTION_VIEWPAGER_LOTTIE:
                //    motion_ml.loadLayoutDescription(R.xml.motion_view_pager_scence);
                break;

            case ConstanceValue.MOTION_SPORT:
                //    motion_ml.loadLayoutDescription(R.xml.motion_sport);
                break;

            case ConstanceValue.MOTION_FRAGMENT:
                //    motion_ml.loadLayoutDescription(R.xml.motion_fragment);
                break;

            case ConstanceValue.MOTION_KEY_TRIGGER:
                //    motion_ml.loadLayoutDescription(R.xml.motion_trigger);
                break;

            case ConstanceValue.MOTION_STATE:
                //    motion_ml.loadLayoutDescription(R.xml.motion_state);
                break;

            case ConstanceValue.MOTION_EXPEND:
                setContent(R.layout.container_motion_extend);
                break;
        }
    }

    private void setContent(int layoutID) {
        LayoutInflater.from(getContext()).inflate(layoutID, container, true);
    }
}