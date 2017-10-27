package com.example.toandm.listview_basic.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Movie;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.toandm.listview_basic.R;
import com.example.toandm.listview_basic.model.MovieItem;

import java.util.ArrayList;


/**
 * Created by toandm on 10/27/17.
 */

public class MyAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<MovieItem> movies;

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
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_listview, null);
            holder = new ViewHolder();
            holder.tvID = convertView.findViewById(R.id.tvID);
            holder.tvNameMovie = convertView.findViewById(R.id.tvName);
            holder.tvReleasedYear = convertView.findViewById(R.id.tvYear);
            holder.tvDirectedBy = convertView.findViewById(R.id.tvDirectBy);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        MovieItem movieItem = getItem(position);

        holder.tvID.setText(movieItem.getId());
        holder.tvNameMovie.setText(movieItem.getNameMovie());
        holder.tvReleasedYear.setText(movieItem.getReleasedYear()+"");
        holder.tvDirectedBy.setText(movieItem.getDirectedBy());

        return convertView;
    }

    static class ViewHolder {
        private TextView tvID;
        private TextView tvNameMovie;
        private TextView tvReleasedYear;
        private TextView tvDirectedBy;

    }

}
