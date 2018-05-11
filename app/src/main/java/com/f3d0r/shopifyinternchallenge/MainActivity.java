package com.f3d0r.shopifyinternchallenge;

/*
  MainActivity displays two RecyclerViews containing order amounts organized by province of origin
  and order information from all order in a selected year (see class constant). This class also requests the
  Retrofit API and retrieves all of the order information that is used in all of the activities in this app.

  @author Fedor Paretsky
 */

import android.content.Intent;
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
import com.f3d0r.shopifyinternchallenge.adapters.OrdersByProvinceAdapter;
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

public class MainActivity extends AppCompatActivity {

    //access token for Shopify API
    public static final String ACCESS_TOKEN = "c32313df0d0ef512ca64d5b336a0d7c6";
    //Shopify API base URL (for use with Retrofit)
    public static final String SHOPIFY_BASE_URL = "https://shopicruit.myshopify.com/";
    //the page number that is used for the Shopify API orders request
    public static final int PAGE = 1;
    //the year selected to show orders from in bottom RecyclerView of MainActivity
    public static final int ORDER_YEAR = 2016;

    private ShopifyClient shopifyService;

    private List<Order> orderList;
    private Map<String, List<Order>> ordersByProvince;
    private Map<Integer, List<Order>> ordersByYear;
    private Map<String, Integer> orderAmountsByProvince;

    private ProgressBar progressBar;
    private LinearLayout container;
    private TextView mTotalOrdersByYear;
    private TextView mOrdersByProvince;

    private LinearLayoutManager provinceLayoutManager;
    private LinearLayoutManager ordersLayoutManager;
    private RecyclerView provinceRecyclerView;
    private RecyclerView ordersRecyclerView;
    private OrdersByProvinceAdapter ordersByProvinceAdapter;
    private OrderAdapter orderAdapter;

    /**
     * onCreate() initializes the UI components, Retrofit instance, displays a progress circle/disables UI,
     * and calls the getOrders() method to start loading and processing of the orders data received from
     * the Shopify API.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize view components
        progressBar = findViewById(R.id.progressBar);
        container = findViewById(R.id.main_activity_container);
        mTotalOrdersByYear = findViewById(R.id.tv_total_orders_by_year);
        mOrdersByProvince = findViewById(R.id.tv_orders_by_province);

        //initialize and set RecyclerView settings
        provinceRecyclerView = findViewById(R.id.rv_province_list);
        provinceRecyclerView.setHasFixedSize(true);
        ordersRecyclerView = findViewById(R.id.rv_orders_year);
        ordersRecyclerView.setHasFixedSize(true);

        //initialize LayoutManagers and attach them to RecyclerView
        provinceLayoutManager = new LinearLayoutManager(this);
        provinceRecyclerView.setLayoutManager(provinceLayoutManager);
        ordersLayoutManager = new LinearLayoutManager(this);
        ordersRecyclerView.setLayoutManager(ordersLayoutManager);

        //display progress bar while loading data from Shopify API
        viewLoading(true);

        //Retrofit API is initialized
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(SHOPIFY_BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        //Retrofit service is initialized based on interface heuristic
        shopifyService = retrofit.create(ShopifyClient.class);

        //Intent to go to OrderListActivity if the top (small) header ("Orders by Province" text) is pressed
        mOrdersByProvince.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OrderListActivity.class);
                intent.putExtra("ordersByProvince", (Serializable) ordersByProvince); //Optional parameters
                startActivity(intent);
            }
        });

        //loading and processing of data from Shopify API begins
        getOrders();
    }

    /**
     * onCreateOptionsMenu() attaches the menu xml to the AppBar displayed in the MainActivity
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.app_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * onOptionsItemSelected() is called only when the refresh button in the AppBar is pressed (since there
     * is only one button that invokes this method). When the refresh button is pressed, the refresh() method
     * is called.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.refresh_button) {
            refresh();
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * getOrders() performs a Retrofit API call and retrieves data asynchronously while displaying a progress
     * bar on the front-end. It then calls the organizeOrders() and populateOrders() methods to proceed to process
     * and display the data after it is downloaded.
     */
    public void getOrders() {
        Call<OrderList> getOrdersCall = shopifyService.getOrders(PAGE, ACCESS_TOKEN);
        getOrdersCall.enqueue(new Callback<OrderList>() {
            @Override
            public void onResponse(@NonNull Call<OrderList> call, @NonNull Response<OrderList> response) {
                orderList = Objects.requireNonNull(response.body()).getOrders();
                organizeOrders();
                populateOrders();
                viewLoading(false);
            }

            @Override
            public void onFailure(@NonNull Call<OrderList> call, @NonNull Throwable t) {
                viewLoading(false);
            }
        });
    }

    /**
     * organizeOrders() organizes the downloaded data by province and by year to display in the two RecyclerViews
     */
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

    /**
     * populateOrders() creates adapters for the RecyclerViews, initializes the data to display on the front-end,
     * and updates the text view in the second part of the screen to show the orders from the selected year (see
     * class constant).
     */
    public void populateOrders() {
        ordersByProvinceAdapter = new OrdersByProvinceAdapter(orderAmountsByProvince);
        provinceRecyclerView.setAdapter(ordersByProvinceAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(provinceRecyclerView.getContext(),
                provinceLayoutManager.getOrientation());
        provinceRecyclerView.addItemDecoration(dividerItemDecoration);

        int count = ordersByYear.get(ORDER_YEAR).size();
        mTotalOrdersByYear.setText(getResources().getQuantityString(R.plurals.orders_by_year, count, count, ORDER_YEAR));

        orderAdapter = new OrderAdapter(getSelectedYearList());
        ordersRecyclerView.setAdapter(orderAdapter);
    }

    /**
     * getSelectedYearList() returns an ArrayList of orders that are only from the selected year (see class constant)
     *
     * @return ArrayList of orders from the selected year (see class constant)
     */
    public List<Order> getSelectedYearList() {
        List<Order> selectedYearOrders = new ArrayList<>();
        for (Order currentOrder : orderList) {
            if (Integer.parseInt(currentOrder.getCreatedAt().substring(0, currentOrder.getCreatedAt().indexOf("-"))) == ORDER_YEAR) {
                selectedYearOrders.add(currentOrder);
            }
        }
        return selectedYearOrders;
    }

    /**
     * viewLoading(loading) disables the components of the screen if loading is true,
     * otherwise it enables the front-end views
     *
     * @param (loading) true if the views of the screen should be disabled while data is being
     *                  downloaded/processed, enables components if
     */
    public void viewLoading(boolean loading) {
        if (loading) {
            progressBar.setVisibility(View.VISIBLE);
            container.setVisibility(View.GONE);
        } else {
            progressBar.setVisibility(View.GONE);
            container.setVisibility(View.VISIBLE);
        }
    }

    /**
     * refresh() removes the data from both RecyclerViews in MainActivity, disables the UI during loading,
     * and calls the getOrders() method to start downloading/processing of the data from the Shopify API
     * over again.
     */
    public void refresh() {
        viewLoading(true);
        provinceRecyclerView.removeAllViews();
        ordersRecyclerView.removeAllViews();
        ordersByProvinceAdapter.notifyDataSetChanged();
        orderAdapter.notifyDataSetChanged();
        getOrders();
    }
}
