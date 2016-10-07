package com.example.tayyaba.incomeexpenses.Activities;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

import com.example.tayyaba.incomeexpenses.MainActivity;
import com.example.tayyaba.incomeexpenses.R;
import com.example.tayyaba.incomeexpenses.RecyclerView_FutureExpenses.Adapter_FutureExpenses;

public class FutureExpensesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_future_expenses);
        Toolbar fexToolbar=(Toolbar)findViewById(R.id.toolbar_f_exp);
        setSupportActionBar(fexToolbar);
        fexToolbar.setNavigationIcon(R.drawable.ic_arrow_right_white_24dp);
        fexToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(FutureExpensesActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        //TODO
        //future expenses ka recyclerview

        RecyclerView recyclerView_fex=(RecyclerView)findViewById(R.id.recyclerView_f_expenses);
        Adapter_FutureExpenses adapter_futureExpenses=new Adapter_FutureExpenses(getApplicationContext());
        recyclerView_fex.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView_fex.setAdapter(adapter_futureExpenses);
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
                dialog.setContentView(R.layout.dialog_addnew_f_exp);

                //TODO
                //initialize dialog k components and do all the backend stuff for adding
                //new future expense from dialog here

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
