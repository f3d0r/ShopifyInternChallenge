package com.f3d0r.shopifyinternchallenge.view_holders;

import android.view.View;
import android.widget.TextView;

import com.f3d0r.shopifyinternchallenge.R;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

public class SubstateOrderViewHolder extends ChildViewHolder {

    private TextView mOrderNumber;
    private TextView mTotalPrice;
    private TextView mCustomerName;
    private TextView mNumberItems;
    private TextView mShippingLocation;
    private TextView mOrderTime;

    public SubstateOrderViewHolder(View itemView) {
        super(itemView);
        mOrderNumber = itemView.findViewById(R.id.tv_order_number);
        mTotalPrice = itemView.findViewById(R.id.tv_total_price);
        mCustomerName = itemView.findViewById(R.id.tv_customer_name);
        mNumberItems = itemView.findViewById(R.id.tv_number_items);
        mShippingLocation = itemView.findViewById(R.id.tv_shipping_location);
        mOrderTime = itemView.findViewById(R.id.tv_order_time);
    }

    public void setOrderNumber(String orderNumber) {
        mOrderNumber.setText(orderNumber);
    }

    public void setTotalPrice(String totalPrice) {
        mTotalPrice.setText(totalPrice);
    }

    public void setCustomerName(String customerName) {
        mCustomerName.setText(customerName);
    }

    public void setNumberItems(String numberItems) {
        mNumberItems.setText(numberItems);
    }

    public void setShippingLocation(String shippingLocation) {
        mShippingLocation.setText(shippingLocation);
    }

    public void setOrderTime(String orderTime) {
        mOrderTime.setText(orderTime);
    }
}
