package com.example.tayyaba.incomeexpenses.ExpensesViewPager.RecyclerView_ByCategory_Expenses;

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
import com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddCategory.CategoryDataModel;
import com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddExpense.AddExpenseDataModel;
import com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddExpense.DatabaseHandlerExpense;

import java.util.ArrayList;

import static com.example.tayyaba.incomeexpenses.ExpensesViewPager.RecyclerView_ByCategory_Expenses.Adapter_Child_ByCat_Exp.childData;

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
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // - get data from your itemsData at this position
        // - replace the contents of the view with that itemsData
        //TODO replace them
        Log.v("Sizeofdata",String.valueOf(getItemCount()));



        viewHolder.catName_Exp.setText(catData.get(position).getCategoryName());
        viewHolder.catAmount_Exp.setText(catData.get(position).getCategoryValue());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(context);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_child_bycat_exp);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                RecyclerView recyclerView_dialog=(RecyclerView)dialog.findViewById(R.id.recyclerView_dialog_byCat_exp);
                Adapter_Child_ByCat_Exp adapter_dialog = new Adapter_Child_ByCat_Exp(context);
                LinearLayoutManager llm = new LinearLayoutManager(context);
                llm.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView_dialog.setLayoutManager(llm );
                recyclerView_dialog.setAdapter(adapter_dialog);
                childData.clear();

                DatabaseHandlerExpense db = new DatabaseHandlerExpense(context);
                ArrayList<AddExpenseDataModel>  expenses = db.getAllExpenses();
                for(AddExpenseDataModel expenseDataModel : expenses)
                {
                    if(expenseDataModel.getCategory().contains( catData.get(position).getCategoryName()))
                    {
                        Log.v("testingdialog","add data");
                        childData.add(new ByCategory_DataModelChild_Exp(expenseDataModel.getDate(),expenseDataModel.getDescription(),expenseDataModel.getAmount().toString()));
                        adapter_dialog.notifyDataSetChanged();
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