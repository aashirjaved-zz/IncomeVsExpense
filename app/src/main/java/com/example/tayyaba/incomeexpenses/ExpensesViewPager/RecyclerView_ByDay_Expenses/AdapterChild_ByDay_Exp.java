package com.example.tayyaba.incomeexpenses.ExpensesViewPager.RecyclerView_ByDay_Expenses;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tayyaba.incomeexpenses.ExpensesViewPager.RecyclerView_ByCategory_Expenses.ByCategory_DataModelChild_Exp;
import com.example.tayyaba.incomeexpenses.R;

import java.util.ArrayList;

/**
 * Created by tayyabataimur on 10/7/16.
 */

public class AdapterChild_ByDay_Exp extends RecyclerView.Adapter<AdapterChild_ByDay_Exp.ViewHolder> {

    private ArrayList<ByDay_DataModelChild_Exp> childData = new ArrayList<>();

    Context context;
    public AdapterChild_ByDay_Exp(ArrayList<ByDay_DataModelChild_Exp> childData) {
        this.childData = childData;
    }

    public AdapterChild_ByDay_Exp(Context context)
    {
        this.context=context;
    }


    @Override
    public AdapterChild_ByDay_Exp.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_child_byday_exp, null);


        AdapterChild_ByDay_Exp.ViewHolder viewHolder = new AdapterChild_ByDay_Exp.ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AdapterChild_ByDay_Exp.ViewHolder viewHolder, int position) {

        // - get data from your itemsData at this position
        // - replace the contents of the view with that itemsData

        viewHolder.desc_child_byday_exp.setText(childData.get(position).getDescription_byday());
        viewHolder.catName_child_byDay_exp.setText(childData.get(position).getCatName_byday());
        viewHolder.amount_child_byDay_exp.setText(childData.get(position).getAmount_byday());



    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView desc_child_byday_exp,catName_child_byDay_exp,amount_child_byDay_exp;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            desc_child_byday_exp = (TextView) itemLayoutView.findViewById(R.id.child_desc_byDay_exp);
            catName_child_byDay_exp = (TextView) itemLayoutView.findViewById(R.id.child_cat_byDay_exp);
            amount_child_byDay_exp=(TextView)itemLayoutView.findViewById(R.id.child_amount_byDay_exp);

        }
    }


    @Override
    public int getItemCount() {
        return childData.size();
    }
}