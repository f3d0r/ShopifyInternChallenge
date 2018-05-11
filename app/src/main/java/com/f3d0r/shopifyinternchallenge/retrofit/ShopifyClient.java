package com.f3d0r.shopifyinternchallenge.retrofit;

/*
  Retrofit interface containing all endpoints/requests and response objects to be used with Shopify Orders API

  @author Fedor Paretsky
 */

import com.f3d0r.shopifyinternchallenge.jackson_models.OrderList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ShopifyClient {
    // request to Shopify API for all orders
    @GET("admin/orders.json")
    Call<OrderList> getOrders(@Query("page") int page, @Query("access_token") String accessToken);

}
