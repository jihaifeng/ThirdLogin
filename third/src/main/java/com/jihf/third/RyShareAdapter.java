package com.jihf.third;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Date：2017-04-21 17:42
 * Mail：jihaifeng@raiyi.com
 */
public class RyShareAdapter extends RecyclerView.Adapter<RyShareAdapter.MyViewHolder> {
  public static final String TAG = RyShareAdapter.class.getSimpleName();
  private List<ShareBean> mList;

  @Override public RyShareAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_share, null);
    return new MyViewHolder(view);
  }

  @Override public void onBindViewHolder(MyViewHolder holder, int position) {
    Log.i(TAG, "onBindViewHolder: " + mList.get(position).shareText);
    holder.tvShare.setText(mList.get(position).shareText);
    holder.ivShare.setBackgroundResource(mList.get(position).shareImg);
  }

  @Override public int getItemCount() {
    return null == mList ? 0 : mList.size();
  }

  public void setData(List<ShareBean> list) {
    mList = list;
    notifyDataSetChanged();
  }

  class MyViewHolder extends RecyclerView.ViewHolder {
    TextView tvShare;
    ImageView ivShare;

    public MyViewHolder(View itemView) {
      super(itemView);
      tvShare = (TextView) itemView.findViewById(R.id.tv_share);
      ivShare = (ImageView) itemView.findViewById(R.id.iv_share);
    }
  }
}
