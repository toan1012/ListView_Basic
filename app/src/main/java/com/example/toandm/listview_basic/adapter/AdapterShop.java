package com.example.toandm.listview_basic.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.toandm.listview_basic.R;

/**
 * Created by toandm on 11/1/17.
 */

public class AdapterShop extends RecyclerView.Adapter<AdapterShop.ShopViewHolder>{

    mov

    @Override
    public AdapterShop.ShopViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(AdapterShop.ShopViewHolder holder, int position) {
        View view = LayoutInflater.from()
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    private class ShopViewHolder extends RecyclerView.ViewHolder{
        private TextView oldPrice, newPrice, nameProduct;
        private ImageButton ibProduct;

        public ShopViewHolder(View view) {
            super(view);
            oldPrice = view.findViewById(R.id.oldMoney);
            newPrice = view.findViewById(R.id.newMoney);
            ibProduct = view.findViewById(R.id.imProduct);
            nameProduct = view.findViewById(R.id.nameProduct);


        }
    }
}
