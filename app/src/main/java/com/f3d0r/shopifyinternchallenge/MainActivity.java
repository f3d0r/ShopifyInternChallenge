package com.f3d0r.shopifyinternchallenge;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import com.f3d0r.shopifyinternchallenge.retrofit.ShopifyClient;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static final int PAGE = 1;
    public static final String ACCESS_TOKEN = "c32313df0d0ef512ca64d5b336a0d7c6";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://shopicruit.myshopify.com/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        ShopifyClient service = retrofit.create(ShopifyClient.class);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_by_province:
                                Log.d("TAG", "action_by_province");
                                break;
                            case R.id.action_by_year:
                                Log.d("TAG", "action_by_year");
                                break;
                        }
                        return true;
                    }
                });

//        Call<OrderList> repos = service.getOrders(PAGE, ACCESS_TOKEN);
//        repos.enqueue(new Callback<OrderList>() {
//            @Override
//            public void onResponse(Call<OrderList> call, Response<OrderList> response) {
//                OrderList orderList = response.body();
//            }
//
//            @Override
//            public void onFailure(Call<OrderList> call, Throwable t) {
//                Log.d("ERROR", t.toString());
//            }
//        });

    }
}
