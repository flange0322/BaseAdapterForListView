package com.example.cjcu.baseadapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private String[][] data;
    static class ViewHolder{
        LinearLayout layout;
        TextView mTextView_Name;
        TextView mTextView_Address;
    }

    public MyAdapter(String[][] data,LayoutInflater inflater){
        this.data = data;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        return data[position][1];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null) {
            convertView = inflater.inflate(R.layout.templayout, null);
            viewHolder = new ViewHolder();

            viewHolder.mTextView_Name = (TextView) convertView.findViewById(R.id.tv_Name);
            viewHolder.mTextView_Address = (TextView) convertView.findViewById(R.id.tv_Address);
            viewHolder.layout = (LinearLayout) convertView.findViewById(R.id.layout_Linear);
            convertView.setTag(viewHolder);

            if(data[position][0].equals("1")){
                viewHolder.mTextView_Name.setText("★");
            }
        }
        else
            viewHolder = (ViewHolder)convertView.getTag();

            viewHolder.mTextView_Address.setText(data[position][1]);

        return convertView;
    }
}
