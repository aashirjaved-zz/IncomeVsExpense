package com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddFutureExpense;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by aashi on 10/9/2016.
 */

public class DatabaseHandlerFutureExpense extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "expenseManager";
    private static final int DATABASE_VERSION = 1;
    // Category table name
    private static final String TABLE_EXPENSE = "futureexpense";
    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_AMOUNT = "amount";
    private static final String KEY_Description = "description";
    private static final String KEY_Date = "date";
//    private static final String KEY_image = "image";
    private static final String KEY_category = "category";
    private static final String Key_type = "type";






    public DatabaseHandlerFutureExpense(Context context) {
        super(context, TABLE_EXPENSE, null, DATABASE_VERSION);
        Log.v("Sqlite","Constructor Called");

    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_CATEGORY_TABLE = "CREATE TABLE " + TABLE_EXPENSE + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"+ KEY_Description + " TEXT," + KEY_AMOUNT + " Number,"
                + KEY_Date + " TEXT," + KEY_category + " TEXT,"  + Key_type + "Text" + ")";
        sqLiteDatabase.execSQL(CREATE_CATEGORY_TABLE);
        Log.v("Sqlite","Oncreate Called");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_EXPENSE);

        // Create tables again
        onCreate(sqLiteDatabase);
    }

    public void addExpense(FutureExpenseDataModel expense) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_AMOUNT, expense.getAmount()); // Contact Name
        values.put(KEY_Description, expense.getDescription());
        values.put(KEY_Date,expense.getDate());
        values.put(KEY_category,expense.getCategory()
        + ","+ expense.getType());
        //values.put(Key_type,expense.getType());
        //values.put(KEY_category,expense.getCategory());
        // Contact Phone

        // Inserting Row
        db.insert(TABLE_EXPENSE, null, values);
        db.close(); // Closing database connection
    }
    public ArrayList<FutureExpenseDataModel> getAllExpenses() {
        ArrayList<FutureExpenseDataModel> expenseList = new ArrayList<FutureExpenseDataModel>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_EXPENSE;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                FutureExpenseDataModel expense = new FutureExpenseDataModel();
                expense.setAmount(   Integer.valueOf(cursor.getString(2))  );
                expense.setDescription(cursor.getString(1));
                expense.setCategory( cursor.getString(4).split(",")[0]);
                expense.setDate(cursor.getString(3));
                expense.setType(cursor.getString(4).split(",")[1]);
                // Adding contact to list
                expenseList.add(expense);
            } while (cursor.moveToNext());
        }

        // return contact list
        return expenseList;
    }
}
