package com.example.tayyaba.incomeexpenses.IncomeViewPager.RecyclerView_Details_Income;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tayyaba.incomeexpenses.IncomeViewPager.Recyclerview_ByDay_Income.Adapter_Child_ByDay_Income;
import com.example.tayyaba.incomeexpenses.IncomeViewPager.Recyclerview_ByDay_Income.DataModel_Child_ByDay_income;
import com.example.tayyaba.incomeexpenses.R;

import java.util.ArrayList;

/**
 * Created by tayyabataimur on 10/7/16.
 */

public class Adapter_Details_Income extends RecyclerView.Adapter<Adapter_Details_Income.ViewHolder> {

    //TODO
    //Populate dialog ka recyclerview jo k ye hy

    private ArrayList<DataModel_Details_Income> detailsData_inc = new ArrayList<>();

    Context context;
    public Adapter_Details_Income(ArrayList<DataModel_Details_Income> detailsData_inc) {
        this.detailsData_inc = detailsData_inc;
    }

    public Adapter_Details_Income(Context context)
    {
        this.context=context;
    }


    @Override
    public Adapter_Details_Income.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_details_income, null);


        Adapter_Details_Income.ViewHolder viewHolder = new Adapter_Details_Income.ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(Adapter_Details_Income.ViewHolder viewHolder, int position) {

        // - get data from your itemsData at this position
        // - replace the contents of the view with that itemsData

        viewHolder.desc_details_inc.setText(detailsData_inc.get(position).getDesc());
        viewHolder.catName_details_inc.setText(detailsData_inc.get(position).getCatName());
        viewHolder.date_details_inc.setText(detailsData_inc.get(position).getDate());
        viewHolder.amount_details_inc.setText(detailsData_inc.get(position).getAmount());




    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView desc_details_inc,catName_details_inc,date_details_inc,amount_details_inc;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            desc_details_inc = (TextView) itemLayoutView.findViewById(R.id.description_details_inc);
            catName_details_inc = (TextView) itemLayoutView.findViewById(R.id.catName_details_inc);
            amount_details_inc = (TextView) itemLayoutView.findViewById(R.id.amount_details_inc);

            date_details_inc = (TextView) itemLayoutView.findViewById(R.id.date_details_inc);}
    }


    @Override
    public int getItemCount() {
        return detailsData_inc.size();
    }
}