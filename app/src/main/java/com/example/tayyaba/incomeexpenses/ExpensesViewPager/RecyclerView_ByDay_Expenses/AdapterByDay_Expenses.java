package com.example.tayyaba.incomeexpenses.ExpensesViewPager.RecyclerView_ByDay_Expenses;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tayyaba.incomeexpenses.ExpensesViewPager.RecyclerView_ByCategory_Expenses.ByCategory_DataModel_Exp;
import com.example.tayyaba.incomeexpenses.R;

/**
 * Created by Tayyaba on 9/28/2016.
 */
public class AdapterByDay_Expenses extends RecyclerView.Adapter<AdapterByDay_Expenses.ViewHolder> {

    private ByDay_DataModel_Exp[] dayData;

    Context context;
    public AdapterByDay_Expenses(ByDay_DataModel_Exp[] dayData) {
        this.dayData = dayData;
    }

    public AdapterByDay_Expenses(Context context)
    {
        this.context=context;
    }


    @Override
    public AdapterByDay_Expenses.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_byday_exp, null);


        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        // - get data from your itemsData at this position
        // - replace the contents of the view with that itemsData

        viewHolder.day_Exp.setText(dayData[position].getDay());
        viewHolder.dayAmount_Exp.setText(dayData[position].getAmount());


    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView day_Exp,dayAmount_Exp;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            day_Exp = (TextView) itemLayoutView.findViewById(R.id.day_exp);
            dayAmount_Exp = (TextView) itemLayoutView.findViewById(R.id.dayAmount_exp);}
    }


    @Override
    public int getItemCount() {
        return dayData.length;
    }
}