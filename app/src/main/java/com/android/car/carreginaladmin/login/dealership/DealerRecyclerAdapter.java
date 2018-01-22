package com.android.car.carreginaladmin.login.dealership;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.car.carreginaladmin.R;
import com.android.car.carreginaladmin.login.DealerListActivity;
import com.android.car.carreginaladmin.login.pojo.DealerListModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by keerthini on 21/01/18.
 */

public class DealerRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<DealerListModel> mItemList;
    private ArrayList<DealerListModel> dealerArrayList;

    public DealerRecyclerAdapter(List<DealerListModel> itemList) {
        mItemList = itemList;
        dealerArrayList = new ArrayList<>();
        dealerArrayList.addAll(DealerListActivity.metGuideLines);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dealer_cardview, parent, false);
        return DealerCardViewHolder.newInstance(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        DealerCardViewHolder holder = (DealerCardViewHolder) viewHolder;
        String itemText = mItemList.get(position).dealerNumber;
        holder.setItemText(itemText);
        String itemTextDealerName = mItemList.get(position).dealerNames;
        holder.setItemTextDealerName(itemTextDealerName);
    }

    @Override
    public int getItemCount() {
        return mItemList == null ? 0 : mItemList.size();
    }

    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        DealerListActivity.metGuideLines.clear();
        if (charText.length() == 0) {
            DealerListActivity.metGuideLines.addAll(mItemList);
        } else {
            for (DealerListModel wp : dealerArrayList) {
                if (wp.getDealerNames().contains(charText)) {
                    DealerListActivity.metGuideLines.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }

}

