package com.f3d0r.shopifyinternchallenge;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.f3d0r.shopifyinternchallenge.adapters.OrderAdapter;
import com.f3d0r.shopifyinternchallenge.adapters.ProvincesAdapter;
import com.f3d0r.shopifyinternchallenge.jackson_models.Order;
import com.f3d0r.shopifyinternchallenge.jackson_models.OrderList;
import com.f3d0r.shopifyinternchallenge.retrofit.ShopifyClient;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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
    public static final int ORDER_YEAR = 2017;

    private ShopifyClient shopifyService;

    private List<Order> orderList;

    private Map<String, List<Order>> ordersByProvince;
    private Map<Integer, List<Order>> ordersByYear;
    private Map<String, Integer> orderAmountsByProvince;

    private TextView mTotalOrdersByYear;

    private ProgressBar progressBar;
    private LinearLayout container;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
        container = findViewById(R.id.main_activity_container);

        progressBar.setVisibility(View.VISIBLE);
        container.setVisibility(View.GONE);

        Timber.plant(new Timber.DebugTree());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://shopicruit.myshopify.com/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        shopifyService = retrofit.create(ShopifyClient.class);

        TextView mOrdersByProvince = findViewById(R.id.tv_orders_by_province);
        mOrdersByProvince.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, OrderListActivity.class);
                myIntent.putExtra("ordersByProvince", (Serializable) ordersByProvince); //Optional parameters
                startActivity(myIntent);
            }
        });

        mTotalOrdersByYear = findViewById(R.id.tv_total_orders_by_year);
        getOrders();
    }

    public void getOrders() {
//        TODO: Replace ProgressDialog with loading/progress circle of some sort

        Call<OrderList> getOrdersCall = shopifyService.getOrders(PAGE, ACCESS_TOKEN);
        getOrdersCall.enqueue(new Callback<OrderList>() {
            @Override
            public void onResponse(@NonNull Call<OrderList> call, @NonNull Response<OrderList> response) {
                orderList = Objects.requireNonNull(response.body()).getOrders();
                organizeOrders();
                populateOrders();
                progressBar.setVisibility(View.GONE);
                container.setVisibility(View.VISIBLE);
            }

            @Override
            public void onFailure(@NonNull Call<OrderList> call, @NonNull Throwable t) {
                Timber.tag("ERROR").d(t.toString());
                progressBar.setVisibility(View.GONE);
                container.setVisibility(View.VISIBLE);
            }
        });
    }

    public void organizeOrders() {
        ordersByProvince = new TreeMap<>();
        ordersByYear = new TreeMap<>();
        orderAmountsByProvince = new TreeMap<>();
        for (Order currentOrder : orderList) {
            String currentOrderProvince = "No Address";
            if (currentOrder.getShippingAddress() != null)
                currentOrderProvince = currentOrder.getShippingAddress().getProvince();

            if (!ordersByProvince.containsKey(currentOrderProvince))
                ordersByProvince.put(currentOrderProvince, new ArrayList<Order>());

            List<Order> currentProvinceOrderList = ordersByProvince.get(currentOrderProvince);
            currentProvinceOrderList.add(currentOrder);
            ordersByProvince.put(currentOrderProvince, currentProvinceOrderList);

            int currentOrderYear = Integer.parseInt(currentOrder.getCreatedAt().substring(0, currentOrder.getCreatedAt().indexOf("-")));
            if (!ordersByYear.containsKey(currentOrderYear))
                ordersByYear.put(currentOrderYear, new ArrayList<Order>());

            List<Order> currentYearOrderList = ordersByYear.get(currentOrderYear);
            currentYearOrderList.add(currentOrder);
            ordersByYear.put(currentOrderYear, currentYearOrderList);
        }
        for (Map.Entry<String, List<Order>> currentEntry : ordersByProvince.entrySet()) {
            orderAmountsByProvince.put(currentEntry.getKey(), currentEntry.getValue().size());
        }
    }

    public void populateOrders() {

        RecyclerView provinceRecyclerView = findViewById(R.id.rv_province_list);
        provinceRecyclerView.setHasFixedSize(true);
        // use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        provinceRecyclerView.setLayoutManager(mLayoutManager);
        // specify an adapter (see also next example)
        ProvincesAdapter provincesAdapter = new ProvincesAdapter(orderAmountsByProvince);
        provinceRecyclerView.setAdapter(provincesAdapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(provinceRecyclerView.getContext(),
                mLayoutManager.getOrientation());
        provinceRecyclerView.addItemDecoration(dividerItemDecoration);

        int count = ordersByYear.get(ORDER_YEAR).size();
        Resources res = getResources();
        String ordersFoundText = res.getQuantityString(R.plurals.orders_by_year_found, count, count, ORDER_YEAR);

        mTotalOrdersByYear.setText(ordersFoundText);

        RecyclerView ordersRecyclerView = findViewById(R.id.rv_orders_year);
        ordersRecyclerView.setHasFixedSize(true);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        ordersRecyclerView.setLayoutManager(mLayoutManager);
        // specify an adapter (see also next example)
        OrderAdapter orderAdapter = new OrderAdapter(getSelectedYearList());
        ordersRecyclerView.setAdapter(orderAdapter);
    }

    public List<Order> getSelectedYearList() {
        List<Order> selectedYearOrders = new ArrayList<>();
        for (Order currentOrder : orderList) {
            if (Integer.parseInt(currentOrder.getCreatedAt().substring(0, currentOrder.getCreatedAt().indexOf("-"))) == ORDER_YEAR) {
                selectedYearOrders.add(currentOrder);
            }
        }
        return selectedYearOrders;
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
