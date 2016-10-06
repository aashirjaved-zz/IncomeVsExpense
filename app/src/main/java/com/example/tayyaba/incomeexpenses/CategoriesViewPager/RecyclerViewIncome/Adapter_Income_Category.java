package com.example.tayyaba.incomeexpenses.CategoriesViewPager.RecyclerViewIncome;

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

public class Adapter_Income_Category  extends RecyclerView.Adapter<Adapter_Income_Category.ViewHolder> {

    private ArrayList<DataModel_Income_Category> incomeData = new ArrayList<>();

    Context context;
    public Adapter_Income_Category(ArrayList<DataModel_Income_Category> incomeData) {
        this.incomeData = incomeData;
    }

    public Adapter_Income_Category(Context context)
    {
        this.context=context;
    }


    @Override
    public Adapter_Income_Category.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_category_income, null);


        Adapter_Income_Category.ViewHolder viewHolder = new Adapter_Income_Category.ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(Adapter_Income_Category.ViewHolder viewHolder, int position) {

        // - get data from your itemsData at this position
        // - replace the contents of the view with that itemsData

        viewHolder.catName_income_cat.setText(incomeData.get(position).getCatName());
        viewHolder.defVal_income_cat.setText(incomeData.get(position).getDef_val());


    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView catName_income_cat,defVal_income_cat;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            catName_income_cat = (TextView) itemLayoutView.findViewById(R.id.catName_income_Category);
            defVal_income_cat = (TextView) itemLayoutView.findViewById(R.id.defaultVal_income_Category);}
    }


    @Override
    public int getItemCount() {
        return incomeData.size();
    }
}