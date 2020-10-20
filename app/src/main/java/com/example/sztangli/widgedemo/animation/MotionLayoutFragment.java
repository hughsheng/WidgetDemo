package com.example.sztangli.widgedemo.animation;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import androidx.constraintlayout.motion.widget.MotionLayout;

import com.example.sztangli.widgedemo.R;
import com.example.sztangli.widgedemo.base.fragment.BaseFragment;
import com.example.sztangli.widgedemo.home.WidgeAdapter;
import com.example.sztangli.widgedemo.utils.ConstanceValue;

import java.util.Arrays;

import butterknife.BindView;

/**
 * @author : tl
 * @description :
 * @since: 2020/10/20 11:15
 * @company : 固远（深圳）信息技术有限公司
 **/

public class MotionLayoutFragment extends BaseFragment {

    @BindView(R.id.motion_ml)
    MotionLayout motion_ml;
    @BindView(R.id.button)
    View button;
    @BindView(R.id.gv)
    GridView gv;

    public static final String TAG = "MotionLayoutFragment";

    public static MotionLayoutFragment newInstance() {

        Bundle args = new Bundle();

        MotionLayoutFragment fragment = new MotionLayoutFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_motion;
    }

    @Override
    public void onUnBind() {

    }

    @Override
    public void initialization() {
        WidgeAdapter adapter = new WidgeAdapter(getContext(),
                Arrays.asList(getResources().getStringArray(R.array.motion)));
        gv.setAdapter(adapter);
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tv = (TextView) view.findViewById(R.id.widge_name);
                String type = tv.getText().toString();
                setMotion(type);
            }
        });
    }


    private void setMotion(String type) {
        switch (type) {
            case ConstanceValue.MOTION_MOVE:
                motion_ml.loadLayoutDescription(R.xml.motion_move_scene);
                break;

            case ConstanceValue.MOTION_ATTRIBUTE:
                motion_ml.loadLayoutDescription(R.xml.motion_attribute_scence);
                break;

            case ConstanceValue.MOTION_PIC_CHANGE:
                motion_ml.loadLayoutDescription(R.xml.motion_pic_scence);
                break;

            case ConstanceValue.MOTION_PAINT_POSITION:
                motion_ml.loadLayoutDescription(R.xml.motion_paint_position);
                break;

            case ConstanceValue.MOTION_PAINT_VALUE:
                motion_ml.loadLayoutDescription(R.xml.motion_paint_value);
                break;

            case ConstanceValue.MOTION_PAINT_CYCLE:
                motion_ml.loadLayoutDescription(R.xml.motion_paint_cycle);
                break;

            case ConstanceValue.MOTION_COORDINATOR_LAYOUT:
                motion_ml.loadLayoutDescription(R.xml.motion_cl_scence);
                break;

            case ConstanceValue.MOTION_DRAWER_LAYOUT:
                motion_ml.loadLayoutDescription(R.xml.motion_dl_scence);
                break;

            case ConstanceValue.MOTION_SIDE_BAR:
                motion_ml.loadLayoutDescription(R.xml.motion_side_bar);
                break;

            case ConstanceValue.MOTION_PARALLAX:
                motion_ml.loadLayoutDescription(R.xml.motion_parallax);
                break;

            case ConstanceValue.MOTION_VIEWPAGER:
                motion_ml.loadLayoutDescription(R.xml.motion_view_pager_scence);
                break;

            case ConstanceValue.MOTION_VIEWPAGER_LOTTIE:
                //    motion_ml.loadLayoutDescription(R.xml.motion_view_pager_scence);
                break;

            case ConstanceValue.MOTION_SPORT:
                motion_ml.loadLayoutDescription(R.xml.motion_sport);
                break;

            case ConstanceValue.MOTION_FRAGMENT:
                motion_ml.loadLayoutDescription(R.xml.motion_fragment);
                break;

            case ConstanceValue.MOTION_KEY_TRIGGER:
                motion_ml.loadLayoutDescription(R.xml.motion_trigger);
                break;

            case ConstanceValue.MOTION_STATE:
                motion_ml.loadLayoutDescription(R.xml.motion_state);
                break;
        }
    }
}