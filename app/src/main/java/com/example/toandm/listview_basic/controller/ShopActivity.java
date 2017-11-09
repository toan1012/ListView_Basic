package com.example.toandm.listview_basic.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.toandm.listview_basic.R;
import com.example.toandm.listview_basic.adapter.HomeShopAdapter;
import com.example.toandm.listview_basic.data.Database;
import com.example.toandm.listview_basic.impl.OnItemClickedListener;
import com.example.toandm.listview_basic.model.ShopItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by toandm on 10/31/17.
 */

public class ShopActivity extends Activity {
    RecyclerView recyclerViewShop;
    GridLayoutManager layoutManager;
    private HomeShopAdapter homeShopAdapter;

    private OnItemClickedListener onItemClickedListener = new OnItemClickedListener() {
        @Override
        public void onClicked(ShopItem item, int position) {
//            Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
//            intent.putExtra("name",item.getNameProduct());
//            startActivity(intent);
//            Toast.makeText(getApplicationContext(), item.getNameProduct(),Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_activity);


        recyclerViewShop = findViewById(R.id.recycleviewShop);
        List<ShopItem> listShop = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            int position = i % 6;
            listShop.add(new ShopItem(Database.OLDPRICE[position],
                    Database.NEWPRICE[position], Database.NAME[position],
                    Database.THUMNAILS[position]));
        }
        Log.d("VALUES", listShop.get(998).getNameProduct() + "");

        homeShopAdapter = new HomeShopAdapter(this, listShop);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewShop.setLayoutManager(mLayoutManager);
        recyclerViewShop.setItemAnimator(new DefaultItemAnimator());
        layoutManager= new GridLayoutManager(this,2);
        recyclerViewShop.hasFixedSize();
        recyclerViewShop.setLayoutManager(layoutManager);
        recyclerViewShop.setAdapter(homeShopAdapter);
        //homeShopAdapter.setOnCartClickedListener();
    }
}