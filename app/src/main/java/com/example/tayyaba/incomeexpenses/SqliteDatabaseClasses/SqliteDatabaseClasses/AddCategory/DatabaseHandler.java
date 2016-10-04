package com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddCategory;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by aashi on 9/28/2016.
 */

public class DatabaseHandler extends SQLiteOpenHelper {
    // Database Name
    private static final String DATABASE_NAME = "expenseManager";
    private static final int DATABASE_VERSION = 1;
    // Category table name
    private static final String TABLE_CATEGORYLIST = "categorylist";
    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_Categoryname = "name";
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_CATEGORY_TABLE = "CREATE TABLE " + TABLE_CATEGORYLIST + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_Categoryname + " TEXT" + ")";
        sqLiteDatabase.execSQL(CREATE_CATEGORY_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_CATEGORYLIST);

        // Create tables again
        onCreate(sqLiteDatabase);
    }
     public void addCategory(String categoryName) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_Categoryname, categoryName); // Category Name


        // Inserting Row
        db.insert(TABLE_CATEGORYLIST, null, values);
        db.close(); // Closing database connection
    }
    public ArrayList<String> listofCategories()
    {
        ArrayList<String> listofCategories = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_CATEGORYLIST;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {

                // Adding contact to list
                listofCategories.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }

        // return contact list
        return listofCategories;
    }


}
