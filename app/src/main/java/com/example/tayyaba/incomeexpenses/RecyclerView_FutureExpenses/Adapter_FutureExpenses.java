package com.example.tayyaba.incomeexpenses.RecyclerView_FutureExpenses;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tayyaba.incomeexpenses.R;

import java.util.ArrayList;

/**
 * Created by tayyabataimur on 10/8/16.
 */

public class Adapter_FutureExpenses extends RecyclerView.Adapter<Adapter_FutureExpenses.ViewHolder> {

    //TODO
    //populate this recyclerview
    public static ArrayList<DataModel_FutureExpenses> futureExpensesArrayList = new ArrayList<>();

    Context context;
    public Adapter_FutureExpenses(ArrayList<DataModel_FutureExpenses> fexData) {
        this.futureExpensesArrayList = fexData;
    }

    public Adapter_FutureExpenses(Context context)
    {
        this.context=context;
        futureExpensesArrayList = new ArrayList<>();
    }


    @Override
    public Adapter_FutureExpenses.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_future_expenses, null);


        Adapter_FutureExpenses.ViewHolder viewHolder = new Adapter_FutureExpenses.ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(Adapter_FutureExpenses.ViewHolder viewHolder, int position) {

        // - get data from your itemsData at this position
        // - replace the contents of the view with that itemsData

        viewHolder.desc_fex.setText(futureExpensesArrayList.get(position).getDesc());
        viewHolder.catName_fex.setText(futureExpensesArrayList.get(position).getCatName());
        viewHolder.month_fex.setText(futureExpensesArrayList.get(position).getMonth());
        viewHolder.date_fex.setText(futureExpensesArrayList.get(position).getDate());
        viewHolder.days_fex.setText(futureExpensesArrayList.get(position).getDays());
        viewHolder.amount_fex.setText(futureExpensesArrayList.get(position).getAmount());



    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView desc_fex,catName_fex,month_fex,date_fex,days_fex,amount_fex;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            desc_fex = (TextView) itemLayoutView.findViewById(R.id.dec_fexp);
            catName_fex = (TextView) itemLayoutView.findViewById(R.id.catName_fexp);
            month_fex = (TextView) itemLayoutView.findViewById(R.id.month_fexp);
            date_fex = (TextView) itemLayoutView.findViewById(R.id.date_fexp);
            days_fex = (TextView) itemLayoutView.findViewById(R.id.days_to_fexp);
            amount_fex = (TextView) itemLayoutView.findViewById(R.id.amount_fexp);

        }
    }


    @Override
    public int getItemCount() {
        return futureExpensesArrayList.size();
    }
}