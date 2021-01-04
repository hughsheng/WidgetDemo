package com.guyuan.handlein.base.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.guyuan.handlein.base.R;
import com.guyuan.handlein.base.bean.HeadBean;
import com.guyuan.handlein.base.ui.customizeview.flowlayout.FlowLayout;
import com.guyuan.handlein.base.ui.customizeview.flowlayout.TagAdapter;
import com.guyuan.handlein.base.util.glide.GlideUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * @description: 员工列表adapter
 * @author:Jannonx
 * @date: 2020/6/4 10:10
 */
public class TagStaffAdapter extends TagAdapter<HeadBean> {
    private Context mContext;
    private boolean isDeleteFlag = true;

    public TagStaffAdapter(Context context, List<HeadBean> dataList, boolean isFlag) {
        this(context, dataList);
        isDeleteFlag = isFlag;
    }

    public TagStaffAdapter(Context context, List<HeadBean> dataList) {
        this(dataList);
        mContext = context;
    }

    private TagStaffAdapter(List<HeadBean> dataList) {
        super(dataList);
    }

    @Override
    public View getView(FlowLayout parent, int position, HeadBean HeadBean) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_small_person,
                parent, false);
        TextView tv = view.findViewById(R.id.item_deletable_tag_tv_name);
        ImageView iv = view.findViewById(R.id.item_deletable_tag_iv_remove);
        ImageView icon = view.findViewById(R.id.item_deletable_tag_iv_icon);
        iv.setVisibility(isDeleteFlag ? View.VISIBLE : View.GONE);
        tv.setText(HeadBean.getName());
        GlideUtils.getInstance().loadUserCircleImageFromGuYuanServer(icon, HeadBean.getHeadUrl());
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTagDatas.remove(position);
                notifyDataChanged();
            }
        });
        return view;
    }


    @Override
    public ArrayList<HeadBean> getTagDataList() {
        return (ArrayList<HeadBean>) super.getTagDataList();
    }
}
