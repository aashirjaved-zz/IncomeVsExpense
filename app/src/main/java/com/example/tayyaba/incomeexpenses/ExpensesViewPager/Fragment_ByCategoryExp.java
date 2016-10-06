package com.example.tayyaba.incomeexpenses.ExpensesViewPager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tayyaba.incomeexpenses.ExpensesViewPager.RecyclerView_ByCategory_Expenses.AdapterByCategory_Expenses;
import com.example.tayyaba.incomeexpenses.ExpensesViewPager.RecyclerView_ByCategory_Expenses.ByCategory_DataModelParent_Exp;
import com.example.tayyaba.incomeexpenses.R;
import com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddCategory.CategoryDataModel;
import com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddCategory.DatabaseHandler;
import com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddExpense.AddExpenseDataModel;
import com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddExpense.DatabaseHandlerExpense;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tayyaba on 9/25/2016.
 */
public class Fragment_ByCategoryExp extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    private List<ByCategory_DataModelParent_Exp> catList = new ArrayList<>();

    RecyclerView recyclerViewCat_exp;
    AdapterByCategory_Expenses adapter_ByCategory_expenses;
    private int mPage;
   // private ArrayList<ByCategory_DataModel_Exp>categoriesList=new ArrayList<>();


    public static Fragment_ByCategoryExp newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        Fragment_ByCategoryExp fragment = new Fragment_ByCategoryExp();
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

        View view = inflater.inflate(R.layout.fragment_bycategory_exp, container, false);

        recyclerViewCat_exp = (RecyclerView)view.findViewById(R.id.recyclerView_byCat_Expenses);


        //TODO

        //CAT RECYCLERVIEW

        //DIALOG RECYCLERVIEW

        return view;
    }



}