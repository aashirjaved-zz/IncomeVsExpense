package com.example.tayyaba.incomeexpenses.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.tayyaba.incomeexpenses.MainActivity;
import com.example.tayyaba.incomeexpenses.R;
import com.example.tayyaba.incomeexpenses.Reports.ReportsAdapter;
import com.example.tayyaba.incomeexpenses.Reports.ReportsDataModel;
import com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddCategory.CategoryDataModel;
import com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddCategory.DatabaseHandler;
import com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddExpense.AddExpenseDataModel;
import com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddExpense.DatabaseHandlerExpense;
import com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddIncome.DataBaseHandlerIncome;
import com.jaredrummler.materialspinner.MaterialSpinner;

import java.util.ArrayList;

import static com.example.tayyaba.incomeexpenses.Reports.ReportsAdapter.reportsDataModelArrayList;

public class ReportsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports);



        final Toolbar repToolbar=(Toolbar)findViewById(R.id.toolbar_reports);
        setSupportActionBar(repToolbar);
        repToolbar.setNavigationIcon(R.drawable.ic_arrow_right_white_24dp);
        MaterialSpinner spinnerCat = (MaterialSpinner) findViewById(R.id.spinner_reports);
        final MaterialSpinner spinnersort = (MaterialSpinner) findViewById(R.id.spinner_selecttype);
        RecyclerView recycleviewreports = (RecyclerView) findViewById(R.id.recycleView_reports);
        recycleviewreports.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        final ReportsAdapter adapter = new ReportsAdapter();
        recycleviewreports.setAdapter(adapter);




        ArrayList<String> listofreports = new ArrayList<>();
        listofreports.add("Total Expenditure by month");
        listofreports.add("Compare Expense Costs ");
        listofreports.add("Total Income by month");
        listofreports.add("Compare Income Costs ");
        listofreports.add("Balance");
        spinnerCat.setItems(listofreports);
        DatabaseHandler db= new DatabaseHandler(getApplicationContext());
        final ArrayList<CategoryDataModel> listpfcat = db.listofCategories();
        reportsDataModelArrayList.clear();
        adapter.notifyDataSetChanged();
        spinnerCat.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                switch (position) {
                    case 0:

                        DatabaseHandlerExpense expense = new DatabaseHandlerExpense(getApplicationContext());
                        ArrayList<AddExpenseDataModel> expenseslist = new ArrayList<>();
                        ArrayList<String> dates = new ArrayList<>();
                        expenseslist = expense.getAllExpenses();
                        for(AddExpenseDataModel model: expenseslist)
                        {
                         //   String kept = model.getDate().substring(0,model.getDate().indexOf("-"));
                            String dateMonth = model.getDate().substring(model.getDate().indexOf("-")+1,model.getDate().length());
                           if(dates.contains(dateMonth))
                           {
                               //do ntohing
                           }
                            else
                           {
                               dates.add(dateMonth);
                           }

                        }
                        reportsDataModelArrayList.clear();
                        spinnersort.setItems(dates);


                        if(dates.size()==1)
                        {
                            final ArrayList<AddExpenseDataModel> finalExpenseslist = expenseslist;

                                Integer totalAmount=0;


                                    for (AddExpenseDataModel expensemodel: finalExpenseslist)
                                    {
                                        if(expensemodel.getDate().substring(expensemodel.getDate().indexOf("-")+1,expensemodel.getDate().length())
                                                .contains(dates.get(0)))
                                        {
                                            totalAmount = totalAmount+expensemodel.getAmount();

                                        }
                                        reportsDataModelArrayList.add( new ReportsDataModel(dates.get(0),expensemodel.getDescription() ,String.valueOf(totalAmount)) );
                                        adapter.notifyDataSetChanged();
                                    }



                        }
                        else
                        {
                            final ArrayList<AddExpenseDataModel> finalExpenseslist = expenseslist;
                            spinnersort.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {
                                Integer totalAmount=0;
                                @Override
                                public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                                    reportsDataModelArrayList.clear();
                                    Log.v("SortItem",item);
                                    for (AddExpenseDataModel expensemodel: finalExpenseslist)
                                    {
                                        if(expensemodel.getDate().substring(expensemodel.getDate().indexOf("-")+1,expensemodel.getDate().length())
                                                .contains(item))
                                        {
                                            totalAmount = totalAmount+expensemodel.getAmount();

                                        }
                                        reportsDataModelArrayList.add( new ReportsDataModel(item,expensemodel.getDescription(),String.valueOf(totalAmount)) );
                                        adapter.notifyDataSetChanged();
                                    }



                                }});
                        }




                        return ;
                    case 1:
                        spinnersort.setVisibility(View.INVISIBLE);

                        reportsDataModelArrayList.clear();
                        adapter.notifyDataSetChanged();
                        DatabaseHandlerExpense expensedb = new DatabaseHandlerExpense(getApplicationContext());
                        ArrayList<AddExpenseDataModel> expenseslisttoshow = new ArrayList<>();
                        expenseslisttoshow = expensedb.getAllExpenses();
                       for(AddExpenseDataModel ex: expenseslisttoshow)
                       {
                           Log.v("Test",ex.getAmount().toString());
                          // reportsDataModelArrayList.add(new ReportsDataModel(ex.getCategory(),ex.getDescription(),ex.getAmount().toString()));
                           reportsDataModelArrayList.add(new ReportsDataModel(ex.getDescription(),ex.getCategory(),ex.getAmount().toString()));
                           adapter.notifyDataSetChanged();

                       }
                        return;
                    case 2:

                        reportsDataModelArrayList.clear();
                        adapter.notifyDataSetChanged();


                        DataBaseHandlerIncome income = new DataBaseHandlerIncome(getApplicationContext());
                        ArrayList<AddExpenseDataModel> incomelist = new ArrayList<>();
                        ArrayList<String> datesIncome = new ArrayList<>();
                        incomelist = income.getAllincome();
                        for(AddExpenseDataModel model: incomelist)
                        {
                            //   String kept = model.getDate().substring(0,model.getDate().indexOf("-"));
                            String dateMonth = model.getDate().substring(model.getDate().indexOf("-")+1,model.getDate().length());
                            if(datesIncome.contains(dateMonth))
                            {
                                //do ntohing
                            }
                            else
                            {
                                datesIncome.add(dateMonth);
                            }

                        }
                        if(datesIncome.isEmpty())
                        {
                            Toast.makeText(getApplicationContext(),"No income",Toast.LENGTH_LONG).show();
                        }
                        else {
                            reportsDataModelArrayList.clear();
                            spinnersort.setItems(datesIncome);
                        }

                        if(datesIncome.size()==1)
                        {
                            reportsDataModelArrayList.clear();
                            final ArrayList<AddExpenseDataModel> finalIncomelist = incomelist;

                            Integer totalAmount=0;


                            for (AddExpenseDataModel expensemodel: finalIncomelist)
                            {
                                if(expensemodel.getDate().substring(expensemodel.getDate().indexOf("-")+1,expensemodel.getDate().length())
                                        .contains(datesIncome.get(0)))
                                {
                                    totalAmount = totalAmount+expensemodel.getAmount();

                                }
                                reportsDataModelArrayList.add( new ReportsDataModel(datesIncome.get(0),expensemodel.getDescription() ,String.valueOf(totalAmount)) );
                                adapter.notifyDataSetChanged();
                            }



                        }
                        else
                        {
                            final ArrayList<AddExpenseDataModel> finalIncomelist = incomelist;
                            spinnersort.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {
                                Integer totalAmount=0;
                                @Override
                                public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                                    reportsDataModelArrayList.clear();
                                    Log.v("SortItem",item);
                                    for (AddExpenseDataModel expensemodel: finalIncomelist)
                                    {
                                        if(expensemodel.getDate().substring(expensemodel.getDate().indexOf("-")+1,expensemodel.getDate().length())
                                                .contains(item))
                                        {
                                            totalAmount = totalAmount+expensemodel.getAmount();

                                        }
                                        reportsDataModelArrayList.add( new ReportsDataModel(item,expensemodel.getDescription(),String.valueOf(totalAmount)) );
                                        adapter.notifyDataSetChanged();
                                    }



                                }});
                        }

                    case 3:
                        spinnersort.setVisibility(View.INVISIBLE);
                        reportsDataModelArrayList.clear();
                        adapter.notifyDataSetChanged();
                        DataBaseHandlerIncome incomeedb = new DataBaseHandlerIncome(getApplicationContext());
                        ArrayList<AddExpenseDataModel> incomelisttoshow = new ArrayList<>();
                        incomelisttoshow = incomeedb.getAllincome();
                        for(AddExpenseDataModel ex: incomelisttoshow)
                        {
                            reportsDataModelArrayList.add(new ReportsDataModel(ex.getCategory(),ex.getAmount().toString(),ex.getDescription()));
                            adapter.notifyDataSetChanged();

                        }
                        return;
                    case 4:
                        reportsDataModelArrayList.clear();
                        adapter.notifyDataSetChanged();
                        Intent intent = new Intent(ReportsActivity.this,BalanceActivity.class);
                        startActivity(intent);





















                    default:
                        return;




                }

               // Snackbar.make(view, "Clicked " + item, Snackbar.LENGTH_LONG).show();
            }
        });

       repToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ReportsActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
