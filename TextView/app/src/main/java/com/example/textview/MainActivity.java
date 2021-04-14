package com.example.textview;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView var1,var2;
    private TextView var3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        var1 = findViewById(R.id.tv1);
        var1.setText(R.string.fName);
        var1.setTextSize(40);

        var2 = findViewById(R.id.tv2);
        var2.setText("mh Mithun");


    }
}