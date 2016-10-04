package com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddExpense;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by aashi on 9/28/2016.
 */
public class DatabaseHandlerExpense extends SQLiteOpenHelper {
    // Database Name
    private static final String DATABASE_NAME = "expenseManager";
    private static final int DATABASE_VERSION = 1;
    // Category table name
    private static final String TABLE_CONTACTS = "category";
    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_AMOUNT = "amount";
    private static final String KEY_Description = "description";
    private static final String KEY_Date = "date";
    private static final String KEY_image = "image";


    public DatabaseHandlerExpense(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_CATEGORY_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_AMOUNT + " Number,"
                + KEY_Description + " TEXT" + KEY_Date + " TEXT" + KEY_image + " TEXT" + ")";
        sqLiteDatabase.execSQL(CREATE_CATEGORY_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

        // Create tables again
        onCreate(sqLiteDatabase);
    }

    public void addExpense(AddExpenseDataModel expense, String tableName) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_AMOUNT, expense.getAmount()); // Contact Name
        values.put(KEY_Description, expense.getDescription());
        values.put(KEY_Date,expense.getDate());
        values.put(KEY_image,expense.getImage());
        // Contact Phone

        // Inserting Row
        db.insert(tableName, null, values);
        db.close(); // Closing database connection
    }
    public ArrayList<AddExpenseDataModel> getAllExpenses(String table) {
        ArrayList<AddExpenseDataModel> expenseList = new ArrayList<AddExpenseDataModel>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                AddExpenseDataModel expense = new AddExpenseDataModel();
                expense.setId(cursor.getString(0));
                expense.setDescription(cursor.getString(1));
                expense.setAmount(Integer.valueOf( cursor.getString(2)));
                // Adding contact to list
                expenseList.add(expense);
            } while (cursor.moveToNext());
        }

        // return contact list
        return expenseList;
    }
}
