package com.example.toandm.listview_basic.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.toandm.listview_basic.R;
import com.example.toandm.listview_basic.adapter.HomeShopAdapter;
import com.example.toandm.listview_basic.adapter.LikeShopAdapter;
import com.example.toandm.listview_basic.data.Database;
import com.example.toandm.listview_basic.model.ShopItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by toandm on 11/6/17.
 */

public class LikeFragment extends android.support.v4.app.Fragment {
    TextView txtData;
    List<ShopItem> listLikeItem;
    private GridLayoutManager layoutManager;
    RecyclerView recyclerView;
    LikeShopAdapter likeAdapter;


    private List<ShopItem> likeList = new ArrayList<ShopItem>();

    public static LikeFragment newInstance() {
        LikeFragment fragment = new LikeFragment();
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_like,null);
        ShopItem likeItem = (ShopItem) getArguments().getSerializable(Database.KEYNAME);
        likeAdapter.updateListLike(likeItem);

        return inflater.inflate(R.layout.fragment_like, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        txtData = view.findViewById(R.id.txtData);
//        txtData.setText(nameProduct.getNameProduct()+" "+nameProduct.getNewPrice()
//                +" "+nameProduct.getOldPrice());

    }



}
