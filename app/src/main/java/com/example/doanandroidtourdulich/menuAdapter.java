package com.example.doanandroidtourdulich;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

public class menuAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<itemMenu> list;

    public menuAdapter(Context context, int layout, List<itemMenu> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder{
        ImageView img;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView= inflater.inflate(layout, null);
            viewHolder = new ViewHolder();

            viewHolder.img = (ImageView) convertView.findViewById(R.id.imgicon);

            convertView.setTag(viewHolder);
        }else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.img.setImageResource(list.get(position).icon);
        return convertView;

    }
}
