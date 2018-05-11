package com.f3d0r.shopifyinternchallenge;

import android.support.annotation.NonNull;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class State extends ExpandableGroup<SubstateOrder> implements Comparable<State> {

    State(String title, List<SubstateOrder> items) {
        super(title, items);
    }

    @Override
    public int compareTo(@NonNull State o) {
        return this.getTitle().compareTo(o.getTitle());
    }
}