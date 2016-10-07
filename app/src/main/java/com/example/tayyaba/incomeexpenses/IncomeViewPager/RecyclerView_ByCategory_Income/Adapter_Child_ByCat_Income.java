package com.example.tayyaba.incomeexpenses.IncomeViewPager.RecyclerView_ByCategory_Income;

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

public class Adapter_Child_ByCat_Income extends RecyclerView.Adapter<Adapter_Child_ByCat_Income.ViewHolder> {

    //TODO
    //populate this dialog recyclerview

    public static ArrayList<DatModel_Child_ByCat_Income> childData_bycat_inc = new ArrayList<>();

    Context context;
    public Adapter_Child_ByCat_Income(ArrayList<DatModel_Child_ByCat_Income> childData_bycat_inc) {
        this.childData_bycat_inc = childData_bycat_inc;
    }

    public Adapter_Child_ByCat_Income(Context context)
    {
        this.context=context;
    }


    @Override
    public Adapter_Child_ByCat_Income.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_child_bycat_income, null);


        Adapter_Child_ByCat_Income.ViewHolder viewHolder = new Adapter_Child_ByCat_Income.ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(Adapter_Child_ByCat_Income.ViewHolder viewHolder, int position) {

        // - get data from your itemsData at this position
        // - replace the contents of the view with that itemsData

        viewHolder.date_child_bycat_inc.setText(childData_bycat_inc.get(position).getDate());
        viewHolder.desc_child_bycat_inc.setText(childData_bycat_inc.get(position).getDesc());
        viewHolder.amount_child_bycat_inc.setText(childData_bycat_inc.get(position).getAmount());




    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView date_child_bycat_inc,desc_child_bycat_inc,amount_child_bycat_inc;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            date_child_bycat_inc = (TextView) itemLayoutView.findViewById(R.id.child_date_byCat_income);
            desc_child_bycat_inc = (TextView) itemLayoutView.findViewById(R.id.child_description_byCat_income);
            amount_child_bycat_inc = (TextView) itemLayoutView.findViewById(R.id.child_amount_byCat_income);


        }
    }


    @Override
    public int getItemCount() {
        return childData_bycat_inc.size();
    }
}