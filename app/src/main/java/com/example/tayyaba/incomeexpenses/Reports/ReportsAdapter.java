package com.example.tayyaba.incomeexpenses.Reports;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tayyaba.incomeexpenses.R;

import java.util.ArrayList;

/**
 * Created by aashi on 10/11/2016.
 */

public class ReportsAdapter extends RecyclerView.Adapter<ReportsAdapter.ViewHolder> {
    public static ArrayList<ReportsDataModel> reportsDataModelArrayList = new ArrayList<>();

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_details_income, null);
        ReportsAdapter.ViewHolder viewHolder = new ReportsAdapter.ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.desc_details_inc.setText(reportsDataModelArrayList.get(position).getCategory());
        holder.catName_details_inc.setText(reportsDataModelArrayList.get(position).getDate());
        holder.date_details_inc.setText("");
        holder.amount_details_inc.setText(reportsDataModelArrayList.get(position).getAmount().toString());
        holder.cat.setText("");
    }

    @Override
    public int getItemCount() {

        return reportsDataModelArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView desc_details_inc, catName_details_inc, date_details_inc, amount_details_inc, cat;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            desc_details_inc = (TextView) itemLayoutView.findViewById(R.id.description_details_inc);
            catName_details_inc = (TextView) itemLayoutView.findViewById(R.id.catName_details_inc);
            amount_details_inc = (TextView) itemLayoutView.findViewById(R.id.amount_details_inc);
            cat = (TextView) itemLayoutView.findViewById(R.id.catechange);

            date_details_inc = (TextView) itemLayoutView.findViewById(R.id.date_details_inc);
        }
    }
}
