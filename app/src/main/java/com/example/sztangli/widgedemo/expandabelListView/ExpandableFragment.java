package com.example.sztangli.widgedemo.expandabelListView;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ExpandableListView;

import com.example.mvvmlibrary.base.data.BaseViewModel;
import com.example.sztangli.widgedemo.R;
import com.example.sztangli.widgedemo.databinding.FragmentExpandableBinding;
import com.guyuan.handlein.base.databinding.ActivityImageviewBinding;
import com.guyuan.handlein.base.ui.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;

import butterknife.BindView;

/**
 * Created by sztangli on 2017/7/14.
 */

public class ExpandableFragment extends BaseFragment<FragmentExpandableBinding, BaseViewModel> implements ExpandableListView.OnGroupExpandListener {

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
    public void initialization() {
        initData();
        AnimationAdapter animationAdapter = new AnimationAdapter(getContext(), parentList, childList);
        binding.animatedExpandableList.setGroupIndicator(null);
        binding.animatedExpandableList.setAdapter(animationAdapter);
        binding.animatedExpandableList.setSelector(new ColorDrawable(Color.TRANSPARENT));
        binding.animatedExpandableList.setOnGroupExpandListener(this);
    }

    private void initData() {
        for (int i = 0; i < 5; i++) {
            parentList.add("p" + i);
            childList.add("c" + i);
        }
    }

    @Override
    public void onGroupExpand(int groupPosition) {
        int count = binding.animatedExpandableList.getExpandableListAdapter().getGroupCount();
        for (int j = 0; j < count; j++) {
            if (j != groupPosition) {
                binding.animatedExpandableList.collapseGroup(j);
            }
        }
    }

    @Override
    protected int getVariableId() {
        return 0;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_expandable;
    }
}
