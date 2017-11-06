package com.example.toandm.listview_basic.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.toandm.listview_basic.fragments.LikeFragment;

/**
 * Created by toandm on 11/6/17.
 */

public class LikeShopAdapter extends RecyclerView.Adapter<LikeFragment.LikeViewHolder> {
    @Override
    public LikeFragment.LikeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(LikeFragment.LikeViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    private interface LikeViewHolder {
    }

}
