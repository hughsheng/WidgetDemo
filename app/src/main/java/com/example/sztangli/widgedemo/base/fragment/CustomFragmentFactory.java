package com.example.sztangli.widgedemo.base.fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;

/**
 * created by tl
 * created at 2020/8/3
 */
public class CustomFragmentFactory extends FragmentFactory {
    @NonNull
    @Override
    public Fragment instantiate(@NonNull ClassLoader classLoader, @NonNull String className) {

        return super.instantiate(classLoader, className);
    }
}
