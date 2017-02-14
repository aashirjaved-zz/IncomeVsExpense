package com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddIncome;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddExpense.AddExpenseDataModel;

import java.util.ArrayList;

/**
 * Created by aashi on 10/7/2016.
 */

public class DataBaseHandlerIncome extends SQLiteOpenHelper {

    // Database Name
    private static final String DATABASE_NAME = "incomeManager";
    private static final int DATABASE_VERSION = 1;
    // Category table name
    private static final String TABLE_INCOME = "income";
    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_AMOUNT = "amount";
    private static final String KEY_Description = "description";
    private static final String KEY_Date = "date";
    private static final String KEY_image = "image";
    private static final String KEY_category = "category";











    public DataBaseHandlerIncome(Context context ){
        super(context, TABLE_INCOME, null, DATABASE_VERSION);
    }

    public DataBaseHandlerIncome(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_CATEGORY_TABLE = "CREATE TABLE " + TABLE_INCOME + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"+ KEY_Description + " TEXT," + KEY_AMOUNT + " Number,"
                + KEY_Date + " TEXT," + KEY_image + " TEXT"  +  ")";
        sqLiteDatabase.execSQL(CREATE_CATEGORY_TABLE);
        Log.v("Sqlite","Oncreate Called");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_INCOME);

        // Create tables again
        onCreate(sqLiteDatabase);
    }
    public void addIncome(AddExpenseDataModel expense) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_AMOUNT, expense.getAmount()); // Contact Name
        values.put(KEY_Description, expense.getDescription());
        values.put(KEY_Date,expense.getDate());
        values.put(KEY_image,expense.getCategory());
        //values.put(KEY_category,expense.getCategory());
        // Contact Phone

        // Inserting Row
        db.insert(TABLE_INCOME, null, values);
        db.close(); // Closing database connection
    }
    public ArrayList<AddExpenseDataModel> getAllincome() {
        ArrayList<AddExpenseDataModel> expenseList = new ArrayList<AddExpenseDataModel>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_INCOME;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                AddExpenseDataModel expense = new AddExpenseDataModel();
                expense.setAmount(   Integer.valueOf(cursor.getString(2))  );
                expense.setDescription(cursor.getString(1));
                expense.setCategory( cursor.getString(4));
                expense.setDate(cursor.getString(3));
                // Adding contact to list
                expenseList.add(expense);
            } while (cursor.moveToNext());
        }

        // return contact list
        return expenseList;
    }
}
