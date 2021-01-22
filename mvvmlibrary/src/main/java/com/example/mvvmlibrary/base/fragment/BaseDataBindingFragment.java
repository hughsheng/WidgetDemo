package com.example.mvvmlibrary.base.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

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
        BaseDataBindingActivity fragmentActivity = (BaseDataBindingActivity) getActivity();
        if (fragmentActivity != null) {
            if (fragmentActivity.isSetViewModelToFragment()) {
                viewModel = (VM) fragmentActivity.getViewModel();//使用activity的viewModel
            } else {
                try {
                    Type genericSuperclass = getClass().getGenericSuperclass();
                    if (genericSuperclass instanceof ParameterizedType) {
                        Class<VM> cls;
                        if (((ParameterizedType) genericSuperclass).getActualTypeArguments().length == 3) {
                            cls = (Class<VM>) ((ParameterizedType) genericSuperclass).getActualTypeArguments()[2];
                        } else {
                            cls = (Class<VM>) ((ParameterizedType) genericSuperclass).getActualTypeArguments()[1];
                        }

                        viewModel = new ViewModelProvider(getActivity()).get(cls);//使用自身的viewModel
                        initLiveData();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getLayoutID() != 0) {
            binding = DataBindingUtil.inflate(inflater, getLayoutID(), container, false);
        }
        if (viewModel != null && getVariableId() != 0) {
            binding.setVariable(getVariableId(), viewModel);
        }
        rootView = binding.getRoot();
        binding.setLifecycleOwner(this);
        return rootView;
    }


    protected void initLiveData() {
        if (viewModel != null && getActivity() instanceof BaseDataBindingActivity) {
            final BaseDataBindingActivity baseDataBindingActivity = (BaseDataBindingActivity) getActivity();
            viewModel.getShowLoading().observe(this, new Observer<String>() {
                @Override
                public void onChanged(String s) {
                    baseDataBindingActivity.showLoadingWithTip(getChildFragmentManager(), s);
                }
            });

            viewModel.getHideLoading().observe(this, new Observer<Void>() {
                @Override
                public void onChanged(Void aVoid) {
                    baseDataBindingActivity.hideLoading();
                }
            });

            viewModel.getTip().observe(this, new Observer<String>() {
                @Override
                public void onChanged(String s) {
                    baseDataBindingActivity.showToastTip(s);
                }
            });

            viewModel.getStartActivityEvent().observe(this, new Observer<Map<String, Object>>() {
                @Override
                public void onChanged(Map<String, Object> params) {
                    Class<?> clz = (Class<?>) params.get(BaseViewModel.ParameterField.CLASS);
                    Bundle bundle = (Bundle) params.get(BaseViewModel.ParameterField.BUNDLE);
                    baseDataBindingActivity.startActivity(clz, bundle);
                }
            });

            viewModel.getFinishEvent().observe(this, new Observer<Void>() {
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
        binding.unbind();
    }

    //绑定viewModel
    protected abstract int getVariableId();

    protected abstract int getLayoutID();
}
