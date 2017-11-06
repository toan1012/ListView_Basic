package com.example.toandm.listview_basic.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.toandm.listview_basic.R;
import com.example.toandm.listview_basic.adapter.MyViewPagerAdapter;
import com.example.toandm.listview_basic.model.MovieItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by toandm on 10/30/17.
 */

public class SecondActivity extends Activity{

    private List<MovieItem> movieList = new ArrayList<MovieItem>();
    private RecyclerView recyclerView;
    private MyViewPagerAdapter mAdapter;
    Button btNextShop;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        recyclerView = (RecyclerView) findViewById(R.id.recycleview);
        btNextShop = findViewById(R.id.btshop);
        btNextShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(SecondActivity.this, ShopFragmentActivity.class);
                startActivity(intent1);
            }
        });

        mAdapter = new MyViewPagerAdapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        prepareMovieData();
    }

    private void prepareMovieData() {
        movieList.add(new MovieItem("12","Chien tranh giua cac vi sao",true,2010,"Antonio Valencia"));
        movieList.add(new MovieItem("13","Tom and jerry",false,1990,"John Howards"));
        movieList.add(new MovieItem("14","Supper man",false,2010,"Moninho"));
        movieList.add(new MovieItem("15","Queen",true,2000,"Manh Toan"));
        movieList.add(new MovieItem("16","Nuoc mat",false,2004,"Tom Sawyer"));
        movieList.add(new MovieItem("17","Cuoc chien vuong quyen",true,2006,"Nha Phuong"));
        movieList.add(new MovieItem("18","Hai so phan",true,2007,"Truong Giang"));
        movieList.add(new MovieItem("19","Ngoi nha hoang",true,2010,"Tran Thanh"));
        movieList.add(new MovieItem("20","Bup be arabella",true,2012,"Vuong trieu Vu"));
        movieList.add(new MovieItem("21","Sao thang Tam",true,1997,"Chi Dan"));
        movieList.add(new MovieItem("22","Ben Thuong Hai",true,2017,"Lam Tam nhu"));
        movieList.add(new MovieItem("23","Trong long dan",true,2015,"Tap Can Binh"));
        movieList.add(new MovieItem("24","Dam cuoi chuot",true,2010,"Ly Bang"));
        movieList.add(new MovieItem("25","Tup leu cua bac Tom",true,2009,"Tan Son Nhat"));
        mAdapter.notifyDataSetChanged();

    }
}
