package com.f3d0r.shopifyinternchallenge;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.f3d0r.shopifyinternchallenge.jackson_models.Order;
import com.f3d0r.shopifyinternchallenge.jackson_models.OrderList;
import com.f3d0r.shopifyinternchallenge.retrofit.ShopifyClient;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    public static final int PAGE = 1;
    public static final String ACCESS_TOKEN = "c32313df0d0ef512ca64d5b336a0d7c6";

    private Retrofit retrofit;
    private ShopifyClient shopifyService;

    private List<Order> orderList;

    private Map<String, Integer> ordersByProvince;
    private Map<Integer, Integer> ordersByYear;

    private RecyclerView provinceRecyclerView;
    private RecyclerView yearRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private YearAdapter yearAdapter;
    private ProvincesAdapter provincesAdapter;

    private TextView mOrdersByProvince;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Timber.plant(new Timber.DebugTree());

        retrofit = new Retrofit.Builder()
                .baseUrl("https://shopicruit.myshopify.com/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        shopifyService = retrofit.create(ShopifyClient.class);

        mOrdersByProvince = findViewById(R.id.tv_orders_by_providence);
        mOrdersByProvince.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: Implement EXTRA 2
            }
        });

        getOrders();
    }

    public void getOrders() {
        // Set up progress before call
        final ProgressDialog progressDialog;
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMax(100);
        progressDialog.setMessage("Its loading....");
        progressDialog.setTitle("ProgressDialog bar example");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        // show it
        progressDialog.show();

        Call<OrderList> getOrdersCall = shopifyService.getOrders(PAGE, ACCESS_TOKEN);
        getOrdersCall.enqueue(new Callback<OrderList>() {
            @Override
            public void onResponse(Call<OrderList> call, Response<OrderList> response) {
                orderList = response.body().getOrders();
                organizeOrders();
                populateOrders();
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<OrderList> call, Throwable t) {
                Timber.tag("ERROR").d(t.toString());
                progressDialog.dismiss();
            }
        });
    }

    public void organizeOrders() {
        ordersByProvince = new TreeMap<>();
        ordersByYear = new TreeMap<>();
        for (Order currentOrder : orderList) {
            String currentOrderProvince = "No Address";
            if (currentOrder.getShippingAddress() != null)
                currentOrderProvince = currentOrder.getShippingAddress().getProvince();

            if (!ordersByProvince.containsKey(currentOrderProvince))
                ordersByProvince.put(currentOrderProvince, 0);
            ordersByProvince.put(currentOrderProvince, ordersByProvince.get(currentOrderProvince) + 1);

            int currentOrderYear = Integer.parseInt(currentOrder.getCreatedAt().substring(0, currentOrder.getCreatedAt().indexOf("-")));
            if (!ordersByYear.containsKey(currentOrderYear))
                ordersByYear.put(currentOrderYear, 0);
            ordersByYear.put(currentOrderYear, ordersByYear.get(currentOrderYear) + 1);
        }
    }

    public void populateOrders() {
        provinceRecyclerView = findViewById(R.id.province_list);
        provinceRecyclerView.setHasFixedSize(true);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        provinceRecyclerView.setLayoutManager(mLayoutManager);
        // specify an adapter (see also next example)
        provincesAdapter = new ProvincesAdapter(ordersByProvince);
        provinceRecyclerView.setAdapter(provincesAdapter);

        yearRecyclerView = findViewById(R.id.year_list);
        yearRecyclerView.setHasFixedSize(true);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        yearRecyclerView.setLayoutManager(mLayoutManager);
        // specify an adapter (see also next example)
        yearAdapter = new YearAdapter(ordersByYear);
        yearRecyclerView.setAdapter(yearAdapter);
    }


    // create an action bar button
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.app_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // handle button activities
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.refresh_button) {
            getOrders();
        }
        return super.onOptionsItemSelected(item);
    }
}
