package com.pansijing.newsmth.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.pansijing.newsmth.R;
import com.pansijing.newsmth.model.bean.Top10;
import java.util.List;

/**
 * @author: zhuhuanhuan
 * @time: 2017/5/5-17:21
 * @email: zhuhuanhuan@qccr.com
 * @desc:
 */

public class Top10Adapter extends RecyclerView.Adapter<Top10Adapter.Top10ViewHolder> {

  List<Top10> mData;

  @Override public Top10ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new Top10ViewHolder(
        LayoutInflater.from(parent.getContext()).inflate(R.layout.top10_item, parent, false));
  }

  @Override public void onBindViewHolder(Top10ViewHolder holder, int position) {
    holder.item.setText(mData.get(position).title);
  }

  @Override public int getItemCount() {
    return mData == null ? 0 : mData.size();
  }

  public void setData(List<Top10> data) {
    mData = data;
    notifyDataSetChanged();
  }

  public static class Top10ViewHolder extends RecyclerView.ViewHolder {

    TextView item;

    Top10ViewHolder(View view) {
      super(view);
      item = (TextView) view.findViewById(R.id.item);
    }
  }
}
