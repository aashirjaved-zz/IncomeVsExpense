package com.example.tayyaba.incomeexpenses.IncomeViewPager.Recyclerview_ByDay_Income;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tayyaba.incomeexpenses.ExpensesViewPager.RecyclerView_ByDay_Expenses.AdapterByDay_Expenses;
import com.example.tayyaba.incomeexpenses.ExpensesViewPager.RecyclerView_ByDay_Expenses.ByDay_DataModel_Exp;
import com.example.tayyaba.incomeexpenses.R;

import java.util.ArrayList;

/**
 * Created by tayyabataimur on 10/7/16.
 */

public class Adapter_ByDay_Income extends RecyclerView.Adapter<Adapter_ByDay_Income.ViewHolder> {

    //TODO
    //Populate this recyclerview and initialize dialog recycerview on holders onclick

    private ArrayList<DataModel_ByDay_Income> dayData_inc = new ArrayList<>();

    Context context;
    public Adapter_ByDay_Income(ArrayList<DataModel_ByDay_Income> dayData_inc) {
        this.dayData_inc = dayData_inc;
    }

    public Adapter_ByDay_Income(Context context)
    {
        this.context=context;
    }


    @Override
    public Adapter_ByDay_Income.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_byday_income, null);


        Adapter_ByDay_Income.ViewHolder viewHolder = new Adapter_ByDay_Income.ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(Adapter_ByDay_Income.ViewHolder viewHolder, int position) {

        // - get data from your itemsData at this position
        // - replace the contents of the view with that itemsData

        viewHolder.day_inc.setText(dayData_inc.get(position).getDay());
        viewHolder.dayAmount_inc.setText(dayData_inc.get(position).getDay());


    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView day_inc,dayAmount_inc;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            day_inc = (TextView) itemLayoutView.findViewById(R.id.day_inc);
            dayAmount_inc = (TextView) itemLayoutView.findViewById(R.id.dayAmount_inc);}
    }


    @Override
    public int getItemCount() {
        return dayData_inc.size();
    }
}