package com.android.car.carreginaladmin.login.jobrole;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.car.carreginaladmin.R;
import com.android.car.carreginaladmin.login.pojo.JobRoleModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by keerthini on 22/01/18.
 */

public class JobRecyclerAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<JobRoleModel> mItemList;

    public JobRecyclerAdapter(List<JobRoleModel> itemList) {
        mItemList = itemList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_jobrole, parent, false);
        return JobCardViewHolder.newInstance(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        JobCardViewHolder holder = (JobCardViewHolder) viewHolder;
        String itemTextJobRole = mItemList.get(position).jobRole;
        holder.setItemJobRole(itemTextJobRole);
        int itemTextTarget = mItemList.get(position).target;
        holder.setItemTextTarget(itemTextTarget);
        int itemTextAchieved = mItemList.get(position).achieved;
        holder.setItemTextAchieved(itemTextAchieved);
    }

    @Override
    public int getItemCount() {
        return mItemList == null ? 0 : mItemList.size();
    }

}

