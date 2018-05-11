package com.f3d0r.shopifyinternchallenge.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.f3d0r.shopifyinternchallenge.R;
import com.f3d0r.shopifyinternchallenge.State;
import com.f3d0r.shopifyinternchallenge.SubstateOrder;
import com.f3d0r.shopifyinternchallenge.view_holders.StateViewHolder;
import com.f3d0r.shopifyinternchallenge.view_holders.SubstateOrderViewHolder;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class StateAdapter extends ExpandableRecyclerViewAdapter<StateViewHolder, SubstateOrderViewHolder> {

    public StateAdapter(List<? extends ExpandableGroup> groups) {
        super(groups);
    }

    @Override
    public StateViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_state_category, parent, false);
        return new StateViewHolder(view);
    }

    @Override
    public SubstateOrderViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_order, parent, false);
        return new SubstateOrderViewHolder(view);
    }

    @Override
    public void onBindChildViewHolder(SubstateOrderViewHolder holder, int flatPosition,
                                      ExpandableGroup group, int childIndex) {

        final SubstateOrder currentOrder = ((State) group).getItems().get(childIndex);
        holder.setOrderNumber(currentOrder.getOrderNumber());
        holder.setTotalPrice(currentOrder.getTotalPrice());
        holder.setCustomerName(currentOrder.getCustomerName());
        holder.setNumberItems(currentOrder.getNumberItems());
        holder.setShippingLocation(currentOrder.getShippingLocation());
        holder.setOrderTime(currentOrder.getOrderTime());
    }

    @Override
    public void onBindGroupViewHolder(StateViewHolder holder, int flatPosition,
                                      ExpandableGroup group) {
        holder.setStateTitle(group);
    }
}
