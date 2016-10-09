package com.example.tayyaba.incomeexpenses.IncomeViewPager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tayyaba.incomeexpenses.IncomeViewPager.RecyclerView_ByCategory_Income.Adapter_ByCategory_Income;
import com.example.tayyaba.incomeexpenses.IncomeViewPager.RecyclerView_ByCategory_Income.DataModel_ByCategory_Income;
import com.example.tayyaba.incomeexpenses.R;
import com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddCategory.CategoryDataModel;
import com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddCategory.DatabaseHandler;
import com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddExpense.AddExpenseDataModel;
import com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddIncome.DataBaseHandlerIncome;

import java.util.ArrayList;

import static com.example.tayyaba.incomeexpenses.IncomeViewPager.RecyclerView_ByCategory_Income.Adapter_ByCategory_Income.catData_inc;

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
//        RecyclerView recyclerView_byCat_inc=(RecyclerView)view.findViewById(R.id.recyclerView_income_Category);
//        recyclerView_byCat_inc.setLayoutManager(new LinearLayoutManager(getActivity()));
//        Adapter_ByCategory_Income adapter_byCategory_income=new Adapter_ByCategory_Income(getActivity());
//                               recyclerView_byCat_inc.setAdapter(adapter_byCategory_income);
//
//        catData_inc.clear();
        showData(view);



        return view;
    }
    public void showData(View view)
    {
        RecyclerView recyclerView_byCat_inc=(RecyclerView)view.findViewById(R.id.recyclerView_byCat_income);
        recyclerView_byCat_inc.setLayoutManager(new LinearLayoutManager(getActivity()));
        Adapter_ByCategory_Income adapter_byCategory_income=new Adapter_ByCategory_Income(getActivity());
        recyclerView_byCat_inc.setAdapter(adapter_byCategory_income);
        catData_inc.clear();
        DatabaseHandler db = new DatabaseHandler(getContext());
        ArrayList<CategoryDataModel> categoryDataModels = db.listofCategories();

        DataBaseHandlerIncome db1 = new DataBaseHandlerIncome(getContext());
        ArrayList<AddExpenseDataModel> incomedataModel= db1.getAllincome();
        Integer totalamount = 0;

        for(CategoryDataModel model: categoryDataModels) {

            if (model.getCategoryType().contains("income")) {
                for (AddExpenseDataModel expenseData : incomedataModel) {
                    if (model.getCategoryName().contains(expenseData.getCategory())) {
                        totalamount = totalamount + expenseData.getAmount();


                    }


                }
                if (totalamount.equals(0)) {
                    catData_inc.add(new DataModel_ByCategory_Income(model.getCategoryName(), model.getCategoryValue()));
                    adapter_byCategory_income.notifyDataSetChanged();

                } else {
                    catData_inc.add(new DataModel_ByCategory_Income(model.getCategoryName(), String.valueOf(totalamount)));
                    totalamount = 0;
                    adapter_byCategory_income.notifyDataSetChanged();
                }

            }
            else
            {
                // do nothing
            }
        }
    }

}
