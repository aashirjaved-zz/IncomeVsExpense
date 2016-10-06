package com.example.tayyaba.incomeexpenses.ExpensesViewPager.RecyclerView_ByCategory_Expenses;

import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;
import com.example.tayyaba.incomeexpenses.R;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

/**
 * Created by tayyabataimur on 10/6/16.
 */

public class ViewHolderParent_ByCat_exp extends ParentViewHolder {

    public TextView catName_byCat_exp;
    public TextView amount_byCat_exp;

    public ViewHolderParent_ByCat_exp(View itemView) {
        super(itemView);

        catName_byCat_exp=(TextView)itemView.findViewById(R.id.catName_exp);
        amount_byCat_exp=(TextView)itemView.findViewById(R.id.catAmount_exp);
    }
}