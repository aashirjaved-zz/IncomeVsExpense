package com.example.tayyaba.incomeexpenses.ExpensesViewPager.RecyclerView_ByDay_Expenses;

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
import com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddExpense.DatabaseHandlerExpense;

import java.util.ArrayList;

import static com.example.tayyaba.incomeexpenses.ExpensesViewPager.RecyclerView_ByDay_Expenses.AdapterChild_ByDay_Exp.childData;


/**
 * Created by Tayyaba on 9/28/2016.
 */
public class AdapterByDay_Expenses extends RecyclerView.Adapter<AdapterByDay_Expenses.ViewHolder> {

    public static ArrayList<ByDay_DataModel_Exp> dayData = new ArrayList<>();

    Context context;
    public AdapterByDay_Expenses(ArrayList<ByDay_DataModel_Exp> dayData) {
        this.dayData = dayData;
    }

    public AdapterByDay_Expenses(Context context)
    {
        this.context=context;
    }


    @Override
    public AdapterByDay_Expenses.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_byday_exp, null);


        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // - get data from your itemsData at this position
        // - replace the contents of the view with that itemsData

        viewHolder.day_Exp.setText(dayData.get(position).getDay());
        viewHolder.dayAmount_Exp.setText(dayData.get(position).getAmount());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(context);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_child_byday_exp);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                RecyclerView recyclerView_dialog1=(RecyclerView)dialog.findViewById(R.id.recyclerView_dialog_byDay_exp);
                AdapterChild_ByDay_Exp adapterChildByday = new AdapterChild_ByDay_Exp(context);
                LinearLayoutManager llm = new LinearLayoutManager(context);
                llm.setOrientation(LinearLayoutManager.VERTICAL);

                recyclerView_dialog1.setAdapter(adapterChildByday);
                recyclerView_dialog1.setLayoutManager(llm );
                DatabaseHandlerExpense db = new DatabaseHandlerExpense(context);
                ArrayList<AddExpenseDataModel>  expenses = db.getAllExpenses();

                childData.clear();

                for(AddExpenseDataModel expenseDataModel : expenses)
                {
                    if(expenseDataModel.getDate().contains( dayData.get(position).getDay()))
                    {
                        Log.v("testingdialog","add data");
                        childData
                        .add(new ByDay_DataModelChild_Exp(expenseDataModel.getDescription(),expenseDataModel.getAmount().toString(),expenseDataModel.getDate()));
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

        public TextView day_Exp,dayAmount_Exp;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            day_Exp = (TextView) itemLayoutView.findViewById(R.id.day_exp);
            dayAmount_Exp = (TextView) itemLayoutView.findViewById(R.id.dayAmount_exp);}
    }


    @Override
    public int getItemCount() {
        return dayData.size();
    }
}