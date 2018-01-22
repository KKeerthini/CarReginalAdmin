package com.android.car.carreginaladmin.login.jobrole;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import com.android.car.carreginaladmin.R;
import com.android.car.carreginaladmin.login.pojo.JobRoleModel;

import java.util.ArrayList;

/**
 * Created by keerthini on 22/01/18.
 */



public class JobRoleActivity extends AppCompatActivity {
    private Context context;
    private int guidelineType;
    SearchView searchView;
    JobRecyclerAdapter cardAdapterAdapter;
    public static ArrayList<JobRoleModel> metGuideLines;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dealer_list);
        context = getApplicationContext();
        searchView=(SearchView)findViewById(R.id.search);
        searchView.setVisibility(View.GONE);
        guidelineType = getIntent().getIntExtra("type", 0);

            metGuideLines = new ArrayList<>();
            metGuideLines.clear();
            JobRoleModel dealerListModel = new JobRoleModel();
            dealerListModel.setStatus("act");
            dealerListModel.setJobRole("Sales Manager");
            dealerListModel.setTarget(28);
            dealerListModel.setAchieved(28);
            metGuideLines.add(dealerListModel);

        JobRoleModel dealerListModel2 = new JobRoleModel();
        dealerListModel2.setStatus("act");
        dealerListModel2.setJobRole("Sales Consultant");
        dealerListModel2.setTarget(18);
        dealerListModel2.setAchieved(20);
        metGuideLines.add(dealerListModel2);

        JobRoleModel dealerListModel3 = new JobRoleModel();
        dealerListModel3.setStatus("act");
        dealerListModel3.setJobRole("Body Shop Manager");
        dealerListModel3.setTarget(15);
        dealerListModel3.setAchieved(16);
        metGuideLines.add(dealerListModel3);

        JobRoleModel dealerListModel4 = new JobRoleModel();
        dealerListModel4.setStatus("act");
        dealerListModel4.setJobRole("Parts Manager");
        dealerListModel4.setTarget(12);
        dealerListModel4.setAchieved(15);
        metGuideLines.add(dealerListModel4);




        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(context);
        cardAdapterAdapter = new JobRecyclerAdapter(metGuideLines);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.dealer_recyclerview);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(cardAdapterAdapter);


    }


    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }

}



