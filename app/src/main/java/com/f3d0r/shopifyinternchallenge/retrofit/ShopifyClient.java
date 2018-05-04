package com.f3d0r.shopifyinternchallenge.retrofit;

import com.f3d0r.shopifyinternchallenge.jackson_models.OrderList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ShopifyClient {
    @GET("admin/orders.json")
    Call<OrderList> getOrders(@Query("page") int page, @Query("access_token") String accessToken);

}
