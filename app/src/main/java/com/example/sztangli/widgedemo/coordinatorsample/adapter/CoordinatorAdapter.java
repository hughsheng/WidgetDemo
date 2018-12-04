package com.example.sztangli.widgedemo.coordinatorsample.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sztangli.widgedemo.R;

import java.util.List;

public class CoordinatorAdapter extends RecyclerView.Adapter<CoordinatorAdapter.CoordinatorHolder> {
  private Context context;
  private List<String> dataList;


  public CoordinatorAdapter(Context context, List<String> dataList) {
    this.context = context;
    this.dataList = dataList;
  }

  @NonNull
  @Override
  public CoordinatorAdapter.CoordinatorHolder onCreateViewHolder(@NonNull ViewGroup parent, int
      viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout
        .item_coordinator, parent, false);

    CoordinatorHolder holder = new CoordinatorHolder(view);
    return holder;
  }

  @Override
  public void onBindViewHolder(@NonNull CoordinatorAdapter.CoordinatorHolder holder, int position) {
    holder.item_text.setText(dataList.get(position));
  }

  @Override
  public int getItemCount() {
    return dataList.size();
  }

  public class CoordinatorHolder extends RecyclerView.ViewHolder {

    TextView item_text;


    public CoordinatorHolder(View itemView) {
      super(itemView);
      item_text = (TextView) itemView.findViewById(R.id.item_text);
    }
  }

}
