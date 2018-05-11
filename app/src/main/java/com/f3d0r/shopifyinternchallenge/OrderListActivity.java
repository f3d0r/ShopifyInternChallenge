package com.f3d0r.shopifyinternchallenge;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.f3d0r.shopifyinternchallenge.adapters.StateAdapter;
import com.f3d0r.shopifyinternchallenge.jackson_models.Order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class OrderListActivity extends AppCompatActivity {

    final List<State> categorizedOrders = new ArrayList<>();
    public StateAdapter adapter;
    private Map<String, List<Order>> ordersByProvince;
    private Map<String, Bitmap> stateImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);
        Intent intent = getIntent();
        ordersByProvince = (Map<String, List<Order>>) intent.getSerializableExtra("ordersByProvince");

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        RecyclerView recyclerView = findViewById(R.id.rv_full_order_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        RecyclerView.ItemAnimator animator = recyclerView.getItemAnimator();
        if (animator instanceof DefaultItemAnimator) {
            ((DefaultItemAnimator) animator).setSupportsChangeAnimations(false);
        }

        setupOrders();
        Collections.sort(categorizedOrders);

        adapter = new StateAdapter(categorizedOrders);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    public void setupOrders() {
        for (final Map.Entry<String, List<Order>> currentEntry : ordersByProvince.entrySet()) {
            final List<SubstateOrder> currentOrderList = new ArrayList<>();
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
                currentOrderList.add(new SubstateOrder(orderNumber, totalPrice, customerName, numberItems, shippingText, orderTime));
            }

            categorizedOrders.add(new State(currentEntry.getKey(), currentOrderList));
        }
    }

    private String fromISO8601UTC(String dateStr) {
        return dateStr.substring(0, dateStr.indexOf('T')) + ", " + dateStr.substring(dateStr.indexOf('T') + 1, dateStr.lastIndexOf('-'));
    }
}
