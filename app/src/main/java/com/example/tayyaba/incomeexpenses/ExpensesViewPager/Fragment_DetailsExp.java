package com.example.tayyaba.incomeexpenses.ExpensesViewPager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tayyaba.incomeexpenses.ExpensesViewPager.RecyclerView_ByCategory_Expenses.AdapterByCategory_Expenses;
import com.example.tayyaba.incomeexpenses.ExpensesViewPager.RecyclerView_Details_Expenses.Adapter_Details_Expenses;
import com.example.tayyaba.incomeexpenses.R;

/**
 * Created by Tayyaba on 9/25/2016.
 */
public class Fragment_DetailsExp extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;

    public static Fragment_DetailsExp newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        Fragment_DetailsExp fragment = new Fragment_DetailsExp();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    // Inflate the fragment layout we defined above for this fragment
    // Set the associated text for the title
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle args = getArguments();
        View view = inflater.inflate(R.layout.fragment_details_exp, container, false);
      RecyclerView  recyclerViewDetails_exp = (RecyclerView)view.findViewById(R.id.recyclerView_details_Expenses);


        recyclerViewDetails_exp.setLayoutManager(new LinearLayoutManager(getActivity()));
        Adapter_Details_Expenses adapter_details_expenses =new Adapter_Details_Expenses(getActivity());
        recyclerViewDetails_exp.setAdapter(adapter_details_expenses);

        return view;
    }
}
