package com.example.tayyaba.incomeexpenses.Activities;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.tayyaba.incomeexpenses.MainActivity;
import com.example.tayyaba.incomeexpenses.R;

public class CategoriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        Toolbar catToolbar=(Toolbar)findViewById(R.id.toolbar_cat);
        setSupportActionBar(catToolbar);
        catToolbar.setNavigationIcon(R.drawable.ic_arrow_right_white_24dp);
        catToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CategoriesActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
