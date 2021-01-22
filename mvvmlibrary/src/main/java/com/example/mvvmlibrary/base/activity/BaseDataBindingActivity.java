package com.example.mvvmlibrary.base.activity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

import com.example.mvvmlibrary.base.data.BaseViewModel;


/**
 * created by com.tl
 * created at 2020/8/12
 */
public abstract class BaseDataBindingActivity<VB extends ViewDataBinding, VM extends BaseViewModel> extends AppCompatActivity {
    protected VB binding;
    protected VM viewModel;
    private boolean isSetViewModelToFragment = true;//默认让加载的fragment使用activity的viewModel


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataBinding();
        initData(savedInstanceState);
    }

    private void initDataBinding() {
        if (getLayoutID() != 0) {
            binding = DataBindingUtil.setContentView(this, getLayoutID());
        }
        try {
            Class modelClass;
            Type type = getClass().getGenericSuperclass();
            if (type instanceof ParameterizedType) {
                Type[] types = ((ParameterizedType) type).getActualTypeArguments();
                if (types.length > 1) {
                    modelClass = (Class<VM>) ((ParameterizedType) type).getActualTypeArguments()[1];
                } else {//如果没有指定viewmodel泛型,默认使用BaseViewModel
                    modelClass = BaseViewModel.class;
                }
            } else {
                //如果没有指定泛型参数，则默认使用BaseViewModel
                modelClass = BaseViewModel.class;
            }
            viewModel = (VM) getDefaultViewModelProviderFactory().create(modelClass);
            initLiveData();
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        if (getVariableId() != 0) {
            binding.setVariable(getVariableId(), viewModel);
            binding.setLifecycleOwner(this);
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

    public void setViewModelToFragment(boolean isSetViewModelToFragment) {
        this.isSetViewModelToFragment = isSetViewModelToFragment;
    }

    public boolean isSetViewModelToFragment() {
        return isSetViewModelToFragment;
    }

    protected abstract void initData(Bundle savedInstanceState);

    protected abstract int getLayoutID();

    protected abstract int getVariableId();

    public abstract void showLoadingWithTip(FragmentManager fragmentManager, String tip);

    public abstract void hideLoading();

    public abstract void showToastTip(String tip);

    public VM getViewModel() {
        return viewModel;
    }


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
