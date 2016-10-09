package com.example.tayyaba.incomeexpenses.IncomeViewPager.RecyclerView_ByCategory_Income;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.example.tayyaba.incomeexpenses.R;
import com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddExpense.AddExpenseDataModel;
import com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddIncome.DataBaseHandlerIncome;

import java.util.ArrayList;

import static com.example.tayyaba.incomeexpenses.IncomeViewPager.RecyclerView_ByCategory_Income.Adapter_Child_ByCat_Income.childData_bycat_inc;

/**
 * Created by tayyabataimur on 10/7/16.
 */

public class Adapter_ByCategory_Income extends RecyclerView.Adapter<Adapter_ByCategory_Income.ViewHolder> {

    //TODO
    //populate this recyclerview and initialize dialog's recyclerview here too on holder's onclick like
    //you did pehle nigga 8)

    public static ArrayList<DataModel_ByCategory_Income> catData_inc = new ArrayList<>();

    Context context;
    public Adapter_ByCategory_Income(ArrayList<DataModel_ByCategory_Income> catData_inc) {
        this.catData_inc = catData_inc;
    }

    public Adapter_ByCategory_Income(Context context)
    {
        this.context=context;
    }


    @Override
    public Adapter_ByCategory_Income.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_bycat_income, null);


        Adapter_ByCategory_Income.ViewHolder viewHolder = new Adapter_ByCategory_Income.ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(Adapter_ByCategory_Income.ViewHolder viewHolder, final int position) {

        // - get data from your itemsData at this position
        // - replace the contents of the view with that itemsData

        viewHolder.catName_byCat_inc.setText(catData_inc.get(position).getCatName());
        viewHolder.amount_byCat_inc.setText(catData_inc.get(position).getAmount());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(context);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_child_bycategory_income);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                RecyclerView recyclerView_dialog=(RecyclerView)dialog.findViewById(R.id.recyclerView_dialog_byCat_income);
                Adapter_Child_ByCat_Income adapter_child_byCat_income = new Adapter_Child_ByCat_Income(context);
                LinearLayoutManager llm = new LinearLayoutManager(context);
                llm.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView_dialog.setAdapter(adapter_child_byCat_income);
                recyclerView_dialog.setLayoutManager(llm);

                childData_bycat_inc.clear();
                DataBaseHandlerIncome db = new DataBaseHandlerIncome(context);
                ArrayList<AddExpenseDataModel> incomes = db.getAllincome();
                for(AddExpenseDataModel model : incomes)
                {
                    if(model.getCategory().contains(catData_inc.get(position).getCatName()))
                    {
                        childData_bycat_inc.add(new DatModel_Child_ByCat_Income(model.getDate(),model.getDescription(), model.getAmount().toString()));
                        adapter_child_byCat_income.notifyDataSetChanged();
                    }
                    else
                    {
                        //do nothing
                        //do nothing
                    }
                }

dialog.show();
            }
        });


    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView catName_byCat_inc,amount_byCat_inc;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            catName_byCat_inc = (TextView) itemLayoutView.findViewById(R.id.catName_income_frag);
            amount_byCat_inc = (TextView) itemLayoutView.findViewById(R.id.catAmount_income);
           }
    }


    @Override
    public int getItemCount() {
        return catData_inc.size();
    }
}