package com.ateam.remindme.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ateam.remindme.R;

import java.util.ArrayList;


public class ItemsArrayAdapters extends ArrayAdapter<String> {

    Context mContext;
    ArrayList<String> mArrayList;

    public ItemsArrayAdapters(Context context,ArrayList<String> arrayList){
        super(context, R.layout.item_list, arrayList);
        mContext = context;
        mArrayList = arrayList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder;

        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_list, parent, false);
            holder = new ViewHolder();
            holder.itemName = (TextView) convertView.findViewById(R.id.itemText);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.itemName.setText(mArrayList.get(position));
        return convertView;
    }

    public static class ViewHolder{
        TextView itemName;
    }
}
