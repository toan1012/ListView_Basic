package com.example.toandm.listview_basic.controller;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.toandm.listview_basic.R;
import com.example.toandm.listview_basic.data.Database;
import com.example.toandm.listview_basic.fragments.FilterFragment;
import com.example.toandm.listview_basic.fragments.HomeFragment;
import com.example.toandm.listview_basic.fragments.LikeFragment;
import com.example.toandm.listview_basic.fragments.SearchFragment;
import com.example.toandm.listview_basic.fragments.SettingFragment;
import com.example.toandm.listview_basic.model.ShopItem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by toandm on 11/6/17.
 */

public class ShopMainActivity extends AppCompatActivity implements HomeFragment.OnManagerData{

    List<ShopItem> likeList = new ArrayList<ShopItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_actionbar);
        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;
                        switch (item.getItemId()) {
                            case R.id.action_home:
                                selectedFragment = HomeFragment.newInstance();
                                break;
                            case R.id.action_like:
                                selectedFragment = LikeFragment.newInstance();
                                Bundle bundle = new Bundle();
                                bundle.putSerializable(Database.KEYNAME, (Serializable) likeList);
                                selectedFragment.setArguments(bundle);
                                break;
                            case R.id.action_filter:
                                selectedFragment = FilterFragment.newInstance();
                                break;
                            case R.id.action_search:
                                selectedFragment = SearchFragment.newInstance();
                                break;
                            case R.id.action_setting:
                                selectedFragment = SettingFragment.newInstance();
                                break;
                        }
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_layout, selectedFragment);
                        transaction.commit();
                        return true;
                    }
                });

        //Manually displaying the first fragment - one time only
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, HomeFragment.newInstance());
        transaction.commit();

    }


    @Override
    public void sendData(ShopItem item) {
        likeList.add(item);
//        LikeFragment likeFragment = new LikeFragment();
//        Bundle bundle = new Bundle();
//        bundle.putSerializable(Database.KEYNAME, (Serializable) likeList);
//        likeFragment.setArguments(bundle);
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        // Replace whatever is in the fragment_container view with this fragment,
//        // and add the transaction to the back stack so the user can navigate back
//
//        transaction.replace(R.id.frame_layout, likeFragment);
//        transaction.addToBackStack(null);
//        transaction.commit();

    }
}
