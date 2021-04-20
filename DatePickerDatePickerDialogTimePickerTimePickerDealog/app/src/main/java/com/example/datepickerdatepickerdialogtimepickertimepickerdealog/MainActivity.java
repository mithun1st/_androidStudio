package com.example.datepickerdatepickerdialogtimepickertimepickerdealog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.sql.Time;

public class MainActivity extends AppCompatActivity {
    private Button button1,button2,button3,button4;
    private TextView tv;
    private CheckBox cb;

    private DatePicker datePicker;
    private DatePickerDialog datePickerDialog;

    private TimePicker timePicker;
    private TimePickerDialog timePickerDialog;

    private boolean is24hour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1=findViewById(R.id.bdp);
        button2=findViewById(R.id.bdpd);
        button3=findViewById(R.id.bbtp);
        button4=findViewById(R.id.btpd);

        tv=findViewById(R.id.tv1);
        cb=findViewById(R.id.cb);

        datePicker=findViewById(R.id.dp);
        timePicker=findViewById(R.id.tp);

        //clock24HourFormat
        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                is24hour=cb.isChecked();
            }
        });


        //datePicker
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder sb=new StringBuilder();
                sb.append(datePicker.getDayOfMonth());
                sb.append(" / ");
                sb.append(datePicker.getMonth()+1);
                sb.append(" / ");
                sb.append(datePicker.getYear());

                tv.setText(sb.toString());
            }
        });

        //datePickerDialog
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePicker dp=new DatePicker(MainActivity.this);
                int y=dp.getYear();
                int m=dp.getMonth();
                int d=dp.getDayOfMonth();

                datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(dayOfMonth);
                                sb.append(" - ");
                                sb.append(month+1);
                                sb.append(" - ");
                                sb.append(year);

                                tv.setText(sb.toString());
                            }
                        },y,m,d);
                datePickerDialog.show();
            }
        });

        //timePicker
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder sb=new StringBuilder();
                sb.append(timePicker.getHour());
                sb.append(" : ");
                sb.append(timePicker.getMinute());

                tv.setText(sb.toString());
            }
        });

        //timePickerDialog
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TimePicker tp=new TimePicker(MainActivity.this);

                int min=tp.getMinute();
                int hou=tp.getHour();

                timePickerDialog=new TimePickerDialog(MainActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                String ap="";

                                if(!is24hour){
                                    if(hourOfDay>=12){
                                        ap=" "+ampm.PM.toString();
                                    }
                                    else{
                                        ap=" "+ampm.AM.toString();
                                    }
                                }

                                if(!is24hour && hourOfDay>12){
                                    hourOfDay-=12;
                                }
                                if(hourOfDay==0){
                                    hourOfDay=12;
                                }


                                StringBuilder sp= new StringBuilder();
                                sp.append(hourOfDay);
                                sp.append(" :: ");
                                sp.append(minute);
                                sp.append(ap);

                                tv.setText(sp.toString());
                            }
                        },min,hou,is24hour);
                timePickerDialog.show();
            }
        });
    }

    public enum ampm {
        AM,PM;
    }
}