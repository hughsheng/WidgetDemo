package com.example.sztangli.widgedemo.expandabelListView;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ExpandableListView;

import com.example.sztangli.widgedemo.R;
import com.example.sztangli.widgedemo.base.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by sztangli on 2017/7/14.
 */

public class ExpandableFragment extends BaseFragment implements ExpandableListView.OnGroupExpandListener {

    @BindView(R.id.animatedExpandableList)
    AnimatedExpandableListView listView;

    private List<String> parentList = new ArrayList<>();
    private List<String> childList = new ArrayList<>();
    public static final String TAG = "ExpandableFragment";
    public static ExpandableFragment newInstance() {

        Bundle args = new Bundle();

        ExpandableFragment fragment = new ExpandableFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public int getLayoutResId() {
        return R.layout.fragment_expandable;
    }

    @Override
    public void onUnBind() {

    }

    @Override
    public void initialization() {
        initData();
        AnimationAdapter animationAdapter = new AnimationAdapter(getContext(),parentList,childList);
        listView.setGroupIndicator(null);
        listView.setAdapter(animationAdapter);
        listView.setSelector(new ColorDrawable(Color.TRANSPARENT));
        listView.setOnGroupExpandListener(this);
    }

    private void initData() {
      for(int i=0;i<5;i++){
         parentList.add("p"+i);
         childList.add("c"+i);
      }
    }

    @Override
    public void onGroupExpand(int groupPosition) {
        int count = listView.getExpandableListAdapter().getGroupCount();
        for(int j = 0; j < count; j++){
            if(j != groupPosition){
                listView.collapseGroup(j);
            }
        }
    }
}
