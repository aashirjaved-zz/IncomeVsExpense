package com.example.tayyaba.incomeexpenses.Activities;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.tayyaba.incomeexpenses.IncomeViewPager.FragmentAdapterInc;
import com.example.tayyaba.incomeexpenses.MainActivity;
import com.example.tayyaba.incomeexpenses.R;

public class IncomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);
        Toolbar incToolbar=(Toolbar)findViewById(R.id.toolbar_inc);
        setSupportActionBar(incToolbar);
        incToolbar.setNavigationIcon(R.drawable.ic_arrow_right_white_24dp);
        incToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(IncomeActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        final ViewPager viewPagerIncome = (ViewPager) findViewById(R.id.viewpagerIncome);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout_income);
        tabLayout.addTab(tabLayout.newTab().setText("By Category"));
        tabLayout.addTab(tabLayout.newTab().setText("By Day"));
        tabLayout.addTab(tabLayout.newTab().setText("Details"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final FragmentAdapterInc adapter = new FragmentAdapterInc
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPagerIncome.setAdapter(adapter);
        viewPagerIncome.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPagerIncome.setCurrentItem(tab.getPosition());
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
