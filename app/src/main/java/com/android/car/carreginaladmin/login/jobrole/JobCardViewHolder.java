package com.android.car.carreginaladmin.login.jobrole;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.car.carreginaladmin.R;
import com.android.car.carreginaladmin.login.ImageDecoding;

/**
 * Created by keerthini on 22/01/18.
 */

public class JobCardViewHolder extends RecyclerView.ViewHolder{
    private static TextView textViewJobRole,textViewTarget,textViewAchieved;
    private static ImageView imageViewSkill;

    public JobCardViewHolder(final View parent) {
        super(parent);
    }

    public static JobCardViewHolder newInstance(View parent) {
        textViewJobRole = (TextView) parent.findViewById(R.id.textview_jobRole);
        textViewTarget=(TextView)parent.findViewById(R.id.textView_target);
        textViewAchieved=(TextView)parent.findViewById(R.id.textView_achieved);
        imageViewSkill=(ImageView)parent.findViewById(R.id.imgView_status);
        return new JobCardViewHolder(parent);
    }

    public void setItemJobRole(CharSequence text) {
        textViewJobRole.setText(text);
    }
    public void setItemTextTarget(int text) {
        textViewTarget.setText(String.valueOf(text));
    }
    public void setItemTextAchieved(int text) {
        textViewAchieved.setText(String.valueOf(text));
    }


}


