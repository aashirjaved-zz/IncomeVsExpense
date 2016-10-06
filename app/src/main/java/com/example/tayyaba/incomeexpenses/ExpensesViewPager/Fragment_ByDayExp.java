package com.example.tayyaba.incomeexpenses.ExpensesViewPager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tayyaba.incomeexpenses.ExpensesViewPager.RecyclerView_ByDay_Expenses.AdapterByDay_Expenses;
import com.example.tayyaba.incomeexpenses.ExpensesViewPager.RecyclerView_ByDay_Expenses.ByDay_DataModel_Exp;
import com.example.tayyaba.incomeexpenses.R;
import com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddExpense.AddExpenseDataModel;
import com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddExpense.DatabaseHandlerExpense;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import static com.example.tayyaba.incomeexpenses.ExpensesViewPager.RecyclerView_ByDay_Expenses.AdapterByDay_Expenses.dayData;

/**
 * Created by Tayyaba on 9/25/2016.
 */
public class Fragment_ByDayExp extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;

    public static Fragment_ByDayExp newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        Fragment_ByDayExp fragment = new Fragment_ByDayExp();
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
        View view = inflater.inflate(R.layout.fragment_byday_exp, container, false);
       RecyclerView recyclerViewDay_exp = (RecyclerView)view.findViewById(R.id.recyclerView_byDay_Expenses);
        Calendar c = Calendar.getInstance();
        System.out.println("Current time => " + c.getTime());

        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = df.format(c.getTime());
        recyclerViewDay_exp.setLayoutManager(new LinearLayoutManager(getActivity()));
        AdapterByDay_Expenses adapterByDay_expenses =new AdapterByDay_Expenses(getActivity());
        recyclerViewDay_exp.setAdapter(adapterByDay_expenses);
        dayData.clear();
        DatabaseHandlerExpense db = new DatabaseHandlerExpense(getContext());
        ArrayList<AddExpenseDataModel> expenses = db.getAllExpenses();
        Integer totalAmount=0;
        ArrayList<String> dates = new ArrayList<>();
        for(AddExpenseDataModel model: expenses) {
            if(dates.contains(model.getDate()))
            {
                // do nothing
            }
            else
            {
                dates.add(model.getDate());
            }

        }
        for(String dateData : dates)
        {
            for (AddExpenseDataModel expenseDataModel: expenses)
            {
                if(expenseDataModel.getDate().contains(dateData))
                {
                    totalAmount=totalAmount+expenseDataModel.getAmount();

                }
            }
            dayData.add(  new ByDay_DataModel_Exp(dateData,totalAmount.toString()));
            adapterByDay_expenses.notifyDataSetChanged();
            totalAmount=0;

        }










        return view;
    }

}