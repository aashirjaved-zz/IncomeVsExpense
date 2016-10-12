package com.example.tayyaba.incomeexpenses.Activities;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tayyaba.incomeexpenses.MainActivity;
import com.example.tayyaba.incomeexpenses.R;
import com.example.tayyaba.incomeexpenses.RecyclerView_FutureExpenses.Adapter_FutureExpenses;
import com.example.tayyaba.incomeexpenses.RecyclerView_FutureExpenses.DataModel_FutureExpenses;
import com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddCategory.CategoryDataModel;
import com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddCategory.DatabaseHandler;
import com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddFutureExpense.DatabaseHandlerFutureExpense;
import com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddFutureExpense.FutureExpenseDataModel;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import static com.example.tayyaba.incomeexpenses.RecyclerView_FutureExpenses.Adapter_FutureExpenses.futureExpensesArrayList;

public class FutureExpensesActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    TextView amount, description;
    TextView totalamounttxt;
    String selectedDate, selectedcategory, selectedtype;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_future_expenses);
        Toolbar fexToolbar = (Toolbar) findViewById(R.id.toolbar_f_exp);
        setSupportActionBar(fexToolbar);
        fexToolbar.setNavigationIcon(R.drawable.ic_arrow_right_white_24dp);
        fexToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FutureExpensesActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //TODO
        //future expenses ka recyclerview
        Calendar c = Calendar.getInstance();
        System.out.println("Current time => " + c.getTime());
        totalamounttxt   = (TextView) findViewById(R.id.totalfutureamount) ;
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = df.format(c.getTime());
        selectedDate = formattedDate;
        futureExpensesArrayList.clear();
        RecyclerView recyclerView_fex = (RecyclerView) findViewById(R.id.recyclerView_f_expenses);
        Adapter_FutureExpenses adapter_futureExpenses = new Adapter_FutureExpenses(getApplicationContext());
        recyclerView_fex.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView_fex.setAdapter(adapter_futureExpenses);
        DatabaseHandlerFutureExpense db = new DatabaseHandlerFutureExpense(getApplicationContext());
        ArrayList<FutureExpenseDataModel> list = db.getAllExpenses();

          Integer totalamount=0;
        totalamounttxt.setText(totalamount.toString());
        for (FutureExpenseDataModel model : list) {


            Log.v("futureexpenes", String.valueOf(futureExpensesArrayList.size()));
            futureExpensesArrayList.add(
                    new DataModel_FutureExpenses
                            (model.getDescription(),
                                    model.getType(),
                                    model.getDate(),
                                    model.getCategory(),
                                    model.getAmount().toString()));
            adapter_futureExpenses.notifyDataSetChanged();
            totalamount=totalamount+model.getAmount();
    }
        totalamounttxt.setText(totalamount.toString());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_option, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add:
                final Dialog dialog = new Dialog(this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_addnew_f_exp);
                amount = (TextView) dialog.findViewById(R.id.amount_input_fexp);
                description = (TextView) dialog.findViewById(R.id.descriptionAdd_fexp);
                MaterialSpinner spinnerCat = (MaterialSpinner) dialog.findViewById(R.id.spinner_cat_fexp);
                MaterialSpinner spinnerAccount = (MaterialSpinner) dialog.findViewById(R.id.spinner_accnt_fexp);
                MaterialSpinner spinnermonth = (MaterialSpinner) dialog.findViewById(R.id.spinner_every_fexp);
                ImageView saveData = (ImageView) dialog.findViewById(R.id.saveDialogue);

                DatabaseHandler db = new DatabaseHandler(getApplicationContext());
                ArrayList<CategoryDataModel> model = db.listofCategories();
                ArrayList<String> catEx = new ArrayList<>();
                for (CategoryDataModel model1 : model) {
                    if (model1.getCategoryType().contains("expense")) {
                        catEx.add(model1.getCategoryName());
                    } else {
                        // do nothing
                    }
                }
                if (catEx.isEmpty()) {
                    Intent intent = new Intent(FutureExpensesActivity.this, CategoriesActivity.class);
                    startActivity(intent);

                } else {


                    spinnerCat.setItems(catEx);
                    selectedcategory = catEx.get(0);
                    spinnerCat.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

                        @Override
                        public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                            selectedcategory = item;
                            Snackbar.make(view, "Clicked " + item, Snackbar.LENGTH_LONG).show();
                        }
                    });
                    spinnerAccount.setItems("Account1");
                    ArrayList<String> listofMonth = new ArrayList<>();
                    listofMonth.add("1 Month");
                    listofMonth.add("2 Month");
                    listofMonth.add("3 Month");
                    listofMonth.add("4 Month");
                    listofMonth.add("5 Month");
                    listofMonth.add("6 Month");
                    listofMonth.add("7 Month");
                    listofMonth.add("8 Month");
                    listofMonth.add("9 Month");
                    listofMonth.add("10 Month");
                    listofMonth.add("11 Month");
                    listofMonth.add("1 Year");
                    listofMonth.add("One time");
                    spinnermonth.setItems(listofMonth);


                    spinnermonth.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

                        @Override
                        public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                            selectedtype = item;
                            Snackbar.make(view, "Clicked " + item, Snackbar.LENGTH_LONG).show();
                        }
                    });

                    TextView pickDate = (TextView
                            ) dialog.findViewById(R.id.pickDate_fexp);
                    pickDate.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Calendar now = Calendar.getInstance();
                            DatePickerDialog dpd = DatePickerDialog.newInstance(
                                    FutureExpensesActivity.this,
                                    now.get(Calendar.YEAR),
                                    now.get(Calendar.MONTH),
                                    now.get(Calendar.DAY_OF_MONTH)
                            );

                            dpd.show(getFragmentManager(), "Datepickerdialog");

                        }
                    });


                    saveData.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            DatabaseHandlerFutureExpense db = new DatabaseHandlerFutureExpense(getApplicationContext());
                            db.addExpense(new FutureExpenseDataModel(description.getText().toString(), Integer.valueOf(amount.getText().toString()), selectedDate, selectedtype, selectedcategory));

                            Toast.makeText(getApplicationContext(), "Expense added successfuly", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    });

                    //TODO
                    //initialize dialog k components and do all the backend stuff for adding
                    //new future expense from dialog here

                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    dialog.show();
                    return true;
                }
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        String string = dayOfMonth + "-" + monthOfYear + "-" + year;
        selectedDate = string;
        // date = new Date(year, monthOfYear, dayOfMonth);

    }
}