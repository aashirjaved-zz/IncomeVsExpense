package com.example.tayyaba.incomeexpenses.IncomeViewPager.Recyclerview_ByDay_Income;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tayyaba.incomeexpenses.R;

import java.util.ArrayList;

/**
 * Created by tayyabataimur on 10/7/16.
 */

public class Adapter_Child_ByDay_Income extends RecyclerView.Adapter<Adapter_Child_ByDay_Income.ViewHolder> {

    //TODO
    //Populate dialog ka recyclerview jo k ye hy

    private ArrayList<DataModel_Child_ByDay_income> childdayData_inc = new ArrayList<>();

    Context context;
    public Adapter_Child_ByDay_Income(ArrayList<DataModel_Child_ByDay_income> childdayData_inc) {
        this.childdayData_inc = childdayData_inc;
    }

    public Adapter_Child_ByDay_Income(Context context)
    {
        this.context=context;
    }


    @Override
    public Adapter_Child_ByDay_Income.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_child_byday_income, null);


        Adapter_Child_ByDay_Income.ViewHolder viewHolder = new Adapter_Child_ByDay_Income.ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(Adapter_Child_ByDay_Income.ViewHolder viewHolder, int position) {

        // - get data from your itemsData at this position
        // - replace the contents of the view with that itemsData

        viewHolder.desc_child_byday_inc.setText(childdayData_inc.get(position).getDesc());
        viewHolder.amount_child_byday_inc.setText(childdayData_inc.get(position).getAmount());
        viewHolder.catName_child_byday_inc.setText(childdayData_inc.get(position).getCatName());



    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView desc_child_byday_inc,catName_child_byday_inc,amount_child_byday_inc;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            desc_child_byday_inc = (TextView) itemLayoutView.findViewById(R.id.child_desc_byDay_inc);
            amount_child_byday_inc = (TextView) itemLayoutView.findViewById(R.id.child_amount_byDay_inc);
            catName_child_byday_inc = (TextView) itemLayoutView.findViewById(R.id.child_cat_byDay_inc);}
    }


    @Override
    public int getItemCount() {
        return childdayData_inc.size();
    }
}