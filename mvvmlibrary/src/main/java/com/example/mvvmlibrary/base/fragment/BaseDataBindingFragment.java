package com.example.mvvmlibrary.base.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;


import com.example.mvvmlibrary.base.activity.BaseDataBindingActivity;
import com.example.mvvmlibrary.base.data.BaseViewModel;


/**
 * created by com.tl
 * created at 2020/8/25
 */

public abstract class BaseDataBindingFragment<VB extends ViewDataBinding, VM extends BaseViewModel> extends Fragment {
    protected VB binding;
    protected VM viewModel;
    protected View rootView;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getActivity() != null) {
            try {
                Type genericSuperclass = getClass().getGenericSuperclass();
                Type[] types = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
                if (types.length > 1) {
                    Class<VM> cls = (Class<VM>) types[1];
                    viewModel = new ViewModelProvider(getActivity()).get(cls);
                    initLiveData();
                    if (getLayoutID() != 0) {
                        binding = DataBindingUtil.inflate(inflater, getLayoutID(), container, false);
                    }
                    if (viewModel != null && getVariableId() != 0) {
                        binding.setVariable(getVariableId(), viewModel);
                    }
                    rootView = binding.getRoot();
                    binding.setLifecycleOwner(this);

                } else {
                    throw new Exception("未设置泛型");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return rootView;
    }


    protected void initLiveData() {
        FragmentActivity activity = getActivity();
        if (viewModel != null && activity instanceof BaseDataBindingActivity) {
            final BaseDataBindingActivity baseDataBindingActivity = (BaseDataBindingActivity) activity;
            viewModel.getShowLoading().observe(getViewLifecycleOwner(), new Observer<String>() {
                @Override
                public void onChanged(String s) {
                    baseDataBindingActivity.showLoadingWithTip(getChildFragmentManager(), s);
                }
            });

            viewModel.getHideLoading().observe(getViewLifecycleOwner(), new Observer<Void>() {
                @Override
                public void onChanged(Void aVoid) {
                    baseDataBindingActivity.hideLoading();
                }
            });

            viewModel.getTip().observe(getViewLifecycleOwner(), new Observer<String>() {
                @Override
                public void onChanged(String s) {
                    baseDataBindingActivity.showToastTip(s);
                }
            });

            viewModel.getStartActivityEvent().observe(getViewLifecycleOwner(), new Observer<Map<String, Object>>() {
                @Override
                public void onChanged(Map<String, Object> params) {
                    Class<?> clz = (Class<?>) params.get(BaseViewModel.ParameterField.CLASS);
                    Bundle bundle = (Bundle) params.get(BaseViewModel.ParameterField.BUNDLE);
                    baseDataBindingActivity.startActivity(clz, bundle);
                }
            });

            viewModel.getFinishEvent().observe(getViewLifecycleOwner(), new Observer<Void>() {
                @Override
                public void onChanged(Void aVoid) {
                    baseDataBindingActivity.finish();
                }
            });
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (binding != null) {
            binding.unbind();
        }
    }

    //绑定viewModel
    protected abstract int getVariableId();

    protected abstract int getLayoutID();

}
