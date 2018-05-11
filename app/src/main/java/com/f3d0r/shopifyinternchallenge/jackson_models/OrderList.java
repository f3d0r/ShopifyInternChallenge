package com.f3d0r.shopifyinternchallenge.jackson_models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class OrderList {

    @JsonProperty("orders")
    private List<Order> orders;

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Order> getOrders() {
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