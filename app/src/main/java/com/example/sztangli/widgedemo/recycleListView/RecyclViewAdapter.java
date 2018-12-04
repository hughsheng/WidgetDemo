package com.example.sztangli.widgedemo.recycleListView;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.sztangli.widgedemo.R;
import com.example.sztangli.widgedemo.base.adapter.BaseRecyclerAdapter;

import java.util.Collection;
import java.util.List;

import tl.com.easy_recycleview_library.BaseRecyclerViewHolder;

/**
 * Created by sztangli on 2017/8/15.
 */

public class RecyclViewAdapter extends BaseRecyclerAdapter<RecycleBean> {

     RecyclViewAdapter(Context context, @NonNull List<RecycleBean> listData, int layoutID) {
        super(context, listData, layoutID);
    }

    @Override
    protected void bindDataToView(BaseRecyclerViewHolder holder, RecycleBean item, int position) {
        holder.setText(R.id.tv_recycle_item, listData.get(position).getContent());
    }


    public void addAll(Collection<RecycleBean> list) {
        int lastIndex = this.listData.size();
        if (this.listData.addAll(list)) {
            notifyItemRangeInserted(lastIndex, list.size());
        }
    }

}
