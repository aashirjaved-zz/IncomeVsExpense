package com.example.tayyaba.incomeexpenses.CategoriesViewPager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tayyaba.incomeexpenses.CategoriesViewPager.RecyclerViewExpenses.Adapter_Expenses_Category;
import com.example.tayyaba.incomeexpenses.CategoriesViewPager.RecyclerViewExpenses.DataModel_expenses_Category;
import com.example.tayyaba.incomeexpenses.R;
import com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddCategory.CategoryDataModel;
import com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddCategory.DatabaseHandler;

import java.util.ArrayList;

import static com.example.tayyaba.incomeexpenses.CategoriesViewPager.RecyclerViewExpenses.Adapter_Expenses_Category.expenseData;


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
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_expense_Category);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        Adapter_Expenses_Category adapter_expenses_category = new Adapter_Expenses_Category(getContext());
        expenseData.clear();
        DatabaseHandler db = new DatabaseHandler(getContext());
        ArrayList<CategoryDataModel> listofcat =  db.listofCategories();
        for( CategoryDataModel model: listofcat)
        {
            if(model.getCategoryType().contains("expense"))
            {
                expenseData.add(new DataModel_expenses_Category(model.getCategoryName(),model.getCategoryValue(),model.getCategoryType()));
                recyclerView.setAdapter(adapter_expenses_category);
               // adapter_expenses_category.notifyDataSetChanged();
            }
            else
            {
//                expenseData.remove(model);
//                recyclerView.setAdapter(adapter_expenses_category);
//                adapter_expenses_category.notifyDataSetChanged();

                //do nothing
            }

        }
        adapter_expenses_category.notifyDataSetChanged();





        return view;
    }
}

