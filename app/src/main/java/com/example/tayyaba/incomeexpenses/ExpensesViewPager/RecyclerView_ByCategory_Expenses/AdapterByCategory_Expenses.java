package com.example.tayyaba.incomeexpenses.ExpensesViewPager.RecyclerView_ByCategory_Expenses;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tayyaba.incomeexpenses.R;
import com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddCategory.CategoryDataModel;
import com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddExpense.AddExpenseDataModel;
import com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddExpense.DatabaseHandlerExpense;

import java.util.ArrayList;

/**
 * Created by Tayyaba on 9/27/2016.
 */
public class AdapterByCategory_Expenses extends RecyclerView.Adapter<AdapterByCategory_Expenses.ViewHolder> {

    public static ArrayList<CategoryDataModel> catData = new ArrayList<>();

    public static Context context;
    TextView total;

    public AdapterByCategory_Expenses(ArrayList<CategoryDataModel> catData) {
        this.catData = catData;
    }

    public AdapterByCategory_Expenses(Context context) {

        this.context = context;


//        updateExpenses();


//            for(AddExpenseDataModel expense : data1)
//            {
//                if(catData.contains(expense))
//                {
//                    //do nothing
//                }
//                else {
//                    catData.add(new ByCategory_DataModel_Exp(expense.getDescription(), expense.getAmount().toString()));
//                    catData.add(new ByCategory_DataModel_Exp("Hello ","Data"));
//
//                }
//            }


    }


    @Override
    public AdapterByCategory_Expenses.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_parent_bycategory_expenses, null);


        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        // - get data from your itemsData at this position
        // - replace the contents of the view with that itemsData
//TODO replace them

        viewHolder.catName_Exp.setText(catData.get(position).getCategoryName());
        viewHolder.catAmount_Exp.setText(catData.get(position).getCategoryValue());


    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView catName_Exp, catAmount_Exp;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            catName_Exp = (TextView) itemLayoutView.findViewById(R.id.catName_exp);
            catAmount_Exp = (TextView) itemLayoutView.findViewById(R.id.catAmount_exp);

        }
    }


    @Override
    public int getItemCount() {
        return catData.size();
    }

    public void updateExpenses() {
        catData.clear();

        DatabaseHandlerExpense db = new DatabaseHandlerExpense(context);
        ArrayList<AddExpenseDataModel> data1 = new ArrayList<>();
        data1 = db.getAllExpenses();
//        Log.v("DatabaseItem", data1.get(0).getDescription().toString());
        if(!data1.isEmpty()) {
            for (int i = 0; i < data1.size(); i++) {
                if (catData.contains(data1.get(i))) {
                    //do nothing
                } else {
//                    catData.add(new ByCategory_DataModel_Exp(data1.get(i).getDescription(), data1.get(i).getAmount().toString()));
//                    Log.v("ArraylistCat", String.valueOf(catData.size()));
                }

            }
        }

    }

}