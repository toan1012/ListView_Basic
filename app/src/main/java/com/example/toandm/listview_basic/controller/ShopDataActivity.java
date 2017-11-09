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
import com.example.toandm.listview_basic.model.ShopItem;

import java.util.ArrayList;

/**
 * Created by toandm on 11/6/17.
 */

public class ShopDataActivity extends AppCompatActivity implements HomeFragment.OnManagerData{

    ArrayList<ShopItem> listLike = new ArrayList<ShopItem>();
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
                                break;
                            case R.id.action_filter:
                                selectedFragment = FilterFragment.newInstance();
                                break;
                            case R.id.action_search:
                                selectedFragment = FilterFragment.newInstance();
                                break;
                            case R.id.action_setting:
                                selectedFragment = FilterFragment.newInstance();
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

        //Used to select an item programmatically
        //bottomNavigationView.getMenu().getItem(2).setChecked(true);
    }


    @Override
    public void sendData(ShopItem item) {
        LikeFragment likeFragment = new LikeFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(Database.KEYNAME,item);
        likeFragment.setArguments(bundle);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back

        transaction.replace(R.id.frame_layout, likeFragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }
}
