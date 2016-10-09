package com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddCategory;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by aashi on 9/28/2016.
 */

public class DatabaseHandler extends SQLiteOpenHelper {
    // Database Name
    private static final String DATABASE_NAME = "expenseManager";
    private static final int DATABASE_VERSION = 2;
    // Category table name
    private static final String TABLE_CATEGORYLIST = "categorylist";
    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_Categoryname = "name";
    private static final String KEY_Categortype = "type";
    private static final String KEY_Categorvalue = "value";
    private static final String KEY_Categornature = "nature";
    private static final String KEY_Categorycolor= "color";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_CATEGORY_TABLE = "CREATE TABLE " + TABLE_CATEGORYLIST + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                +  KEY_Categoryname + " TEXT," +KEY_Categortype + " TEXT,"+ KEY_Categornature + " TEXT," + KEY_Categorycolor + " INTEGER,"+  KEY_Categorvalue + " TEXT" + ")";
        sqLiteDatabase.execSQL(CREATE_CATEGORY_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_CATEGORYLIST);

        // Create tables again
        onCreate(sqLiteDatabase);
    }
     public void addCategory(CategoryDataModel model) {
        SQLiteDatabase db = this.getWritableDatabase();
Log.v("SavingDatabase",model.getCategoryName()+"-"+model.getCategoryValue());
        ContentValues values = new ContentValues();
        values.put(KEY_Categoryname, model.getCategoryName()); // Category Name
        values.put(KEY_Categorvalue, model.getCategoryValue()); // Category Name
        values.put(KEY_Categortype, model.getCategoryType()); // Category Name
        values.put(KEY_Categornature, model.getCategoryNature());
        values.put(KEY_Categorycolor, model.getCategoryColor());

         // Category Name


        // Inserting Row
        db.insert(TABLE_CATEGORYLIST, null, values);
        db.close(); // Closing database connection
    }
    public ArrayList<CategoryDataModel> listofCategories()
    {
        ArrayList<CategoryDataModel> listofCategories = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_CATEGORYLIST;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                CategoryDataModel model = new CategoryDataModel(cursor.getString(1),cursor.getString(5),cursor.getString(2),cursor.getString(3),cursor.getInt(4));

                // Adding contact to list
                listofCategories.add(model);

            } while (cursor.moveToNext());
        }

        // return contact list
        return listofCategories;
    }


}
