package com.example.tayyaba.incomeexpenses.CategoriesViewPager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tayyaba.incomeexpenses.CategoriesViewPager.RecyclerViewIncome.Adapter_Income_Category;
import com.example.tayyaba.incomeexpenses.CategoriesViewPager.RecyclerViewIncome.DataModel_Income_Category;
import com.example.tayyaba.incomeexpenses.R;
import com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddCategory.CategoryDataModel;
import com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddCategory.DatabaseHandler;

import java.util.ArrayList;

import static com.example.tayyaba.incomeexpenses.CategoriesViewPager.RecyclerViewIncome.Adapter_Income_Category.incomeData;

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


        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_income_Category);
        Adapter_Income_Category adapter_income_category = new Adapter_Income_Category(getContext());
        incomeData.clear();
        recyclerView.setAdapter(adapter_income_category);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        DatabaseHandler db = new DatabaseHandler(getContext());
        ArrayList<CategoryDataModel> listofcat =  db.listofCategories();
        for( CategoryDataModel model: listofcat)
        {
            if(model.getCategoryType().toLowerCase().contains("income"))
            {

                incomeData.add(new DataModel_Income_Category(model.getCategoryName(),model.getCategoryValue()));
                adapter_income_category.notifyDataSetChanged();


            }
        }



        return view;
    }
}