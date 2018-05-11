package com.f3d0r.shopifyinternchallenge.adapters;

/*
  RecyclerView Adapter for RecyclerView containing the amount of orders from each province.

  @author Fedor Paretsky
 */

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.f3d0r.shopifyinternchallenge.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrdersByProvinceAdapter extends RecyclerView.Adapter<OrdersByProvinceAdapter.ViewHolder> {
    private Map<String, Integer> ordersByProvince;
    private List<String> provinces;

    private Context context;

    public OrdersByProvinceAdapter(Map<String, Integer> ordersByProvince) {
        this.ordersByProvince = ordersByProvince;
        provinces = new ArrayList<>(ordersByProvince.keySet());
    }

    @NonNull
    @Override
    public OrdersByProvinceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                                                 int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_orders_by_province, parent, false);

        context = parent.getContext();
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Resources resources = context.getResources();
        holder.mProvinceSummary.setText(resources.getQuantityString(R.plurals.orders_by_province, ordersByProvince.get(provinces.get(position)), ordersByProvince.get(provinces.get(position)), provinces.get(position)));
    }

    @Override
    public int getItemCount() {
        return provinces.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mProvinceSummary;

        private ViewHolder(View itemView) {
            super(itemView);
            mProvinceSummary = itemView.findViewById(R.id.order_summary);
        }
    }
}