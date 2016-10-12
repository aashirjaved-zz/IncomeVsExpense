package com.example.tayyaba.incomeexpenses.LimitsViewPager.RecycleViewDefinedLimits;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tayyaba.incomeexpenses.R;
import com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddLimits.LimitDataModel;

import java.util.ArrayList;

/**
 * Created by aashi on 10/11/2016.
 */

public class DefinedLimitsAdapter extends RecyclerView.Adapter<DefinedLimitsAdapter.ViewHolder>{
    public static ArrayList<LimitDataModel> definedLimits = new ArrayList<>();
    public DefinedLimitsAdapter()
    {
        definedLimits = new ArrayList<>();
    }

    @Override
    public DefinedLimitsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_details_income, null);


        DefinedLimitsAdapter.ViewHolder viewHolder = new DefinedLimitsAdapter.ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.desc_details_inc.setText(definedLimits.get(position).getCategoryName());
        holder.catName_details_inc.setText(definedLimits.get(position).getTo());
        holder.date_details_inc.setText("From : " + definedLimits.get(position).getFrom());
        holder.amount_details_inc.setText(definedLimits.get(position).getAmount().toString());
        holder.cat.setText("To ");
    }

    @Override
    public int getItemCount() {
        return definedLimits.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView desc_details_inc,catName_details_inc,date_details_inc,amount_details_inc,cat;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            desc_details_inc = (TextView) itemLayoutView.findViewById(R.id.description_details_inc);
            catName_details_inc = (TextView) itemLayoutView.findViewById(R.id.catName_details_inc);
            amount_details_inc = (TextView) itemLayoutView.findViewById(R.id.amount_details_inc);
            cat = (TextView) itemLayoutView.findViewById(R.id.catechange);

            date_details_inc = (TextView) itemLayoutView.findViewById(R.id.date_details_inc);}
    }

}
