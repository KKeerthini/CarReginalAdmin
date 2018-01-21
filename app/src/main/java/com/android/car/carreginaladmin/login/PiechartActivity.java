package com.android.car.carreginaladmin.login;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.android.car.carreginaladmin.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.Highlight;
import com.github.mikephil.charting.utils.PercentFormatter;

import java.util.ArrayList;

/**
 * Created by keerthini on 21/01/18.
 */

public class PiechartActivity extends AppCompatActivity implements OnChartValueSelectedListener {

    public static final int[] CUSTOM_COLORS = {
            Color.rgb(255, 140, 0), Color.rgb(250, 250, 240), Color.rgb(0, 255, 10)};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piechart);
        PieChart pieChart = (PieChart) findViewById(R.id.chart);
        pieChart.setUsePercentValues(true);

        // IMPORTANT: In a PieChart, no values (Entry) should have the same
        // xIndex (even if from different DataSets), since no values can be
        // drawn above each other.
        ArrayList<Entry> yvalues = new ArrayList<Entry>();
        yvalues.add(new Entry(52f, 0));
        yvalues.add(new Entry(36f, 1));
        yvalues.add(new Entry(12f, 2));


        PieDataSet dataSet = new PieDataSet(yvalues, "");

        ArrayList<String> xVals = new ArrayList<String>();

        xVals.add("Met Guidelines");
        xVals.add("Partially Met Guidelines");
        xVals.add("Not Meeting Guidelines");


        PieData data = new PieData(xVals, dataSet);
        // In Percentage term
        data.setValueFormatter(new PercentFormatter());
        // Default value
        //data.setValueFormatter(new DefaultValueFormatter(0));
        pieChart.setData(data);
        pieChart.setDescription("Toyota Dealership");
        pieChart.setTransparentCircleRadius(0f);
        pieChart.setHoleRadius(0f);

        dataSet.setColors(CUSTOM_COLORS);
        data.setValueTextSize(13f);
        data.setValueTextColor(Color.DKGRAY);
        pieChart.setOnChartValueSelectedListener(this);

        pieChart.animateXY(1400, 1400);

    }

    @Override
    public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {

        if (e == null)
            return;
        Log.i("VAL SELECTED",
                "Value: " + e.getVal() + ", xIndex: " + e.getXIndex()
                        + ", DataSet index: " + dataSetIndex);
        Intent intent=new Intent(PiechartActivity.this,DealerListActivity.class);
        intent.putExtra("type",e.getXIndex());
        startActivity(intent);
        /*DealerListFragment fragment = new DealerListFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.container, fragment);
        transaction.commit();*/

    }

    @Override
    public void onNothingSelected() {
        Log.i("PieChart", "nothing selected");
    }

}