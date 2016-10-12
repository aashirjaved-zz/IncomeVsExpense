package com.example.tayyaba.incomeexpenses.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.tayyaba.incomeexpenses.R;
import com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddExpense.AddExpenseDataModel;
import com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddExpense.DatabaseHandlerExpense;
import com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddIncome.DataBaseHandlerIncome;

import java.util.ArrayList;

public class BalanceActivity extends AppCompatActivity {
TextView totalincome,totalexpense,totalbalance;
    Integer income=0;
    Integer expense =0;
    Integer balance=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        totalexpense = (TextView) findViewById(R.id.expensetotal);
        totalincome = (TextView) findViewById(R.id.incometotal);
        totalbalance = (TextView) findViewById(R.id.balancetotal);


        DatabaseHandlerExpense db = new DatabaseHandlerExpense(getApplicationContext());
        ArrayList<AddExpenseDataModel> model = new ArrayList<>();
        model = db.getAllExpenses();
        for(AddExpenseDataModel datamodel: model)
        {
            expense = expense+datamodel.getAmount();
        }
        DataBaseHandlerIncome db1 = new DataBaseHandlerIncome(getApplicationContext());
        ArrayList <AddExpenseDataModel> listofincome = new ArrayList<>();
        listofincome = db1.getAllincome();
        for(AddExpenseDataModel incomedatamodel : listofincome)
        {
            income = income + incomedatamodel.getAmount();
        }

        balance = income-expense;

        totalexpense.setText(String.valueOf(expense));
        totalincome.setText(String.valueOf(income));
        totalbalance.setText(String.valueOf(balance));


    }
}
