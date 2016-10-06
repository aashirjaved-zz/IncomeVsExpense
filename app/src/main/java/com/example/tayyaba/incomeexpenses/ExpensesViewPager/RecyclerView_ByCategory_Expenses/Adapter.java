package com.example.tayyaba.incomeexpenses.ExpensesViewPager.RecyclerView_ByCategory_Expenses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentObject;
import com.example.tayyaba.incomeexpenses.R;

import java.util.List;

/**
 * Created by tayyabataimur on 10/6/16.
 */

public class Adapter extends ExpandableRecyclerAdapter<ViewHolderParent_ByCat_exp, ViewHolderChild_ByCat_exp> {
    LayoutInflater mInflater;
    TextView catName;

    public Adapter(Context context, List<ParentObject> parentItemList) {
        super(context, parentItemList);
        mInflater = LayoutInflater.from(context);


    }


    @Override
    public ViewHolderParent_ByCat_exp onCreateParentViewHolder(ViewGroup viewGroup) {
        View view = mInflater.inflate(R.layout.item_parent_bycategory_expenses, viewGroup, false);
        return new ViewHolderParent_ByCat_exp(view);
    }

    @Override
    public ViewHolderChild_ByCat_exp onCreateChildViewHolder(ViewGroup viewGroup) {
        View view = mInflater.inflate(R.layout.item_child_bycategory_expenses, viewGroup, false);
        return new ViewHolderChild_ByCat_exp(view);    }
    @Override
    public void onBindParentViewHolder(ViewHolderParent_ByCat_exp byCategory_dataModelParent_exp, int i, Object o) {
        TextView catName;

        ByCategory_DataModelParent_Exp parent=(ByCategory_DataModelParent_Exp)o;
        byCategory_dataModelParent_exp.catName_byCat_exp.setText(parent.getCategoryName());

    }

    @Override
    public void onBindChildViewHolder(ViewHolderChild_ByCat_exp byCategory_dataModelChild_exp, int i, Object o) {

        ByCategory_DataModelChild_Exp child=(ByCategory_DataModelChild_Exp)o;
        byCategory_dataModelChild_exp.date_byCat_exp.setText(child.getDate());
        byCategory_dataModelChild_exp.description_byCat_exp.setText(child.getDescription());
    }
}
