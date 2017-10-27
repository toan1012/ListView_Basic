package com.example.toandm.listview_basic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.toandm.listview_basic.adapter.MyAdapter;
import com.example.toandm.listview_basic.model.MovieItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listViewMovie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listViewMovie = (ListView) findViewById(R.id.listMovie);
        ArrayList<MovieItem> arrMovie = new ArrayList<MovieItem>();

        arrMovie.add(new MovieItem("12","Chien tranh giua cac vi sao",true,2010,"Antonio Valencia"));
        arrMovie.add(new MovieItem("13","Tom and jerry",false,1990,"John Howards"));
        arrMovie.add(new MovieItem("14","Supper man",false,2010,"Moninho"));
        arrMovie.add(new MovieItem("15","Queen",true,2000,"Manh Toan"));
        arrMovie.add(new MovieItem("16","Nuoc mat",false,2004,"Tom Sawyer"));
        arrMovie.add(new MovieItem("17","Cuoc chien vuong quyen",true,2006,"Nha Phuong"));
        arrMovie.add(new MovieItem("18","Hai so phan",true,2007,"Truong Giang"));
        arrMovie.add(new MovieItem("19","Ngoi nha hoang",true,2010,"Tran Thanh"));
        arrMovie.add(new MovieItem("20","Bup be arabella",true,2012,"Vuong trieu Vu"));
        arrMovie.add(new MovieItem("21","Sao thang Tam",true,1997,"Chi Dan"));
        arrMovie.add(new MovieItem("22","Ben Thuong Hai",true,2017,"Lam Tam nhu"));
        arrMovie.add(new MovieItem("23","Trong long dan",true,2015,"Tap Can Binh"));
        arrMovie.add(new MovieItem("24","Dam cuoi chuot",true,2010,"Ly Bang"));
        arrMovie.add(new MovieItem("25","Tup leu cua bac Tom",true,2009,"Tan Son Nhat"));


        MyAdapter adapter = new MyAdapter(this,arrMovie);
        listViewMovie.setAdapter(adapter);

    }
}