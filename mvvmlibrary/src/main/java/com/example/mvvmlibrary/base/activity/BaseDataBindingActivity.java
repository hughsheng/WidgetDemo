package com.example.mvvmlibrary.base.activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

import com.example.mvvmlibrary.app.BaseApplication;
import com.example.mvvmlibrary.base.data.BaseViewModel;


/**
 * created by com.tl
 * created at 2020/8/12
 */
public abstract class BaseDataBindingActivity<VB extends ViewDataBinding, VM extends BaseViewModel> extends AppCompatActivity {
    protected VB binding;
    protected VM viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataBinding();
        initData(savedInstanceState);
    }

    private void initDataBinding() {
        try {
            Type type = getClass().getGenericSuperclass();
            Type[] types = ((ParameterizedType) type).getActualTypeArguments();
            if (types.length > 1) {
                if (getLayoutID() != 0) {
                    binding = DataBindingUtil.setContentView(this, getLayoutID());
                }
                Class<VM> modelClass;
                modelClass = (Class<VM>) ((ParameterizedType) type).getActualTypeArguments()[1];
                viewModel = new ViewModelProvider(this).get(modelClass);
                //把viewmodel绑定到xml中
                if (getVariableId() != 0) {
                    initLiveData();
                    binding.setVariable(getVariableId(), viewModel);
                    binding.setLifecycleOwner(this);
                }
            } else {
                throw new Exception("未设置泛型");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void initLiveData() {
        if (viewModel != null) {
            viewModel.getShowLoading().observe(this, new Observer<String>() {
                @Override
                public void onChanged(String s) {
                    showLoadingWithTip(getSupportFragmentManager(), s);
                }
            });

            viewModel.getHideLoading().observe(this, new Observer<Void>() {
                @Override
                public void onChanged(Void aVoid) {
                    hideLoading();
                }
            });

            viewModel.getTip().observe(this, new Observer<String>() {
                @Override
                public void onChanged(String s) {
                    showToastTip(s);
                }
            });

            viewModel.getStartActivityEvent().observe(this, new Observer<Map<String, Object>>() {
                @Override
                public void onChanged(Map<String, Object> params) {
                    Class<?> clz = (Class<?>) params.get(BaseViewModel.ParameterField.CLASS);
                    Bundle bundle = (Bundle) params.get(BaseViewModel.ParameterField.BUNDLE);
                    startActivity(clz, bundle);
                }
            });

            viewModel.getFinishEvent().observe(this, new Observer<Void>() {
                @Override
                public void onChanged(Void aVoid) {
                    finish();
                }
            });
        }
    }


    /**
     * 跳转页面
     *
     * @param clz    所跳转的目的Activity类
     * @param bundle 跳转所携带的信息
     */
    public void startActivity(Class<?> clz, Bundle bundle) {
        Intent intent = new Intent(this, clz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    protected abstract void initData(Bundle savedInstanceState);

    protected abstract int getLayoutID();

    protected abstract int getVariableId();

    public abstract void showLoadingWithTip(FragmentManager fragmentManager, String tip);

    public abstract void hideLoading();

    public abstract void showToastTip(String tip);


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (binding != null) {
            binding.unbind();
        }
        if (viewModel != null) {
            viewModel.onUnSubscribe();
        }
    }
}
