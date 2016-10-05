package com.example.tayyaba.incomeexpenses.Activities;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.example.tayyaba.incomeexpenses.CategoriesViewPager.FragmentAdapterCat;
import com.example.tayyaba.incomeexpenses.ExpensesViewPager.FragmentAdapterExp;
import com.example.tayyaba.incomeexpenses.MainActivity;
import com.example.tayyaba.incomeexpenses.R;
import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.OnColorSelectedListener;
import com.flask.colorpicker.builder.ColorPickerClickListener;
import com.flask.colorpicker.builder.ColorPickerDialogBuilder;

import static com.example.tayyaba.incomeexpenses.ExpensesViewPager.RecyclerView_ByCategory_Expenses.AdapterByCategory_Expenses.context;

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


        final ViewPager viewPagerExpenses = (ViewPager) findViewById(R.id.viewpagerCategories);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout_categories);
        tabLayout.addTab(tabLayout.newTab().setText("Income"));
        tabLayout.addTab(tabLayout.newTab().setText("Expenses"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final FragmentAdapterCat adapter = new FragmentAdapterCat
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
                dialog.setContentView(R.layout.dialog_add_category);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                final Button pickColor=(Button)dialog.findViewById(R.id.bg_clr_button);
                pickColor.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ColorPickerDialogBuilder
                                .with(dialog.getContext())
                                .setTitle("Choose color")
                                .initialColor(getResources().getColor(R.color.colorPrimary))
                                .wheelType(ColorPickerView.WHEEL_TYPE.FLOWER)
                                .density(12)
                                .setOnColorSelectedListener(new OnColorSelectedListener() {
                                    @Override
                                    public void onColorSelected(int selectedColor) {
                                      //  toast("onColorSelected: 0x" + Integer.toHexString(selectedColor));
                                    }
                                })
                                .setPositiveButton("ok", new ColorPickerClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int selectedColor, Integer[] allColors) {
                                        pickColor.setBackgroundColor(selectedColor);
                                    }
                                })
                                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                    }
                                })
                                .build()
                                .show();
                    }
                });

                dialog.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

