package com.example.tayyaba.incomeexpenses.Activities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tayyaba.incomeexpenses.IncomeViewPager.FragmentAdapterInc;
import com.example.tayyaba.incomeexpenses.MainActivity;
import com.example.tayyaba.incomeexpenses.R;
import com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddCategory.CategoryDataModel;
import com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddCategory.DatabaseHandler;
import com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddExpense.AddExpenseDataModel;
import com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddIncome.DataBaseHandlerIncome;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class IncomeActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    public static String encodedimage;
    String selectedCategory = "";
    String selectedAccount = "";
    Integer selectedAmount = 0;
    String descriptionSaved = "";
    String stringDate = "";
    Date date;
    String totalamount = "";
    Integer total = 0;
    TextView totalAmounttoshow;
    TextView pickDate;
    ImageView showImage;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);
        totalAmounttoshow = (TextView) findViewById(R.id.totalincome);


        //Today's Date
        Calendar c = Calendar.getInstance();
        System.out.println("Current time => " + c.getTime());

        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = df.format(c.getTime());
        stringDate = formattedDate;


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

        //calculating total income
        DataBaseHandlerIncome db = new DataBaseHandlerIncome(getApplicationContext());
        ArrayList<AddExpenseDataModel> data = db.getAllincome();
        for(AddExpenseDataModel model : data)
        {
            total = total+model.getAmount();
        }
        totalamount=total.toString();
        totalAmounttoshow.setText(totalamount);

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


                DatabaseHandler db = new DatabaseHandler(getApplicationContext());
                ArrayList<CategoryDataModel> listofCategories = db.listofCategories();
                ArrayList<String> listofcat = new ArrayList<>();

                for (CategoryDataModel model : listofCategories) {
                    if(model.getCategoryType().contains("income"))
                        listofcat.add(model.getCategoryName());
                }
                if(listofcat.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Please add category first",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(IncomeActivity.this,CategoriesActivity.class);
                    startActivity(intent);
                }
                else {


                    final Dialog dialog = new Dialog(this);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.dialog_addnew_exp);
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    TextView heading = (TextView) dialog.findViewById(R.id.heading_txt);
                    heading.setText("Add Income");

                    MaterialSpinner spinnerCat = (MaterialSpinner) dialog.findViewById(R.id.spinner_cat_exp);
                    ImageView saveData = (ImageView) dialog.findViewById(R.id.saveDialogue);
                    final EditText amount = (EditText) dialog.findViewById(R.id.amount_input_exp);
                    final EditText description = (EditText) dialog.findViewById(R.id.descriptionAdd);

                    //TODO
                    //expenses wala kaam yahan pe bhi sara except categories income wali uthaani han

                    spinnerCat.setItems(listofcat);
                    selectedCategory = listofcat.get(0);


                    spinnerCat.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

                        @Override
                        public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                            selectedCategory = item;
                            Snackbar.make(view, "Clicked " + item, Snackbar.LENGTH_LONG).show();
                        }
                    });

                    pickDate = (TextView
                            ) dialog.findViewById(R.id.pickDate);
                    pickDate.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Calendar now = Calendar.getInstance();
                            DatePickerDialog dpd = DatePickerDialog.newInstance(
                                    IncomeActivity.this,
                                    now.get(Calendar.YEAR),
                                    now.get(Calendar.MONTH),
                                    now.get(Calendar.DAY_OF_MONTH)
                            );

                            dpd.show(getFragmentManager(), "Datepickerdialog");

                        }
                    });


                    saveData.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            selectedAmount = Integer.valueOf(amount.getText().toString());
                            descriptionSaved = description.getText().toString();
                            if (!selectedAccount.isEmpty() || !descriptionSaved.isEmpty() || !selectedCategory.isEmpty()) {
                                //TODO save date to database

                                AddExpenseDataModel model = new AddExpenseDataModel(selectedAmount, descriptionSaved, stringDate, "image", selectedCategory);
                                DataBaseHandlerIncome db = new DataBaseHandlerIncome(getApplicationContext());
                                db.addIncome(model);
                                Toast.makeText(getApplicationContext(), "Added Successfuly", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();

                            } else {
                                Toast.makeText(getApplicationContext(), "Important fields are empty", Toast.LENGTH_SHORT).show();

                            }

                        }
                    });
                    MaterialSpinner spinnerAcc = (MaterialSpinner) dialog.findViewById(R.id.spinner_accnt_exp);
                    spinnerAcc.setItems("Account 1");


//Image showing
                    fab = (FloatingActionButton) dialog.findViewById(R.id.choose_img_btn_exp);
                    showImage = (ImageView) dialog.findViewById(R.id.show_img_view_exp);
                    fab.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            final CharSequence[] options = {"Take Photo", "Choose from Gallery", "Cancel"};

                            AlertDialog.Builder builder = new AlertDialog.Builder(IncomeActivity.this);
                            builder.setTitle("Add Photo!");
                            builder.setItems(options, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int item) {
                                    if (options[item].equals("Take Photo")) {
                                        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                        File f = new File(android.os.Environment.getExternalStorageDirectory(), "temp.jpg");
                                        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
                                        startActivityForResult(intent, 1);
                                    } else if (options[item].equals("Choose from Gallery")) {
                                        Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                                        startActivityForResult(intent, 2);

                                    } else if (options[item].equals("Cancel")) {
                                        dialog.dismiss();
                                    }
                                }
                            });
                            builder.show();


                        }
                    });


                    dialog.show();
                    return true;
                }
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {

        String string = dayOfMonth + "-" + monthOfYear + "-" + year;
        stringDate = string;
        date = new Date(year, monthOfYear, dayOfMonth);
        pickDate.setText(string);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == 1) {
                File f = new File(Environment.getExternalStorageDirectory().toString());
                for (File temp : f.listFiles()) {
                    if (temp.getName().equals("temp.jpg")) {
                        f = temp;
                        break;
                    }
                }
                try {
                    Bitmap bitmap;
                    BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();

                    bitmap = BitmapFactory.decodeFile(f.getAbsolutePath(),
                            bitmapOptions);

                    showImage.setImageBitmap(bitmap);

                    //   encodedimage = BitMapToString(bitmap).replace("\\s", "");

                    Log.v("EncodedImage", encodedimage);
                    String path = android.os.Environment
                            .getExternalStorageDirectory()
                            + File.separator
                            + "Phoenix" + File.separator + "default";
                    f.delete();
                    OutputStream outFile = null;
                    File file = new File(path, String.valueOf(System.currentTimeMillis()) + ".jpg");
                    try {
                        outFile = new FileOutputStream(file);
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 85, outFile);
                        outFile.flush();
                        outFile.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (requestCode == 2) {

                Uri selectedImage = data.getData();
                String[] filePath = {MediaStore.Images.Media.DATA};
                Cursor c = getContentResolver().query(selectedImage, filePath, null, null, null);
                c.moveToFirst();
                int columnIndex = c.getColumnIndex(filePath[0]);
                String picturePath = c.getString(columnIndex);
                c.close();
                Bitmap thumbnail = (BitmapFactory.decodeFile(picturePath));
                Log.w("path of image from gall", picturePath + "");
                showImage.setImageBitmap(thumbnail);
                // encodedimage = BitMapToString(thumbnail).replace("\\s", "");
            }
        }
    }
}
