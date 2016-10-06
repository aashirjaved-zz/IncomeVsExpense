package com.example.tayyaba.incomeexpenses.ExpensesViewPager.RecyclerView_Details_Expenses;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tayyaba.incomeexpenses.R;

import java.util.ArrayList;

/**
 * Created by Tayyaba on 9/28/2016.
 */
public class Adapter_Details_Expenses extends RecyclerView.Adapter<Adapter_Details_Expenses.ViewHolder> {

public static ArrayList<Details_DataModel_Expenses> detailsData = new ArrayList<>();

        Context context;
public Adapter_Details_Expenses(ArrayList<Details_DataModel_Expenses> detailsData) {
        this.detailsData = detailsData;
        }

public Adapter_Details_Expenses(Context context)
        {
        this.context=context;
        }


@Override
public Adapter_Details_Expenses.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View itemLayoutView = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.item_details_exp, null);


        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
        }

@Override
public void onBindViewHolder(ViewHolder viewHolder, int position) {

        // - get data from your itemsData at this position
        // - replace the contents of the view with that itemsData

        viewHolder.description_details_exp.setText(detailsData.get(position).getDescription());
        viewHolder.catName_details_exp.setText(detailsData.get(position).getCatName());
    viewHolder.date_details_exp.setText(detailsData.get(position).getDate());
    viewHolder.amount_details_exp.setText(detailsData.get(position).getAmount());


        }

public static class ViewHolder extends RecyclerView.ViewHolder {

    public TextView description_details_exp,catName_details_exp,date_details_exp,amount_details_exp;

    public ViewHolder(View itemLayoutView) {
        super(itemLayoutView);
        description_details_exp = (TextView) itemLayoutView.findViewById(R.id.description_txtview_exp);
        catName_details_exp = (TextView) itemLayoutView.findViewById(R.id.catName_details_exp);
    date_details_exp = (TextView) itemLayoutView.findViewById(R.id.date_details_exp);

    amount_details_exp = (TextView) itemLayoutView.findViewById(R.id.amount_details_exp);}

}


    @Override
    public int getItemCount() {
        return detailsData.size();
    }
}