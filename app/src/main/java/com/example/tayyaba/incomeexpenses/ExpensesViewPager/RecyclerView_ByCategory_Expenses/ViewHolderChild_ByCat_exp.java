package com.example.tayyaba.incomeexpenses.ExpensesViewPager.RecyclerView_ByCategory_Expenses;

import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;
import com.example.tayyaba.incomeexpenses.R;

/**
 * Created by tayyabataimur on 10/6/16.
 */

public class ViewHolderChild_ByCat_exp extends ChildViewHolder {
    TextView date_byCat_exp;
    TextView description_byCat_exp;

    public ViewHolderChild_ByCat_exp(View itemView) {
        super(itemView);

        date_byCat_exp=(TextView)itemView.findViewById(R.id.child_date_byCat_exp);
        description_byCat_exp=(TextView)itemView.findViewById(R.id.child_description_byCat_exp);
    }
}
