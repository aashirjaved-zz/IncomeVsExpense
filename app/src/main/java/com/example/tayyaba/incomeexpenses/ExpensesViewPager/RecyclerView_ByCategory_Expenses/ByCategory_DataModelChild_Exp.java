package com.example.tayyaba.incomeexpenses.ExpensesViewPager.RecyclerView_ByCategory_Expenses;

import android.view.View;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;

/**
 * Created by tayyabataimur on 10/6/16.
 */

public class ByCategory_DataModelChild_Exp extends ChildViewHolder {

    private String date, description;

    public ByCategory_DataModelChild_Exp(View itemView)
    {

        super(itemView);

    }


    public ByCategory_DataModelChild_Exp(View itemView,String date,String description) {
        super(itemView);
        this.date=date;
        this.description=description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
