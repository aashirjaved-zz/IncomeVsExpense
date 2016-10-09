package com.example.tayyaba.incomeexpenses.IncomeViewPager.RecyclerView_ByCategory_Income;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tayyaba.incomeexpenses.ExpensesViewPager.RecyclerView_ByCategory_Expenses.Adapter_Child_ByCat_Exp;
import com.example.tayyaba.incomeexpenses.ExpensesViewPager.RecyclerView_ByCategory_Expenses.ByCategory_DataModelChild_Exp;
import com.example.tayyaba.incomeexpenses.R;

import java.util.ArrayList;

/**
 * Created by tayyabataimur on 10/7/16.
 */

public class Adapter_ByCategory_Income extends RecyclerView.Adapter<Adapter_ByCategory_Income.ViewHolder> {

    //TODO
    //populate this recyclerview and initialize dialog's recyclerview here too on holder's onclick like
    //you did pehle nigga 8)

    public static ArrayList<DataModel_ByCategory_Income> catData_inc = new ArrayList<>();

    Context context;
    public Adapter_ByCategory_Income(ArrayList<DataModel_ByCategory_Income> catData_inc) {
        this.catData_inc = catData_inc;
    }

    public Adapter_ByCategory_Income(Context context)
    {
        this.context=context;
    }


    @Override
    public Adapter_ByCategory_Income.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_category_income, null);


        Adapter_ByCategory_Income.ViewHolder viewHolder = new Adapter_ByCategory_Income.ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(Adapter_ByCategory_Income.ViewHolder viewHolder, int position) {

        // - get data from your itemsData at this position
        // - replace the contents of the view with that itemsData

        viewHolder.catName_byCat_inc.setText(catData_inc.get(position).getCatName());
        viewHolder.amount_byCat_inc.setText(catData_inc.get(position).getAmount());



    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView catName_byCat_inc,amount_byCat_inc;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            catName_byCat_inc = (TextView) itemLayoutView.findViewById(R.id.catName_income_Category);
            amount_byCat_inc = (TextView) itemLayoutView.findViewById(R.id.catAmount_income);
           }
    }


    @Override
    public int getItemCount() {
        return catData_inc.size();
    }
}