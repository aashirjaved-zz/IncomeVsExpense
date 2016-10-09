package com.example.tayyaba.incomeexpenses.IncomeViewPager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tayyaba.incomeexpenses.IncomeViewPager.Recyclerview_ByDay_Income.Adapter_ByDay_Income;
import com.example.tayyaba.incomeexpenses.IncomeViewPager.Recyclerview_ByDay_Income.DataModel_ByDay_Income;
import com.example.tayyaba.incomeexpenses.R;
import com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddExpense.AddExpenseDataModel;
import com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddIncome.DataBaseHandlerIncome;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import static com.example.tayyaba.incomeexpenses.IncomeViewPager.Recyclerview_ByDay_Income.Adapter_ByDay_Income.dayData_inc_frag;

/**
 * Created by Tayyaba on 9/26/2016.
 */
public class Fragment_ByDayInc  extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;

    public static Fragment_ByDayInc newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        Fragment_ByDayInc fragment = new Fragment_ByDayInc();
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

        View view = inflater.inflate(R.layout.fragment_byday_inc, container, false);


        Calendar c = Calendar.getInstance();
        System.out.println("Current time => " + c.getTime());

        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

        RecyclerView recyclerViewDay_exp = (RecyclerView)view.findViewById(R.id.recyclerView_byDay_Income);

        Adapter_ByDay_Income adapter_byDay_income = new Adapter_ByDay_Income(getContext());
        recyclerViewDay_exp.setAdapter(adapter_byDay_income);
        recyclerViewDay_exp.setLayoutManager(new LinearLayoutManager(getContext()));
        dayData_inc_frag.clear();
        DataBaseHandlerIncome db = new DataBaseHandlerIncome(getContext());
        ArrayList<AddExpenseDataModel> income= db.getAllincome();
        ArrayList<String> dates = new ArrayList<>();
        Integer totalamount=0;
        for(AddExpenseDataModel mode : income)
        {
            if(dates.contains(mode.getDate()))
            {
                // do nothing
            }
            else
            {
                dates.add(mode.getDate());
            }
        }
        for(String dateData: dates)
        {
            for(AddExpenseDataModel dataModel: income)
            {
                if(dataModel.getDate().contains(dateData))
                {
                    totalamount=totalamount+dataModel.getAmount();
                }
            }
            dayData_inc_frag.add( new DataModel_ByDay_Income(dateData,totalamount.toString()));
            adapter_byDay_income.notifyDataSetChanged();
            totalamount=0;
        }

        //  TextView tvTitle = (TextView) view.findViewById(R.id.tvTitle);
        //  tvTitle.setText("Fragment #" + mPage);

//        RecyclerView recyclerView_byDay_inc=(RecyclerView)view.findViewById(R.id.recyclerView_dialog_byDay_inc);
//        recyclerView_byDay_inc.setLayoutManager(new LinearLayoutManager(getActivity()));
//
//        Adapter_ByDay_Income adapter_byDay_income=new Adapter_ByDay_Income(getActivity());
//
//        recyclerView_byDay_inc.setAdapter(adapter_byDay_income);
        return view;
    }

}
