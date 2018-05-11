package com.f3d0r.shopifyinternchallenge.adapters;

/*
  RecyclerView Adapter that is parent to expandable RecyclerView containing orders categorized under
  this RecyclerViews parent views.

  @author Fedor Paretsky
 */

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.f3d0r.shopifyinternchallenge.R;
import com.f3d0r.shopifyinternchallenge.expandable_view_holders.ProvinceViewHolder;
import com.f3d0r.shopifyinternchallenge.expandable_view_holders.SubProvinceOrderViewHolder;
import com.f3d0r.shopifyinternchallenge.expandable_view_objects.Province;
import com.f3d0r.shopifyinternchallenge.expandable_view_objects.SubProvinceOrder;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class ProvinceAdapter extends ExpandableRecyclerViewAdapter<ProvinceViewHolder, SubProvinceOrderViewHolder> {

    public ProvinceAdapter(List<? extends ExpandableGroup> groups) {
        super(groups);
    }

    @Override
    public ProvinceViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_state, parent, false);
        return new ProvinceViewHolder(view);
    }

    @Override
    public SubProvinceOrderViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_order, parent, false);
        return new SubProvinceOrderViewHolder(view);
    }

    @Override
    public void onBindChildViewHolder(SubProvinceOrderViewHolder holder, int flatPosition,
                                      ExpandableGroup group, int childIndex) {

        final SubProvinceOrder currentOrder = ((Province) group).getItems().get(childIndex);
        holder.setOrderNumber(currentOrder.getOrderNumber());
        holder.setTotalPrice(currentOrder.getTotalPrice());
        holder.setCustomerName(currentOrder.getCustomerName());
        holder.setNumberItems(currentOrder.getNumberItems());
        holder.setShippingLocation(currentOrder.getShippingLocation());
        holder.setOrderTime(currentOrder.getOrderTime());
    }

    @Override
    public void onBindGroupViewHolder(ProvinceViewHolder holder, int flatPosition,
                                      ExpandableGroup group) {
        holder.setStateTitle(group);
    }
}
