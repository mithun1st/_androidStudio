package com.example.toast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button bv1,bv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bv1=findViewById(R.id.b1);
        bv2=findViewById(R.id.b2);

        bv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"MITHUN",Toast.LENGTH_SHORT).show();
            }
        });

        bv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //View tv=getLayoutInflater().inflate(R.layout.toast_layout,findViewById(R.id.tl));
                LayoutInflater lf = getLayoutInflater();
                View vv = lf.inflate(R.layout.toast_layout,findViewById(R.id.tl));

                TextView tv=vv.findViewById(R.id.tv);
                tv.setText("MH Mithun");

                Toast t=new Toast(MainActivity.this);
                t.setDuration(Toast.LENGTH_LONG);
                t.setGravity(Gravity.CENTER,0,-150);
                t.setView(vv);

                t.show();
            }
        });
    }
}