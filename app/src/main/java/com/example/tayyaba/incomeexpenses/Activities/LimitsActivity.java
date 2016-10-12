package com.example.tayyaba.incomeexpenses.Activities;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tayyaba.incomeexpenses.LimitsViewPager.FragmentAdapterLimits;
import com.example.tayyaba.incomeexpenses.MainActivity;
import com.example.tayyaba.incomeexpenses.R;
import com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddCategory.CategoryDataModel;
import com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddCategory.DatabaseHandler;
import com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddLimits.DatabaseHandlerLimits;
import com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddLimits.LimitDataModel;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.ArrayList;
import java.util.Calendar;

public class LimitsActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    TextView fromDate;
    TextView toDate;
    Boolean flag ;
    String dateFrom;
    String dateTo;
    String selectedCategory;
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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_option, menu);
        return true;
    }

 //  @Override
 //  public boolean onCreateOptionsMenu(Menu menu) {
 //      getMenuInflater().inflate(R.menu.add_option, menu);
 //      return true;
 //  }

   @Override
   public boolean onOptionsItemSelected(MenuItem item)
   {
       switch (item.getItemId())
       {
           case R.id.add:
               DatabaseHandler handler = new DatabaseHandler(getApplicationContext());
               ArrayList<CategoryDataModel> listofcat = new ArrayList<>();
               listofcat = handler.listofCategories();


               if(listofcat.isEmpty())
               {
                   Toast.makeText(getApplicationContext(),"Please add category first",Toast.LENGTH_LONG).show();
                   Intent intent = new Intent(LimitsActivity.this,CategoriesActivity.class);
                   startActivity(intent);
               }
               else
               {
                   ArrayList<String> categories = new ArrayList<>();

                   for (CategoryDataModel model : listofcat)
                   {
                       categories.add(model.getCategoryName());

                   }
                   final Dialog dialog = new Dialog(this);
                   dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                   dialog.setContentView(R.layout.dialog_add_limits);
                   dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                   final EditText amount =    (EditText) dialog.findViewById(R.id.amount_limits);
                   ImageView saveData = (ImageView) dialog.findViewById(R.id.saveDialogue);
                   MaterialSpinner spinnerCat = (MaterialSpinner) dialog.findViewById(R.id.spinner_cat_limits);

                   fromDate = (TextView
                           ) dialog.findViewById(R.id.fromdate);
                   fromDate.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View view) {
                           Calendar now = Calendar.getInstance();
                           DatePickerDialog dpd = DatePickerDialog.newInstance(
                                   LimitsActivity.this,
                                   now.get(Calendar.YEAR),
                                   now.get(Calendar.MONTH),
                                   now.get(Calendar.DAY_OF_MONTH)
                           );

                           dpd.show(getFragmentManager(), "Datepickerdialog");
                           flag = true;

                       }
                   });

                   toDate = (TextView
                           ) dialog.findViewById(R.id.todate);
                   toDate.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View view) {
                           Calendar now = Calendar.getInstance();
                           DatePickerDialog dpd = DatePickerDialog.newInstance(
                                   LimitsActivity.this,
                                   now.get(Calendar.YEAR),
                                   now.get(Calendar.MONTH),
                                   now.get(Calendar.DAY_OF_MONTH)
                           );

                           dpd.show(getFragmentManager(), "Datepickerdialog");

                            flag= false;

                       }
                   });
                    spinnerCat.setItems(categories);
                   selectedCategory = categories.get(0);
                   spinnerCat.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

                       @Override
                       public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                           selectedCategory = item;
                           Snackbar.make(view, "Clicked " + item, Snackbar.LENGTH_LONG).show();
                       }
                   });



                   saveData.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View view) {
                           if(!selectedCategory.isEmpty() || !dateTo.isEmpty() || !dateFrom.isEmpty() || !amount.getText().toString().isEmpty())
                           {
                               //save 0.
                               // to database
                               DatabaseHandlerLimits db = new DatabaseHandlerLimits(getApplicationContext());
                               db.addLimit(new LimitDataModel(selectedCategory,Integer.valueOf( amount.getText().toString()),dateTo,dateFrom));
                               Toast.makeText(getApplicationContext(), "Data saved", Toast.LENGTH_SHORT).show();


                           }
                           else
                           {
                               Toast.makeText(getApplicationContext(), "Please complete the missing data", Toast.LENGTH_SHORT).show();
                           }
                       }
                   });



                   dialog.show();

               }

               //your code here
               return true;
           default:
               return super.onOptionsItemSelected(item);
       }
   }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth)
    {
        if(flag)
        {
            String string = dayOfMonth + "-" + monthOfYear + "-" + year;
            //from date
            dateFrom = string;
        }
        else
        {
            // todate
            String string = dayOfMonth + "-" + monthOfYear + "-" + year;
            //from date
            dateTo = string;
        }


    }
}
