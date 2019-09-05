package com.example.sztangli.widgedemo.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.sztangli.widgedemo.R;

import java.util.ArrayList;


/**
 * Created by sztangli on 2017/7/13.
 */

public class WidgeAdapter extends BaseAdapter {

    private ArrayList<String> data;
    private Context mContext;
    public WidgeAdapter(Context mContext,ArrayList<String> data) {
        this.data=data;
        this.mContext=mContext;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if(convertView==null){
            LayoutInflater inflater=LayoutInflater.from(mContext);
            convertView=inflater.inflate(R.layout.item_widge,null);
            holder=new ViewHolder();
            holder.widgeName= (TextView) convertView.findViewById(R.id.widge_name);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }

        holder.widgeName.setText(data.get(position));

        return convertView;
    }

    class ViewHolder{
        TextView widgeName;
    }
}
