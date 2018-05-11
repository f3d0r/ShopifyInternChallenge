package com.f3d0r.shopifyinternchallenge.expandable_view_objects;

/*
  Province object containing list of orders from that province to be used with expanded RecyclerView adapter.

  @author Fedor Paretsky
 */

import android.support.annotation.NonNull;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class Province extends ExpandableGroup<SubProvinceOrder> implements Comparable<Province> {

    public Province(String title, List<SubProvinceOrder> items) {
        super(title, items);
    }

    @Override
    public int compareTo(@NonNull Province o) {
        return this.getTitle().compareTo(o.getTitle());
    }
}