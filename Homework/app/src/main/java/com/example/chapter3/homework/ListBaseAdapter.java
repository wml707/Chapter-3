package com.example.chapter3.homework;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListBaseAdapter extends BaseAdapter {

    private static final int NUM_LIST_ITEMS = 5;

    @Override
    public int getCount() {
        return NUM_LIST_ITEMS;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = View.inflate(parent.getContext(), R.layout.item, null);
            holder.avatarImage = (ImageView) convertView.findViewById(R.id.item_avatar);
            holder.itemName = (TextView) convertView.findViewById(R.id.item_name);
            holder.itemStatus = (TextView) convertView.findViewById(R.id.item_status);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // 设置头像
        holder.avatarImage.setImageResource(R.drawable.avatar_placeholder);  // 头像资源可以动态设置

        // 设置好友名称
        holder.itemName.setText("好友 " + (position + 1));

        // 设置状态（这里假设状态为“在线”）
        if (position % 2 == 0) {
            holder.itemStatus.setText("在线");
            holder.itemStatus.setTextColor(0xFF4CAF50); // 在线状态为绿色
        } else {
            holder.itemStatus.setText("离线");
            holder.itemStatus.setTextColor(0xFF757575); // 离线状态为灰色
        }

        return convertView;
    }

    private static class ViewHolder {
        private ImageView avatarImage;
        private TextView itemName;
        private TextView itemStatus;
    }
}
