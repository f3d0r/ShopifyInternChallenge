package com.f3d0r.shopifyinternchallenge;

/*
  OrderListActivity displays a RecyclerViews containing order information categorized by province, displayed
  in an expandable RecyclerView. This class retrieves the data downloaded from the MainActivity, so it doesn't
  have refresh functionality, and does it's own processing of data to display it as a sorted list.

  @author Fedor Paretsky
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.f3d0r.shopifyinternchallenge.adapters.ProvinceAdapter;
import com.f3d0r.shopifyinternchallenge.expandable_view_objects.Province;
import com.f3d0r.shopifyinternchallenge.expandable_view_objects.SubProvinceOrder;
import com.f3d0r.shopifyinternchallenge.jackson_models.Order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class OrderListActivity extends AppCompatActivity {

    //a list Provinces containing each Province title and the respective orders from those provinces
    //(for use with the RecyclerView adapter)
    final List<Province> categorizedOrders = new ArrayList<>();
    //the RecyclerView adapter to be used with the expandable RecyclerView
    public ProvinceAdapter adapter;
    //a map of provinces and each province's respective orders, retrieved from the MainActivity (to be
    //processed to turn into a valid form for the expandable RecycleView adapter)
    private Map<String, List<Order>> ordersByProvince;

    /**
     * onCreate() initializes the UI components, retrieves a map of provinces and each province's respective
     * orders from the MainActivity, sets up the RecycleView, calls the setupOrders() to process the retrieved
     * map of data into a valid form for the expandable RecycleView adapter, and then initializes the RecycleView
     * with that data.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);

        Intent intent = getIntent();
        ordersByProvince = (Map<String, List<Order>>) intent.getSerializableExtra("ordersByProvince");

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        RecyclerView orderRecyclerViewer = findViewById(R.id.rv_full_order_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        RecyclerView.ItemAnimator animator = orderRecyclerViewer.getItemAnimator();
        if (animator instanceof DefaultItemAnimator) {
            ((DefaultItemAnimator) animator).setSupportsChangeAnimations(false);
        }

        setupOrders();
        Collections.sort(categorizedOrders);

        adapter = new ProvinceAdapter(categorizedOrders);
        orderRecyclerViewer.setLayoutManager(layoutManager);
        orderRecyclerViewer.setAdapter(adapter);
    }

    /**
     * onSaveInstanceState() - default method behavior
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    /**
     * onRestoreInstanceState() - default method behavior
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    /**
     * onSupportNavigateUp() - default method behavior
     */
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    /**
     * setupOrders() creates a List of Province objects, with each Province object containing a list of the
     * respective orders from that province. The conversion of raw data into natural language also takes place
     * here.
     */
    public void setupOrders() {
        for (final Map.Entry<String, List<Order>> currentEntry : ordersByProvince.entrySet()) {
            final List<SubProvinceOrder> currentOrderList = new ArrayList<>();
            for (Order currentOrder : currentEntry.getValue()) {
                String orderNumber = this.getResources().getString(R.string.order_number, currentOrder.getOrderNumber());
                String totalPrice = this.getResources().getString(R.string.total_price, currentOrder.getTotalPrice());
                String customerName = "No customer name";
                if (currentOrder.getCustomer() != null) {
                    customerName = this.getResources().getString(R.string.customer_name, currentOrder.getCustomer().getFirstName(), currentOrder.getCustomer().getLastName());
                }
                String numberItems = this.getResources().getString(R.string.total_items, currentOrder.getLineItems().size());
                String shippingText = this.getResources().getString(R.string.shipping_location, "N/A", "");
                if (currentOrder.getShippingAddress() != null) {
                    shippingText = this.getResources().getString(R.string.shipping_location, currentOrder.getShippingAddress().getCity(), currentOrder.getShippingAddress().getProvinceCode());
                }
                String orderTime = this.getResources().getString(R.string.order_time, fromISO8601UTC(currentOrder.getCreatedAt()));
                currentOrderList.add(new SubProvinceOrder(orderNumber, totalPrice, customerName, numberItems, shippingText, orderTime));
            }

            categorizedOrders.add(new Province(currentEntry.getKey(), currentOrderList));
        }
    }

    /**
     * fromISO8601UTC() accepts an ISO8601UTC String for time and returns a human-readable format of time from
     * that String by data-parsing.
     *
     * @param (dateStr) an ISO8601UTC String for time
     * @return returns a human-readable date String to display
     */
    private String fromISO8601UTC(String dateStr) {
        return dateStr.substring(0, dateStr.indexOf('T')) + ", " + dateStr.substring(dateStr.indexOf('T') + 1, dateStr.lastIndexOf('-'));
    }
}
