package com.example.toandm.listview_basic.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.toandm.listview_basic.R;
import com.example.toandm.listview_basic.impl.OnItemCheckedListener;
import com.example.toandm.listview_basic.model.MovieItem;

import java.util.ArrayList;


/**
 * Created by toandm on 10/27/17.
 */

public class MyAdapter extends BaseAdapter {

    private OnItemCheckedListener onItemCheckedListener;

    public void setOnItemCheckedListener(OnItemCheckedListener onItemCheckedListener) {
        this.onItemCheckedListener = onItemCheckedListener;
    }

    private Context context;
    private ArrayList<MovieItem> movies;

    public void setMovies(ArrayList<MovieItem> movies) {
        this.movies = movies;
    }


    public MyAdapter(Context context, ArrayList<MovieItem> movies) {
        this.context = context;
        this.movies = movies;
    }



    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public MovieItem getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_listview, null);
            holder = new ViewHolder();
            holder.tvID = convertView.findViewById(R.id.tvID);
            holder.tvNameMovie = convertView.findViewById(R.id.tvName);
            holder.tvReleasedYear = convertView.findViewById(R.id.tvYear);
            holder.tvDirectedBy = convertView.findViewById(R.id.tvDirectBy);
            holder.checkBox = convertView.findViewById(R.id.cbIsWatchLater);
            holder.itemLayout = convertView.findViewById(R.id.itemLayout);

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        final MovieItem movieItem = getItem(position);

        holder.tvID.setText(movieItem.getId());
        holder.tvNameMovie.setText(movieItem.getNameMovie());
        holder.tvReleasedYear.setText(movieItem.getReleasedYear()+"");
        holder.tvDirectedBy.setText(movieItem.getDirectedBy());
        holder.checkBox.setChecked(movieItem.isWatchLater());
//        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                onItemCheckedListener.onChecked(movieItem,position);
//            }
//        });
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemCheckedListener.onChecked(movieItem,position);
            }
        });

       changeBackground(holder);

        return convertView;
    }

    private void changeBackground(ViewHolder holder) {
        boolean flag = holder.checkBox.isChecked();
        Log.d("FLAG",flag+"");
        if (flag){
            holder.itemLayout.setBackgroundColor(Color.BLUE);
        }else {
            holder.itemLayout.setBackgroundColor(Color.WHITE);
        }
        //notifyDataSetChanged();

    }

    static class ViewHolder {
        private TextView tvID;
        private TextView tvNameMovie;
        private TextView tvReleasedYear;
        private TextView tvDirectedBy;
        private CheckBox checkBox;
        private LinearLayout itemLayout;

    }

}
