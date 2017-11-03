package com.example.toandm.listview_basic.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.toandm.listview_basic.R;
import com.example.toandm.listview_basic.impl.OnItemCheckedListener;
import com.example.toandm.listview_basic.impl.OnItemClickedListener;
import com.example.toandm.listview_basic.model.ShopItem;

import java.util.List;

/**
 * Created by toandm on 11/1/17.
 */

public class AdapterShop extends RecyclerView.Adapter<AdapterShop.ShopViewHolder>{
    private Context context;
    private List<ShopItem> listShopItem;
    private AdapterShop.ShopViewHolder holder;
    private OnItemClickedListener onItemClickedListener;

    public void setOnItemClickedListener(OnItemClickedListener onItemClickedListener) {
        this.onItemClickedListener = onItemClickedListener;
    }

    public AdapterShop(Context context, List<ShopItem> listShopItem){
        this.context = context;
        this.listShopItem = listShopItem;
    }

    @Override
    public AdapterShop.ShopViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shop,parent,false);
        return new AdapterShop.ShopViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ShopViewHolder holder, final int position) {
        final ShopItem shopItem = listShopItem.get(position);
        holder.oldPrice.setText(shopItem.getOldPrice());
        holder.newPrice.setText(shopItem.getNewPrice());
        holder.nameProduct.setText(shopItem.getNameProduct());
        holder.ibProduct.setImageResource(shopItem.getImg());
       holder.layoutItem.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               onItemClickedListener.onClicked(shopItem, position);
           }
       });
    }

    @Override
    public int getItemCount() {
        return listShopItem.size();
    }

    public class ShopViewHolder extends RecyclerView.ViewHolder{
        private TextView oldPrice, newPrice, nameProduct;
        private ImageView ibProduct;
        private LinearLayout layoutItem;


        private ShopViewHolder(View view) {
            super(view);
            oldPrice = view.findViewById(R.id.oldMoney);
            newPrice = view.findViewById(R.id.newMoney);
            ibProduct = view.findViewById(R.id.imProduct);
            nameProduct = view.findViewById(R.id.nameProduct);
            layoutItem = view.findViewById(R.id.itemLayout);
        }
    }
}
