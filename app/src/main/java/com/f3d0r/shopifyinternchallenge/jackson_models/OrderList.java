package com.f3d0r.shopifyinternchallenge.jackson_models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class OrderList implements Serializable {

    @JsonProperty("orders")
    private List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return
                "OrderList{" +
                        "orders = '" + orders + '\'' +
                        "}";
    }
}