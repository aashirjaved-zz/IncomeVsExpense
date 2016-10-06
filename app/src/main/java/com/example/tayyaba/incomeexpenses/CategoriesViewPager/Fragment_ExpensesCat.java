package com.example.tayyaba.incomeexpenses.CategoriesViewPager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tayyaba.incomeexpenses.CategoriesViewPager.RecyclerViewExpenses.Adapter_Expenses_Category;
import com.example.tayyaba.incomeexpenses.IncomeViewPager.Fragment_ByCategoryInc;
import com.example.tayyaba.incomeexpenses.R;

/**
 * Created by tayyabataimur on 10/5/16.
 */

public class Fragment_ExpensesCat extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;

    public static Fragment_ExpensesCat newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        Fragment_ExpensesCat fragment = new Fragment_ExpensesCat();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_expenses_category, container, false);

        RecyclerView recyclerView_expense_cat=(RecyclerView)view.findViewById(R.id.recyclerView_expense_Category);
        recyclerView_expense_cat.setLayoutManager(new LinearLayoutManager(getActivity()));
        Adapter_Expenses_Category adapter_expenses_category=new Adapter_Expenses_Category(getActivity());
        recyclerView_expense_cat.setAdapter(adapter_expenses_category);
        return view;
    }
}

