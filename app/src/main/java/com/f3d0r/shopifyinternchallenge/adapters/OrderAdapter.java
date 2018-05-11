package com.f3d0r.shopifyinternchallenge.adapters;

/*
  RecyclerView Adapter for RecyclerView containing list of orders and each order's respective information summary.

  @author Fedor Paretsky
 */

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.f3d0r.shopifyinternchallenge.R;
import com.f3d0r.shopifyinternchallenge.jackson_models.Order;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {
    private List<Order> orderList;
    private Context context;

    public OrderAdapter(List<Order> orderList) {
        this.orderList = orderList;
    }

    @NonNull
    @Override
    public OrderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                                      int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_order, parent, false);
        context = parent.getContext();
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mOrderNumber.setText(context.getResources().getString(R.string.order_number, orderList.get(position).getOrderNumber()));
        holder.mTotalPrice.setText(context.getResources().getString(R.string.total_price, orderList.get(position).getTotalPrice()));

        String customerName = "No customer name";
        if (orderList.get(position).getCustomer() != null) {
            customerName = context.getResources().getString(R.string.customer_name, orderList.get(position).getCustomer().getFirstName(), orderList.get(position).getCustomer().getLastName());
        }
        holder.mCustomerName.setText(customerName);

        holder.mNumberItems.setText(context.getResources().getString(R.string.total_items, orderList.get(position).getLineItems().size()));

        String shippingText = context.getResources().getString(R.string.shipping_location, "N/A", "");
        if (orderList.get(position).getShippingAddress() != null) {
            shippingText = context.getResources().getString(R.string.shipping_location, orderList.get(position).getShippingAddress().getCity(), orderList.get(position).getShippingAddress().getProvinceCode());
        }
        holder.mShippingLocation.setText(shippingText);

        holder.mOrderTime.setText(context.getResources().getString(R.string.order_time, fromISO8601UTC(orderList.get(position).getCreatedAt())));
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    private String fromISO8601UTC(String dateStr) {
        return dateStr.substring(0, dateStr.indexOf('T')) + ", " + dateStr.substring(dateStr.indexOf('T') + 1, dateStr.lastIndexOf('-'));
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mOrderNumber;
        private TextView mTotalPrice;
        private TextView mCustomerName;
        private TextView mNumberItems;
        private TextView mShippingLocation;
        private TextView mOrderTime;

        private ViewHolder(View itemView) {
            super(itemView);
            mOrderNumber = itemView.findViewById(R.id.tv_order_number);
            mTotalPrice = itemView.findViewById(R.id.tv_total_price);
            mCustomerName = itemView.findViewById(R.id.tv_customer_name);
            mNumberItems = itemView.findViewById(R.id.tv_number_items);
            mShippingLocation = itemView.findViewById(R.id.tv_shipping_location);
            mOrderTime = itemView.findViewById(R.id.tv_order_time);
        }
    }
}