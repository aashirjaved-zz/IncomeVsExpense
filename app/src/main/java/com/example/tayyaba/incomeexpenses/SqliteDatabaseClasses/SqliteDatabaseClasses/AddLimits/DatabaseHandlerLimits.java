package com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddLimits;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by aashi on 10/11/2016.
 */

public class DatabaseHandlerLimits extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "limits";
    private static final int DATABASE_VERSION = 1;
    // Category table name
    private static final String TABLE_LIMITS = "limitslist";
    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_Categoryname = "name";
    private static final String KEY_Limitamount = "amount";
    private static final String KEY_Limitto = "toDate";
    private static final String KEY_Limitfrom= "fromDate";


    public DatabaseHandlerLimits(Context context) {
        super(context, TABLE_LIMITS, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_CATEGORY_TABLE = "CREATE TABLE " + TABLE_LIMITS + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"+ KEY_Categoryname + " TEXT," + KEY_Limitamount + " INTEGER,"
                + KEY_Limitto + " TEXT," + KEY_Limitfrom + " TEXT"  +  ")";
        sqLiteDatabase.execSQL(CREATE_CATEGORY_TABLE);
        Log.v("Sqlite","Oncreate Called");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addLimit(LimitDataModel model) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_Categoryname, model.getCategoryName()); // Category Name
        values.put(KEY_Limitamount, model.getAmount()); // Category Name
        values.put(KEY_Limitto, model.getTo()); // Category Name
        values.put(KEY_Limitfrom, model.getFrom());

        // Category Name


        // Inserting Row
        db.insert(TABLE_LIMITS, null, values);
        db.close(); // Closing database connection
    }

    public ArrayList<LimitDataModel> listoflimits()
    {
        ArrayList<LimitDataModel> listofCategories = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_LIMITS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                LimitDataModel model = new LimitDataModel(cursor.getString(1), Integer.valueOf(cursor.getString(2)),cursor.getString(3),cursor.getString(4));

                // Adding contact to list
                listofCategories.add(model);

            } while (cursor.moveToNext());
        }

        // return contact list
        return listofCategories;
    }

}
