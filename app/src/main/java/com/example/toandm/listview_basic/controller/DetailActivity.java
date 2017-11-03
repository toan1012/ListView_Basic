package com.example.toandm.listview_basic.controller;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.example.toandm.listview_basic.R;

import org.w3c.dom.Text;

/**
 * Created by toandm on 11/3/17.
 */

public class DetailActivity extends Activity {
     private TextView name;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        String nameProduct = getIntent().getStringExtra("name");
        name = findViewById(R.id.detail);
        name.setText(nameProduct);
    }
}
