package com.f3d0r.shopifyinternchallenge.jackson_models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderList {

    @JsonProperty("orders")
    private List<OrdersItem> orders;

    public void setOrders(List<OrdersItem> orders) {
        this.orders = orders;
    }

    public List<OrdersItem> getOrders() {
        return orders;
    }

    @Override
    public String toString() {
        return
                "OrderList{" +
                        "orders = '" + orders + '\'' +
                        "}";
    }
}