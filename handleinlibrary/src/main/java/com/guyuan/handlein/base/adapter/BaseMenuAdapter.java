package com.guyuan.handlein.base.adapter;

import android.content.Context;

import androidx.annotation.NonNull;

import com.example.easy_recycleview_library.adapter.BaseRecyclerAdapter;
import com.example.easy_recycleview_library.adapter.BaseRecyclerViewHolder;
import com.guyuan.handlein.base.R;
import com.guyuan.handlein.base.bean.AppMenusBean;

import java.util.List;


/**
 * Created by TL
 * on 2019/12/13
 */
public class BaseMenuAdapter extends BaseRecyclerAdapter<AppMenusBean> {
    public BaseMenuAdapter(Context context, @NonNull List<AppMenusBean> listData, int layoutID) {
        super(context, listData, layoutID);
    }

    @Override
    protected void bindDataToView(BaseRecyclerViewHolder holder,
                                  AppMenusBean item, int position) {

        holder.setImageUrl(R.id.item_fragment_menu_iv_icon, item.getIcon(),
                R.mipmap.ic_launcher, R.mipmap.ic_launcher);
        holder.setText(R.id.item_fragment_menu_tv_tag, item.getTitle());
    }
}
