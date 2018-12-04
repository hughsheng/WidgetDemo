package com.example.sztangli.widgedemo.coordinatorsample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.example.sztangli.widgedemo.R;

import java.util.List;

public class TypeAdapter extends BaseAdapter implements SpinnerAdapter {

  private List<String> dataList;
  private Context context;

  public TypeAdapter(Context context, List<String> dataList) {
    this.context = context;
    this.dataList = dataList;
  }

  @Override
  public int getCount() {
    return dataList.size();
  }

  @Override
  public Object getItem(int position) {
    return dataList.get(position);
  }

  @Override
  public long getItemId(int position) {
    return position;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    DefaultHodler hodler = null;
    if (convertView == null) {
      hodler = new DefaultHodler();
      convertView = LayoutInflater.from(context).inflate(R.layout.item_coordinator, null);
      hodler.default_TV = (TextView) convertView.findViewById(R.id.item_text);
      convertView.setTag(hodler);
    } else {
      hodler = (DefaultHodler) convertView.getTag();
    }

    hodler.default_TV.setText(dataList.get(position));
    return convertView;
  }



  @Override
  public View getDropDownView(int position, View convertView, ViewGroup parent) {
    DropDownHolder hodler = null;
    if (convertView == null) {
      hodler = new DropDownHolder();
      convertView = LayoutInflater.from(context).inflate(R.layout.item_coordinator, null);
      hodler.dropDown_TV = (TextView) convertView.findViewById(R.id.item_text);
      convertView.setTag(hodler);
    } else {
      hodler = (DropDownHolder) convertView.getTag();
    }

    hodler.dropDown_TV.setText(dataList.get(position));
    return convertView;
  }

  private static class DefaultHodler {
    TextView default_TV;
  }

  private static class DropDownHolder {
    TextView dropDown_TV;
  }

}
