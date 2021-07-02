package com.example.implicitintent_autolink;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button b1,b2,b3,b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        b4=findViewById(R.id.b4);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==b1){
            Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("tel:+8801751001003"));
            startActivity(i);
        }
        if(v==b2){
            Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("mailto: mithun.2121@yahoo.com"));
            startActivity(i);
        }
        if(v==b3){
            Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("geo: 24.343191595372378, 89.3050379678607"));
            startActivity(i);
        }
        if(v==b4){
            Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("http://mithun1st.blogspot.com"));
            startActivity(i);
        }

    }
}