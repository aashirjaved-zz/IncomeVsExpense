package com.example.tayyaba.incomeexpenses.ExpensesViewPager.RecyclerView_ByCategory_Expenses;

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
 * Created by tayyabataimur on 10/6/16.
 */

public class Adapter_Child_ByCat_Exp extends RecyclerView.Adapter<Adapter_Child_ByCat_Exp.ViewHolder> {

    private ArrayList<ByCategory_DataModelChild_Exp> childData = new ArrayList<>();

    Context context;
    public Adapter_Child_ByCat_Exp(ArrayList<ByCategory_DataModelChild_Exp> childData) {
        this.childData = childData;
    }

    public Adapter_Child_ByCat_Exp(Context context)
    {
        this.context=context;
    }


    @Override
    public Adapter_Child_ByCat_Exp.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_child_bycategory_expenses, null);


        Adapter_Child_ByCat_Exp.ViewHolder viewHolder = new Adapter_Child_ByCat_Exp.ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(Adapter_Child_ByCat_Exp.ViewHolder viewHolder, int position) {

        // - get data from your itemsData at this position
        // - replace the contents of the view with that itemsData

        viewHolder.date_childExp.setText(childData.get(position).getDate());
        viewHolder.desc_childExp.setText(childData.get(position).getDescription());

        viewHolder.amount_childExp.setText(childData.get(position).getAmount());


    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView date_childExp,desc_childExp,amount_childExp;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            date_childExp = (TextView) itemLayoutView.findViewById(R.id.child_date_byCat_exp);
            amount_childExp = (TextView) itemLayoutView.findViewById(R.id.child_amount_byCat_exp);
            desc_childExp = (TextView) itemLayoutView.findViewById(R.id.child_description_byCat_exp);}
    }


    @Override
    public int getItemCount() {
        return childData.size();
    }
}