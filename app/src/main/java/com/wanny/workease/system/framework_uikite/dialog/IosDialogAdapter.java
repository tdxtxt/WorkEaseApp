package com.wanny.workease.system.framework_uikite.dialog;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.wanny.workease.system.R;

import java.util.ArrayList;

/**
 * 文件名： IosDialogAdapter
 * 功能：
 * 作者： wanny
 * 时间： 12:08 2017/6/6
 */
public class IosDialogAdapter extends BaseAdapter {


    private ArrayList<String> dataList;
    private Context context;

    public IosDialogAdapter(ArrayList<String> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public String getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.ordinal_item_textview_view,null);
            viewHolder = new ViewHolder();
            viewHolder.name = (TextView)convertView.findViewById(R.id.ordinal_item_textview);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }
        if(dataList != null && dataList.size() > 0){
            String name = dataList.get(position);
            if(!TextUtils.isEmpty(name)){
                viewHolder.name.setTextColor(ContextCompat.getColor(context,R.color.low_blue));
                viewHolder.name.setText(name);
            }
        }
        return convertView;
    }

    public class ViewHolder{
        public TextView name;
    }
}
