package com.example.tayyaba.incomeexpenses.Activities;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.tayyaba.incomeexpenses.R;
import com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddExpense.DatabaseHandlerExpense;

import java.io.File;
import java.io.FileWriter;

import au.com.bytecode.opencsv.CSVWriter;

public class BackupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backup);
        Button saveLocal = (Button) findViewById(R.id.saveLocal);
        Button sendEmail = (Button) findViewById(R.id.sendbyemail);
        Button connectgoogle = (Button) findViewById(R.id.connecttogoogle);
        Button connectdrop = (Button) findViewById(R.id.connecttodrp);

        connectdrop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://dropbox.com/"));
                startActivity(i);
            }
        });
connectgoogle.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent i = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://drive.google.com/"));
        startActivity(i);
    }
});
        saveLocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exportDBExpense();
                exportDBincome();

            }
        });

        sendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"email@example.com"});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "subject here");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "body text");
                File root = Environment.getExternalStorageDirectory();
                String pathToMyAttachedFile = "expenses.csv";
                File file = new File(root, pathToMyAttachedFile);
                if (!file.exists() || !file.canRead()) {
                    return;
                }
                Uri uri = Uri.fromFile(file);
                emailIntent.putExtra(Intent.EXTRA_STREAM, uri);
                startActivity(Intent.createChooser(emailIntent, "Pick an Email provider"));
            }
        });
    }
    public void exportDBExpense() {
        File dbFile = getDatabasePath("expense.db");
        DatabaseHandlerExpense dbhelper = new DatabaseHandlerExpense(getApplicationContext());
        File exportDir = new File(Environment.getExternalStorageDirectory(), "");

        if (!exportDir.exists()) {
            exportDir.mkdirs();
        }
        File file = new File(exportDir, "expenses.csv");

        try {
            file.createNewFile();
            CSVWriter csvWrite = new CSVWriter(new FileWriter(file));
            SQLiteDatabase db = dbhelper.getReadableDatabase();
            Cursor curCSV = db.rawQuery("SELECT * FROM expense", null);
            csvWrite.writeNext(curCSV.getColumnNames());
            while (curCSV.moveToNext()) {
                //Which column you want to exprort
                String arrStr[] = {curCSV.getString(0), curCSV.getString(1), curCSV.getString(2),curCSV.getString(3),curCSV.getString(4)};
                csvWrite.writeNext(arrStr);
            }
            csvWrite.close();
            curCSV.close();
            Toast.makeText(getApplicationContext(),"CSV file saved with the name expenses.cv",Toast.LENGTH_LONG).show();
        } catch (Exception sqlEx) {
            Log.e("MainActivity", sqlEx.getMessage(), sqlEx);
        }
    }
    public void exportDBincome() {
        File dbFile = getDatabasePath("expense.db");
        DatabaseHandlerExpense dbhelper = new DatabaseHandlerExpense(getApplicationContext());
        File exportDir = new File(Environment.getExternalStorageDirectory(), "");

        if (!exportDir.exists()) {
            exportDir.mkdirs();
        }
        File file = new File(exportDir, "income.csv");

        try {
            file.createNewFile();
            CSVWriter csvWrite = new CSVWriter(new FileWriter(file));
            SQLiteDatabase db = dbhelper.getReadableDatabase();
            Cursor curCSV = db.rawQuery("SELECT * FROM income", null);
            csvWrite.writeNext(curCSV.getColumnNames());
            while (curCSV.moveToNext()) {
                //Which column you want to exprort
                String arrStr[] = {curCSV.getString(0), curCSV.getString(1), curCSV.getString(2), curCSV.getString(3), curCSV.getString(4)};
                csvWrite.writeNext(arrStr);
            }
            csvWrite.close();
            curCSV.close();
            Toast.makeText(getApplicationContext(),"CSV file saved with the name income.cv",Toast.LENGTH_LONG).show();
        } catch (Exception sqlEx) {
            Log.e("MainActivity", sqlEx.getMessage(), sqlEx);
        }
    }
}
