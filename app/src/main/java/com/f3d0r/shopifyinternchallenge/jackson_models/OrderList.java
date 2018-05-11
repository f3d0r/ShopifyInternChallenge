package com.f3d0r.shopifyinternchallenge.jackson_models;

/*
  Generated JSON conversion/de-serialization object for use with Retrofit.

  @author Fedor Paretsky
 */

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class OrderList {

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