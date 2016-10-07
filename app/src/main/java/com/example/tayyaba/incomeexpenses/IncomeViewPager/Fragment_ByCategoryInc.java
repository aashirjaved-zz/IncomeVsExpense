package com.example.tayyaba.incomeexpenses.IncomeViewPager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tayyaba.incomeexpenses.IncomeViewPager.RecyclerView_ByCategory_Income.Adapter_ByCategory_Income;
import com.example.tayyaba.incomeexpenses.R;

/**
 * Created by Tayyaba on 9/26/2016.
 */
public class Fragment_ByCategoryInc extends Fragment{
    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;

    public static Fragment_ByCategoryInc newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        Fragment_ByCategoryInc fragment = new Fragment_ByCategoryInc();
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

        View view = inflater.inflate(R.layout.fragment_bycategory_inc, container, false);
        //  TextView tvTitle = (TextView) view.findViewById(R.id.tvTitle);
        //  tvTitle.setText("Fragment #" + mPage);

        //TODO
        //populate recyclerview
        RecyclerView recyclerView_byCat_inc=(RecyclerView)view.findViewById(R.id.recyclerView_income_Category);
        recyclerView_byCat_inc.setLayoutManager(new LinearLayoutManager(getActivity()));
        Adapter_ByCategory_Income adapter_byCategory_income=new Adapter_ByCategory_Income(getActivity());
        recyclerView_byCat_inc.setAdapter(adapter_byCategory_income);

        return view;
    }

}
