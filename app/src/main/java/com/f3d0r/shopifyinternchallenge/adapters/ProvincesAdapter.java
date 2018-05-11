package com.f3d0r.shopifyinternchallenge.adapters;

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

public class ProvincesAdapter extends RecyclerView.Adapter<ProvincesAdapter.ViewHolder> {
    private Map<String, Integer> ordersByProvince;
    private List<String> provinces;

    private Context context;

    // Provide a suitable constructor (depends on the kind of dataset)
    public ProvincesAdapter(Map<String, Integer> ordersByProvince) {
        this.ordersByProvince = ordersByProvince;
        provinces = new ArrayList<>(ordersByProvince.keySet());
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public ProvincesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                                          int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_order_by_province, parent, false);

        context = parent.getContext();
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Resources resources = context.getResources();
        holder.mProvinceSummary.setText(resources.getQuantityString(R.plurals.orders_by_province, ordersByProvince.get(provinces.get(position)), ordersByProvince.get(provinces.get(position)), provinces.get(position)));
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return provinces.size();
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        private TextView mProvinceSummary;

        private ViewHolder(View itemView) {
            super(itemView);
            mProvinceSummary = itemView.findViewById(R.id.order_summary);
        }
    }
}