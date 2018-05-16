package com.soal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class GridAdapter extends BaseAdapter {
    private Context context;
    private String[] imageItems;


    public GridAdapter (Context context, String[] imageItems){
        this.context = context;
        this.imageItems = imageItems;
    }

    @Override
    public int getCount() {
        return imageItems.length ;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private static class ViewHolder {
        ImageView imageItems;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        View view = convertView;
        ViewHolder holder;

        if (view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.grid_item,null);
            holder.imageItems = view.findViewById(R.id.image_icon);
            view.setTag(holder);

        } else {
            holder = (ViewHolder)view.getTag();
        }
        Picasso.get().load(imageItems[i]).into(holder.imageItems);
        return view;
    }
}
