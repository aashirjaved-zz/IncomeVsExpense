package com.example.tayyaba.incomeexpenses.CategoriesViewPager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tayyaba.incomeexpenses.CategoriesViewPager.RecyclerViewIncome.Adapter_Income_Category;
import com.example.tayyaba.incomeexpenses.R;

/**
 * Created by tayyabataimur on 10/5/16.
 */

public class Fragment_IncomeCat extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;

    public static Fragment_IncomeCat newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        Fragment_IncomeCat fragment = new Fragment_IncomeCat();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_income_category, container, false);
LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        RecyclerView recyclerView_income_cat=(RecyclerView)view.findViewById(R.id.recyclerView_income_Category);
        Adapter_Income_Category adapter_income_category=new Adapter_Income_Category(getActivity());
        recyclerView_income_cat.setLayoutManager(linearLayoutManager);
        recyclerView_income_cat.setAdapter(adapter_income_category);
        return view;
    }
}