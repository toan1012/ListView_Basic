package com.example.toandm.listview_basic.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.toandm.listview_basic.R;
import com.example.toandm.listview_basic.adapter.HomeShopAdapter;
import com.example.toandm.listview_basic.data.Database;
import com.example.toandm.listview_basic.impl.OnItemClickedListener;
import com.example.toandm.listview_basic.model.MovieItem;
import com.example.toandm.listview_basic.model.ShopItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by toandm on 11/6/17.
 */

public class HomeFragment extends android.support.v4.app.Fragment {
    private RecyclerView recyclerViewShop;
    private GridLayoutManager layoutManager;
    private HomeShopAdapter homeShopAdapter;
    private OnManagerData onManagerData;



    public interface OnManagerData{
        void sendData(ShopItem item);
    }

    private OnItemClickedListener onItemClickedListener = new OnItemClickedListener() {
        @Override
        public void onClicked(ShopItem item, int position) {
            //onItemClickedListener.onClicked(item,position);
            onManagerData.sendData(item);
            Toast.makeText(getActivity(), item.getNameProduct(),Toast.LENGTH_SHORT).show();
        }
    };
    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnManagerData){
            onManagerData = (OnManagerData) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement onViewSelected");
        }

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,null);
        recyclerViewShop = view.findViewById(R.id.listShop);
        List<ShopItem> listShop = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            int position = i % 6;
            listShop.add(new ShopItem(Database.OLDPRICE[position],
                    Database.NEWPRICE[position], Database.NAME[position],
                    Database.THUMNAILS[position]));
        }
        //Log.d("VALUES", listShop.get(998).getNameProduct() + "");

        homeShopAdapter = new HomeShopAdapter(listShop);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerViewShop.setLayoutManager(mLayoutManager);
        recyclerViewShop.setItemAnimator(new DefaultItemAnimator());
        layoutManager= new GridLayoutManager(getContext(),2);
        recyclerViewShop.hasFixedSize();
        recyclerViewShop.setLayoutManager(layoutManager);
        recyclerViewShop.setAdapter(homeShopAdapter);
        homeShopAdapter.setOnItemClickedListener(onItemClickedListener);

        return view;
    }
}
