package com.example.tayyaba.incomeexpenses.IncomeViewPager.Recyclerview_ByDay_Income;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.example.tayyaba.incomeexpenses.R;
import com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddExpense.AddExpenseDataModel;
import com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddIncome.DataBaseHandlerIncome;

import java.util.ArrayList;

import static com.example.tayyaba.incomeexpenses.IncomeViewPager.Recyclerview_ByDay_Income.Adapter_Child_ByDay_Income.childdayData_inc;

/**
 * Created by tayyabataimur on 10/7/16.
 */

public class Adapter_ByDay_Income extends RecyclerView.Adapter<Adapter_ByDay_Income.ViewHolder> {

    //TODO
    //Populate this recyclerview and initialize dialog recycerview on holders onclick

    public static ArrayList<DataModel_ByDay_Income> dayData_inc_frag = new ArrayList<>();

    Context context;
    public Adapter_ByDay_Income(ArrayList<DataModel_ByDay_Income> dayData_inc) {
        this.dayData_inc_frag = dayData_inc;
    }

    public Adapter_ByDay_Income(Context context)
    {
        this.context=context;
    }


    @Override
    public Adapter_ByDay_Income.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_byday_income, null);


        Adapter_ByDay_Income.ViewHolder viewHolder = new Adapter_ByDay_Income.ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(Adapter_ByDay_Income.ViewHolder viewHolder, final int position) {

        // - get data from your itemsData at this position
        // - replace the contents of the view with that itemsData

        viewHolder.day_inc.setText(dayData_inc_frag.get(position).getDay());
        viewHolder.dayAmount_inc.setText(dayData_inc_frag.get(position).getAmount());




viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_child_byday_income);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        RecyclerView recyclerView_dialog1=(RecyclerView)dialog.findViewById(R.id.recyclerView_dialog_byDay_inc);
        Adapter_Child_ByDay_Income adapterChildByday = new Adapter_Child_ByDay_Income(context);
        LinearLayoutManager llm = new LinearLayoutManager(context);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView_dialog1.setAdapter(adapterChildByday);
        recyclerView_dialog1.setLayoutManager(llm );
        DataBaseHandlerIncome db = new DataBaseHandlerIncome(context);
        ArrayList<AddExpenseDataModel>  expenses = db.getAllincome();

        childdayData_inc.clear();

        for(AddExpenseDataModel expenseDataModel : expenses)
        {
            if(expenseDataModel.getDate().contains( dayData_inc_frag.get(position).getDay()))
            {
                Log.v("testingdialog","add data");
                childdayData_inc
                        .add(new DataModel_Child_ByDay_income(expenseDataModel.getDescription(),expenseDataModel.getAmount().toString(),expenseDataModel.getDate()));
                adapterChildByday.notifyDataSetChanged();
            }
            else
            {
                Log.v("testingdialog","clearlist");
                //childData.clear();
                //adapter_dialog.notifyDataSetChanged();
            }
        }






        dialog.show();

    }
});
















    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView day_inc,dayAmount_inc;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            day_inc = (TextView) itemLayoutView.findViewById(R.id.day_inc);
            dayAmount_inc = (TextView) itemLayoutView.findViewById(R.id.dayAmount_inc);

        }
    }


    @Override
    public int getItemCount() {
        return dayData_inc_frag.size();
    }
}