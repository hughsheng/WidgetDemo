package com.example.sztangli.widgedemo.coordinatorsample;

import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sztangli.widgedemo.R;
import com.example.sztangli.widgedemo.base.fragment.BaseFragment;
import com.example.sztangli.widgedemo.coordinatorsample.adapter.CoordinatorAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class CoordinatorFragment extends BaseFragment {

  public static final String TAG = "CoordinatorFragment";

  public static CoordinatorFragment newInstance() {

    Bundle args = new Bundle();

    CoordinatorFragment fragment = new CoordinatorFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @BindView(R.id.coordinator_rv)
  RecyclerView coordinator_rv;

  @Override
  public int getLayoutResId() {
    return R.layout.fragment_coordinator;
  }

  @Override
  public void onUnBind() {

  }

  @Override
  public void initialization() {
    List<String> dataList = new ArrayList<>();

    for (int i = 0; i < 20; i++) {
      dataList.add("第" + i + "项");
    }

    CoordinatorAdapter adapter = new CoordinatorAdapter(getContext(), dataList);
    coordinator_rv.setLayoutManager(new LinearLayoutManager(getContext()));
    coordinator_rv.setAdapter(adapter);

  }
}
