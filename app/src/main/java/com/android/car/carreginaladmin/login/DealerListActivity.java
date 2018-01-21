package com.android.car.carreginaladmin.login;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import com.android.car.carreginaladmin.R;
import com.android.car.carreginaladmin.login.delaership.DealerRecyclerAdapter;
import com.android.car.carreginaladmin.login.pojo.DealerListModel;

import java.util.ArrayList;

public class DealerListActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{
    private Context context;
    private int guidelineType;
    private SearchView editsearch;
    DealerRecyclerAdapter cardAdapterAdapter;
    public static ArrayList<DealerListModel> metGuideLines;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dealer_list);
        context = getApplicationContext();
        editsearch = (SearchView) findViewById(R.id.search);
        guidelineType = getIntent().getIntExtra("type", 0);

        if (guidelineType == 0) {
            metGuideLines = new ArrayList<>();
            metGuideLines.clear();
            DealerListModel dealerListModel = new DealerListModel();
            dealerListModel.setDealerNumber("26735");
            dealerListModel.setDealerNames("Longo Toyota");
            dealerListModel.setSkills(28);
            metGuideLines.add(dealerListModel);
            DealerListModel dealerListModel2 = new DealerListModel();
            dealerListModel2.setDealerNumber("23535");
            dealerListModel2.setDealerNames("Tom Toyota");
            dealerListModel2.setSkills(45);
            metGuideLines.add(dealerListModel2);
            DealerListModel dealerListModel3 = new DealerListModel();
            dealerListModel3.setDealerNumber("81235");
            dealerListModel3.setDealerNames("Larson Toyota");
            dealerListModel3.setSkills(10);
            metGuideLines.add(dealerListModel3);
            DealerListModel dealerListModel4 = new DealerListModel();
            dealerListModel4.setDealerNumber("54335");
            dealerListModel4.setDealerNames("Pierre Toyota");
            dealerListModel4.setSkills(67);
            metGuideLines.add(dealerListModel4);
            DealerListModel dealerListModel5 = new DealerListModel();
            dealerListModel5.setDealerNumber("45335");
            dealerListModel5.setDealerNames("Dan Toyota");
            dealerListModel5.setSkills(2);
            metGuideLines.add(dealerListModel5);
            DealerListModel dealerListModel6 = new DealerListModel();
            dealerListModel6.setDealerNumber("12335");
            dealerListModel6.setDealerNames("Longo Toyota");
            dealerListModel6.setSkills(17);
            metGuideLines.add(dealerListModel6);


        }


        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(context);
        cardAdapterAdapter = new DealerRecyclerAdapter(metGuideLines);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.dealer_recyclerview);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(cardAdapterAdapter);
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new ClickListener() {

            @Override
            public void onClick(View view, int position) {
                Toast.makeText(DealerListActivity.this, metGuideLines.get(position).getDealerNames(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));


        editsearch = (SearchView) findViewById(R.id.search);
        editsearch.setOnQueryTextListener(this);

    }

    @Override
    public boolean onQueryTextSubmit(String query) {

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String text = newText;
        cardAdapterAdapter.filter(text);
        return false;
    }



    private ArrayList<DealerListModel> dealerList(){

        ArrayList<DealerListModel> list = new ArrayList<>();

        for(int i = 0; i < 8; i++){
            DealerListModel imageModel = new DealerListModel();
            imageModel.setDealerNames(metGuideLines.get(i).getDealerNames());
            imageModel.setDealerNumber(metGuideLines.get(i).getDealerNumber());
            list.add(imageModel);
        }

        return list;
    }

    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }

    static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }


    }

    }



