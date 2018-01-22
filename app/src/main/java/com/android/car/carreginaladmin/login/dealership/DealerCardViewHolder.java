package com.android.car.carreginaladmin.login.dealership;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.car.carreginaladmin.R;

/**
 * Created by keerthini on 21/01/18.
 */

public class DealerCardViewHolder extends RecyclerView.ViewHolder{
        private static TextView textViewDealerNo,textViewDealerName;
        private static ImageView imageViewSkill;

        public DealerCardViewHolder(final View parent) {
            super(parent);
        }

        public static DealerCardViewHolder newInstance(View parent) {
            textViewDealerNo = (TextView) parent.findViewById(R.id.textview_dealerno);
            textViewDealerName=(TextView)parent.findViewById(R.id.textView_dealerName);
            imageViewSkill=(ImageView)parent.findViewById(R.id.imgView_skill);
            return new DealerCardViewHolder(parent);
        }

        public void setItemText(CharSequence text) {
            textViewDealerNo.setText(text);
        }
    public void setItemTextDealerName(CharSequence text) {
        textViewDealerName.setText(text);
    }

    }

