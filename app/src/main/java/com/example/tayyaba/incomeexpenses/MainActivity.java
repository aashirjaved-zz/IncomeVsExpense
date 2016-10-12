package com.example.tayyaba.incomeexpenses;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.example.tayyaba.incomeexpenses.Activities.CategoriesActivity;
import com.example.tayyaba.incomeexpenses.Activities.ExpensesActivity;
import com.example.tayyaba.incomeexpenses.Activities.FutureExpensesActivity;
import com.example.tayyaba.incomeexpenses.Activities.IncomeActivity;
import com.example.tayyaba.incomeexpenses.Activities.LimitsActivity;
import com.example.tayyaba.incomeexpenses.Activities.ReportsActivity;
import com.example.tayyaba.incomeexpenses.Activities.SettingsActivity;


public class MainActivity extends AppCompatActivity {
    String[] perms = {"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.CAMERA"
    };
    int permsRequestCode = 200;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar customToolbar=(Toolbar)findViewById(R.id.toolbar_custom);
        setSupportActionBar(customToolbar);
       // customToolbar.setNavigationIcon(R.drawable.ic_arrow_right_white_24dp);


        if (Build.VERSION.SDK_INT < 23)
            ContextCompat.checkSelfPermission(this, String.valueOf(perms));
        else
            requestPermissions(perms, permsRequestCode);
        //Testing purpose
        //TODO integrate pup dialogue box to add category







        FrameLayout expenses=(FrameLayout)findViewById(R.id.expenses);
        expenses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               Intent intent=new Intent(MainActivity.this,ExpensesActivity.class);
             startActivity(intent);
            }
        });

        FrameLayout income=(FrameLayout)findViewById(R.id.income);
        income.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Intent intent=new Intent(MainActivity.this,IncomeActivity.class);
             startActivity(intent);
            }
        });

        FrameLayout categories=(FrameLayout)findViewById(R.id.categories);
        categories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Intent intent=new Intent(MainActivity.this,CategoriesActivity.class);
               startActivity(intent);
            }
        });

        FrameLayout f_expenses=(FrameLayout)findViewById(R.id.f_expenses);
        f_expenses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Intent intent=new Intent(MainActivity.this,FutureExpensesActivity.class);
               startActivity(intent);
            }
        });
        FrameLayout limits=(FrameLayout)findViewById(R.id.limits);
        limits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,LimitsActivity.class);
              startActivity(intent);
            }
        });
        FrameLayout reports=(FrameLayout)findViewById(R.id.reports);
        reports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,ReportsActivity.class);
              startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.settings:
                Intent intent=new Intent(MainActivity.this,SettingsActivity.class);
                startActivity(intent);


                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
