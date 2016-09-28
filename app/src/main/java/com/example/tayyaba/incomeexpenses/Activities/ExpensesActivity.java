package com.example.tayyaba.incomeexpenses.Activities;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.tayyaba.incomeexpenses.ExpensesViewPager.FragmentAdapterExp;
import com.example.tayyaba.incomeexpenses.MainActivity;
import com.example.tayyaba.incomeexpenses.R;

public class ExpensesActivity extends AppCompatActivity {

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
            case R.id.search:
                //your code here
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
