package com.f3d0r.shopifyinternchallenge.view_holders;

import android.content.Context;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.f3d0r.shopifyinternchallenge.GlideApp;
import com.f3d0r.shopifyinternchallenge.R;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import static android.view.animation.Animation.RELATIVE_TO_SELF;

public class StateViewHolder extends GroupViewHolder {

    private TextView mStateName;
    private ImageView mExpandArrowIcon;
    private ImageView mStateSeal;

    private Context context;

    public StateViewHolder(View itemView) {
        super(itemView);
        mStateName = itemView.findViewById(R.id.list_item_state_name);
        mExpandArrowIcon = itemView.findViewById(R.id.list_item_expand_arrow);
        mStateSeal = itemView.findViewById(R.id.list_item_state_seal);
        context = itemView.getContext();
    }

    public void setStateTitle(ExpandableGroup state) {
        mStateName.setText(state.getTitle());
        GlideApp
                .with(context)
                .load(getURLPath(state.getTitle().toLowerCase()))
                .placeholder(R.drawable.loading_spinner)
                .into(mStateSeal);
    }

    @Override
    public void expand() {
        animateExpand();
    }

    @Override
    public void collapse() {
        animateCollapse();
    }

    private void animateExpand() {
        RotateAnimation rotate =
                new RotateAnimation(360, 180, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(300);
        rotate.setFillAfter(true);
        mExpandArrowIcon.setAnimation(rotate);
    }

    private void animateCollapse() {
        RotateAnimation rotate =
                new RotateAnimation(180, 360, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(300);
        rotate.setFillAfter(true);
        mExpandArrowIcon.setAnimation(rotate);
    }

    private String getURLPath(String state) {
        if (state.equals("no address")) {
            return "http://www.clker.com/cliparts/u/Q/3/W/K/7/no-circle-do-not-circle-md.png";
        }
        return "https://raw.githubusercontent.com/CivilServiceUSA/us-states/master/images/seals/" + state + "-large.png";
    }
}
