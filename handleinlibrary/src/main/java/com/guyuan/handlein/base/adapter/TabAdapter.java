package com.guyuan.handlein.base.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

/**
 * Created by TL
 * on 2019/11/28
 */
public class TabAdapter extends FragmentStateAdapter {
    private List<Fragment> fragmentList;

    public TabAdapter(@NonNull FragmentActivity fm, List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getItemCount() {
        return fragmentList.size();
    }

    public List<Fragment> getFragmentList() {
        return fragmentList;
    }
}
