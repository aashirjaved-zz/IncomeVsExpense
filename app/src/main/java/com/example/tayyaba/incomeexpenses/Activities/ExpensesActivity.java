package com.example.tayyaba.incomeexpenses.Activities;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tayyaba.incomeexpenses.ExpensesViewPager.FragmentAdapterExp;
import com.example.tayyaba.incomeexpenses.MainActivity;
import com.example.tayyaba.incomeexpenses.R;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ExpensesActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, DatePickerDialog.OnDateSetListener {

TextView pickDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenses);


        Toolbar expToolbar=(Toolbar)findViewById(R.id.toolbar_exp);
        setSupportActionBar(expToolbar);
        expToolbar.setNavigationIcon(R.drawable.ic_arrow_right_white_24dp);
        expToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ExpensesActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });



        final ViewPager viewPagerExpenses = (ViewPager) findViewById(R.id.viewpagerExpenses);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout_expenses);
        tabLayout.addTab(tabLayout.newTab().setText("By Category"));
        tabLayout.addTab(tabLayout.newTab().setText("By Day"));
        tabLayout.addTab(tabLayout.newTab().setText("Details"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final FragmentAdapterExp adapter = new FragmentAdapterExp
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPagerExpenses.setAdapter(adapter);
        viewPagerExpenses.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPagerExpenses.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_option, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.add:
                final Dialog dialog = new Dialog(this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_addnew_exp);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                MaterialSpinner spinnerCat=(MaterialSpinner)dialog.findViewById(R.id.spinner_cat_exp);
                spinnerCat.setItems("Category 1", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow");
                spinnerCat.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

                    @Override public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                        Snackbar.make(view, "Clicked " + item, Snackbar.LENGTH_LONG).show();
                    }
                });

                MaterialSpinner spinnerAcc=(MaterialSpinner)dialog.findViewById(R.id.spinner_accnt_exp);
                spinnerAcc.setItems("Account 1", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow");
                spinnerAcc.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

                    @Override public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                        Snackbar.make(view, "Clicked " + item, Snackbar.LENGTH_LONG).show();
                    }
                });

                 pickDate=(TextView
                         ) dialog.findViewById(R.id.pickDate);
                pickDate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Calendar now = Calendar.getInstance();
                        DatePickerDialog dpd = DatePickerDialog.newInstance(
                                ExpensesActivity.this,
                                now.get(Calendar.YEAR),
                                now.get(Calendar.MONTH),
                                now.get(Calendar.DAY_OF_MONTH)
                        );
                        dpd.show(getFragmentManager(), "Datepickerdialog");

                    }
                });
                dialog.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        // On selecting a spinner item
       // String item = adapterView.getItemAtPosition(i).toString();

        // Showing selected spinner item
      //  Toast.makeText(adapterView.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {

        String string= dayOfMonth+ "-" + monthOfYear+ "-"+year;
        pickDate.setText(string);

    }
}
