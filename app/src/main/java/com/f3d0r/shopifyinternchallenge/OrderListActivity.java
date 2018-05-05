package com.f3d0r.shopifyinternchallenge;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.f3d0r.shopifyinternchallenge.jackson_models.Order;

import java.util.List;

public class OrderListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        List<Order> orderList = (List<Order>) intent.getSerializableExtra("orderList"); //if it's a string you stored.

//        TODO: Finish Expandable Recycler View code
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
