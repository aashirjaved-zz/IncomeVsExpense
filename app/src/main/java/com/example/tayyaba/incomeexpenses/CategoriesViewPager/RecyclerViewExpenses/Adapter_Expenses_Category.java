package com.example.tayyaba.incomeexpenses.CategoriesViewPager.RecyclerViewExpenses;

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

public class Adapter_Expenses_Category extends RecyclerView.Adapter<Adapter_Expenses_Category.ViewHolder> {

    public static ArrayList<DataModel_expenses_Category> expenseData = new ArrayList<>();

    Context context;
    public Adapter_Expenses_Category(ArrayList<DataModel_expenses_Category> expenseData) {
        this.expenseData = expenseData;
    }

    public Adapter_Expenses_Category(Context context)
    {
        this.context=context;
    }


    @Override
    public Adapter_Expenses_Category.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_expense_category, null);


        Adapter_Expenses_Category.ViewHolder viewHolder = new Adapter_Expenses_Category.ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(Adapter_Expenses_Category.ViewHolder viewHolder, int position) {

        // - get data from your itemsData at this position
        // - replace the contents of the view with that itemsData

        viewHolder.catName_expense_cat.setText(expenseData.get(position).getCatName());
        viewHolder.defVal_expense_cat.setText(expenseData.get(position).getDefValue());
        viewHolder.type_expense_cat.setText(expenseData.get(position).getType());


    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView catName_expense_cat,defVal_expense_cat,type_expense_cat;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            catName_expense_cat = (TextView) itemLayoutView.findViewById(R.id.catName_income_Category);
            type_expense_cat = (TextView) itemLayoutView.findViewById(R.id.type_expense_Category);

            defVal_expense_cat = (TextView) itemLayoutView.findViewById(R.id.defaultVal_expense_Category);}
    }


    @Override
    public int getItemCount() {
        return expenseData.size();
    }
}