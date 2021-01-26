package com.example.sztangli.widgedemo.coordinatorsample;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmlibrary.base.data.BaseViewModel;
import com.example.sztangli.widgedemo.R;
import com.example.sztangli.widgedemo.coordinatorsample.adapter.CoordinatorAdapter;
import com.example.sztangli.widgedemo.databinding.FragmentCoordinatorBinding;
import com.guyuan.handlein.base.ui.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class CoordinatorFragment extends BaseFragment<FragmentCoordinatorBinding, BaseViewModel> {

    public static final String TAG = "CoordinatorFragment";

    public static CoordinatorFragment newInstance() {

        Bundle args = new Bundle();

        CoordinatorFragment fragment = new CoordinatorFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initialization() {
        List<String> dataList = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            dataList.add("第" + i + "项");
        }

        CoordinatorAdapter adapter = new CoordinatorAdapter(getContext(), dataList);
        binding.coordinatorRv.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.coordinatorRv.setAdapter(adapter);

    }

    @Override
    protected int getVariableId() {
        return 0;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_coordinator;
    }
}
