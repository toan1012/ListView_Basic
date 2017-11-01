package com.example.toandm.listview_basic.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.toandm.listview_basic.R;
import com.example.toandm.listview_basic.model.MovieItem;

import java.util.List;

/**
 * Created by toandm on 10/30/17.
 */

public class MyViewPagerAdapter extends RecyclerView.Adapter<MyViewPagerAdapter.MyViewHolder> {
    private List<MovieItem> list;

    public MyViewPagerAdapter(List<MovieItem> movieList) {
        list = movieList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tvID;
        private TextView tvNameMovie;
        private TextView tvReleasedYear;
        private TextView tvDirectedBy;
        private CheckBox isWatch;
        private LinearLayout itemLayout;


        public MyViewHolder(View itemView) {
            super(itemView);

            tvID = itemView.findViewById(R.id.tvID);
            tvNameMovie = itemView.findViewById(R.id.tvName);
            tvReleasedYear = itemView.findViewById(R.id.tvYear);
            tvDirectedBy = itemView.findViewById(R.id.tvDirectBy);
            isWatch = itemView.findViewById(R.id.cbIsWatchLater);
            itemLayout = itemView.findViewById(R.id.itemLayout);
        }
    }

    @Override
    public MyViewPagerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_listview,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewPagerAdapter.MyViewHolder holder, int position) {
        MovieItem movieItem = list.get(position);
        holder.tvID.setText(movieItem.getId());
        holder.tvNameMovie.setText(movieItem.getNameMovie());
        holder.tvReleasedYear.setText(movieItem.getReleasedYear()+"");
        holder.tvDirectedBy.setText(movieItem.getDirectedBy());
        changeBackground(holder);

    }

    private void changeBackground(MyViewHolder holder) {
        boolean flag = holder.isWatch.isChecked();
        Log.d("FLAG", flag + "");
        if (flag) {
            holder.itemLayout.setBackgroundColor(Color.BLUE);
        } else {
            holder.itemLayout.setBackgroundColor(Color.WHITE);
        }
//        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
