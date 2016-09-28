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

import com.example.tayyaba.incomeexpenses.ExpensesViewPager.FragmentAdapterExp;
import com.example.tayyaba.incomeexpenses.LimitsViewPager.FragmentAdapterLimits;
import com.example.tayyaba.incomeexpenses.MainActivity;
import com.example.tayyaba.incomeexpenses.R;

public class LimitsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_limits);
        Toolbar limToolbar=(Toolbar)findViewById(R.id.toolbar_limits);
        setSupportActionBar(limToolbar);
        limToolbar.setNavigationIcon(R.drawable.ic_arrow_right_white_24dp);
        limToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LimitsActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        final ViewPager viewPagerLimits = (ViewPager) findViewById(R.id.viewpagerLimits);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout_limits);
        tabLayout.addTab(tabLayout.newTab().setText("Limits This Month"));
        tabLayout.addTab(tabLayout.newTab().setText("Defined Limits"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final FragmentAdapterLimits adapter = new FragmentAdapterLimits
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPagerLimits.setAdapter(adapter);
        viewPagerLimits.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPagerLimits.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


 //  @Override
 //  public boolean onCreateOptionsMenu(Menu menu) {
 //      getMenuInflater().inflate(R.menu.add_option, menu);
 //      return true;
 //  }

 //  @Override
 //  public boolean onOptionsItemSelected(MenuItem item)
 //  {
 //      switch (item.getItemId())
 //      {
 //          case R.id.search:
 //              //your code here
 //              return true;
 //          default:
 //              return super.onOptionsItemSelected(item);
 //      }
 //  }
}
