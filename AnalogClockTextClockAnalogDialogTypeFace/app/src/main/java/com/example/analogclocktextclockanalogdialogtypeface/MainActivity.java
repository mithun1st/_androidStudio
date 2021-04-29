package com.example.analogclocktextclockanalogdialogtypeface;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private AnalogClock ac;
    private TextClock tc;
    private TextView tv;
    private Button b;
    private Typeface tf;

    private AlertDialog.Builder adb;
    private AlertDialog ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ac=findViewById(R.id.ac);
        tc=findViewById(R.id.tc);
        tv=findViewById(R.id.tv4);
        b=findViewById(R.id.b);

        //AnalogClock
        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Analog Clock",Toast.LENGTH_SHORT).show();
            }
        });

        //TextClock
        tc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Text Clock",Toast.LENGTH_SHORT).show();
            }
        });

        //Typeface
        tf= Typeface.createFromAsset(getAssets(),"font/KaushanScript.otf");
        tv.setTypeface(tf);

        b.setOnClickListener(MainActivity.this);
    }

    @Override
    public void onClick(View v) {
        //alert Dialog
        adb=new AlertDialog.Builder(MainActivity.this);

        adb.setCancelable(false);

        adb.setIcon(R.drawable.clock);
        adb.setTitle("Exit Program");
        adb.setMessage("Do U Want To Close This?");

        adb.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        adb.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //dialog.dismiss();
                Toast.makeText(MainActivity.this,"Clicked No", Toast.LENGTH_SHORT).show();
            }
        });

        adb.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        //assign alert dialog
        ad=adb.create();
        ad.show();
    }
}