package com.example.tayyaba.incomeexpenses.Activities;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tayyaba.incomeexpenses.MainActivity;
import com.example.tayyaba.incomeexpenses.R;
import com.wdullaer.materialdatetimepicker.time.RadialPickerLayout;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.math.BigDecimal;
import java.util.Calendar;

public class SettingsActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {

    TextView showTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar setToolbar=(Toolbar)findViewById(R.id.toolbar_settings);
        setSupportActionBar(setToolbar);
        setToolbar.setNavigationIcon(R.drawable.ic_arrow_right_white_24dp);
        setToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SettingsActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });



       final BigDecimal num=new BigDecimal("31");
        showTime=(TextView)findViewById(R.id.textView_selTime);

        TextView startMonth=(TextView)findViewById(R.id.startDayofMonth_settings);
        startMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(SettingsActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_numberpick);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });


        TextView pickDateFormat=(TextView)findViewById(R.id.dateFormat_settings);
        pickDateFormat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(SettingsActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_dateformat);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                //TODO
                //initialize all the checkboxes and date formats here with onclick listeners
            }
        });

        CheckBox checkBox=(CheckBox)findViewById(R.id.daily_reminderCheckBox_settings);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    Toast.makeText(SettingsActivity.this,"checked!",Toast.LENGTH_LONG).show();
                    Calendar now = Calendar.getInstance();
                    TimePickerDialog tpd = TimePickerDialog.newInstance(
                         SettingsActivity.this,
                            now.get(Calendar.HOUR_OF_DAY),
                            now.get(Calendar.MINUTE),
                            false
                    );

                    tpd.show(getFragmentManager(), "Timepickerdialog");
                }
            }
        });

    }

    @Override
    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute, int second) {

        showTime.setText(hourOfDay+" : "+minute);
    }
}
