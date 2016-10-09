package com.example.tayyaba.incomeexpenses.Activities;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.tayyaba.incomeexpenses.CategoriesViewPager.FragmentAdapterCat;
import com.example.tayyaba.incomeexpenses.MainActivity;
import com.example.tayyaba.incomeexpenses.R;
import com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddCategory.CategoryDataModel;
import com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddCategory.DatabaseHandler;
import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.OnColorSelectedListener;
import com.flask.colorpicker.builder.ColorPickerClickListener;
import com.flask.colorpicker.builder.ColorPickerDialogBuilder;

import info.hoang8f.android.segmented.SegmentedGroup;

public class CategoriesActivity extends AppCompatActivity {
    Integer colorSelected = R.color.colorAccent;
    String type = "";
    String nature = "";

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
                final EditText categoryname= (EditText) dialog.findViewById(R.id.cat_name_addCat) ;
                final EditText categoryValue= (EditText) dialog.findViewById(R.id.defaultVal_addCat) ;
                SegmentedGroup categorynature= (SegmentedGroup) dialog.findViewById(R.id.segmented2) ;

                final RadioButton constantExpense = (RadioButton) dialog.findViewById(R.id.button21) ;
                RadioButton variableExpense= (RadioButton) dialog.findViewById(R.id.button22) ;
                final RadioButton income= (RadioButton) dialog.findViewById(R.id.income) ;

                final RadioButton expense = (RadioButton) dialog.findViewById(R.id.expense) ;


                ImageView save = (ImageView) dialog.findViewById(R.id.saveDialogue);
                income.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        type = "income";
                        Toast.makeText(getApplicationContext(),"Income selected",Toast.LENGTH_SHORT).show();
                    }
                });
                expense.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        type = "expense";
                        Toast.makeText(getApplicationContext(),"Expense selected",Toast.LENGTH_SHORT).show();

                    }
                });
                constantExpense.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        nature = "constant";
                        Toast.makeText(getApplicationContext(),"constant selected",Toast.LENGTH_SHORT).show();


                    }
                });
                variableExpense.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        nature = "variable";
                        Toast.makeText(getApplicationContext(),"variable selected",Toast.LENGTH_SHORT).show();

                    }
                });

                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (categoryname.getText().toString().isEmpty() || categoryValue.getText().toString().isEmpty()) {
                            Toast.makeText(CategoriesActivity.this, "Please enter category name", Toast.LENGTH_SHORT).show();
                        } else {

                            if(!type.isEmpty())
                            {

                                //do nothing
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(), "Select category type", Toast.LENGTH_SHORT).show();
                                return;

                            }

                            if(!nature.isEmpty())
                            {
                               //do nothing
                            }
                            else
                            {
                                nature = "variable";
                            }
                            Log.v("CategoryDetails",categoryname.getText().toString()+type);
                            CategoryDataModel model = new CategoryDataModel(categoryname.getText().toString(),
                                    categoryValue.getText().toString(),type, nature ,colorSelected


                                    );

                            DatabaseHandler db = new DatabaseHandler(getApplicationContext());
                            db.addCategory(model);
                            Log.v("CategoryData", model.getCategoryName()+"-"+model.getCategoryValue());
                            Toast.makeText(getApplicationContext(),"Category added Successfuly",Toast.LENGTH_LONG).show();


                        }
                    }
                });



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
                                        colorSelected = selectedColor;
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

