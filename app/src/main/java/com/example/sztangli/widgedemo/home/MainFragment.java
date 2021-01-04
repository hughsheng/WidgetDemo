package com.example.sztangli.widgedemo.home;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.example.mvvmlibrary.base.data.BaseViewModel;
import com.example.sztangli.widgedemo.R;
import com.example.sztangli.widgedemo.databinding.FragmentMainBinding;
import com.guyuan.handlein.base.ui.fragment.BaseFragment;

import java.util.ArrayList;
import butterknife.BindView;

/**
 * Created by sztangli on 2017/7/13.
 */

public class MainFragment extends BaseFragment<FragmentMainBinding, BaseViewModel> {

    public static final String WIDGECOLLECTION = "widgecollection";
    public static final String TAG = "MainFragment";
    private MainListener listener;

    public static MainFragment newInstance(ArrayList<String> data) {

        Bundle args = new Bundle();
        args.putStringArrayList(WIDGECOLLECTION, data);
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        listener = (MainListener) context;
        super.onAttach(context);
    }

    @Override
    protected int getVariableId() {
        return 0;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_main;
    }


    @Override
    public void initialization() {
        WidgeAdapter adapter = new WidgeAdapter(getContext(),
                getArguments().getStringArrayList(WIDGECOLLECTION));
        binding.widgeCollection.setAdapter(adapter);
        binding.widgeCollection.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tv = (TextView) view.findViewById(R.id.widge_name);
                String type = tv.getText().toString();
                listener.showWidge(type);
            }
        });
    }

    interface MainListener {
        void showWidge(String type);
    }

}
