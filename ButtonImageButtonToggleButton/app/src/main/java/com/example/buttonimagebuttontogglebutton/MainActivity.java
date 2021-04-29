package com.example.buttonimagebuttontogglebutton;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //declare variable
    Button bv1,bv3;
    ImageButton bv2;
    TextView tv1;
    ToggleButton tb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast t = Toast.makeText(this,"Mahadi Hassan MITHUN",Toast.LENGTH_LONG);
        t.setGravity(Gravity.CENTER,-100,200);

        //assign view into variable
        tv1=findViewById(R.id.t1);
        bv1=findViewById(R.id.b1);
        bv2=findViewById(R.id.b2);
        bv3=findViewById(R.id.b3);
        tb=findViewById(R.id.tb);

        //toggleButton
        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                tv1.setText(tb.getText());
            }
        });

        //button2- individual method of button
        bv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv1.setText("Own Listener Method");

                t.show();

                Log.d("tag1","working");
            }
        });

        //button1- class listener "implements+onClick()" (1/2);
        bv1.setOnClickListener(this);
    }

    //button1- class listener "implements+onClick()" (2/2);
    @Override
    public void onClick(View view) {
        tv1.setText("Class Implements Call");
        Toast.makeText(this,"implements View.onClickListener", Toast.LENGTH_SHORT).show();
    }


    //button3- call from xml file (android:onClick="fnc")
    public void fnc(View v){
        if(v.getId()==R.id.b3) {
            tv1.setText("Call From XML");
            Toast.makeText(this, "android:onClick=\"fnc\"", Toast.LENGTH_SHORT).show();
        }
    }

}