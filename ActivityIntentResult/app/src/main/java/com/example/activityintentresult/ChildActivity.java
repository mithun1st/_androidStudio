package com.example.activityintentresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ChildActivity extends AppCompatActivity {

    private EditText et;
    private Button b;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);

        tv=findViewById(R.id.tv);
        b=findViewById(R.id.b);
        et=findViewById(R.id.et);

        //---received data from MainActivity (1)
        Intent i=getIntent();

        int n=i.getIntExtra("number",0);
        double p=i.getDoubleExtra("piValue",0);
        String s=i.getStringExtra("string1");

        tv.setText(String.valueOf(n)+"\n"+String.valueOf(p)+"\n"+s);


        //---response MainActivity request (2)
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int n=13;
                double p=3.1416;
                String s=et.getText().toString();

                Intent in=new Intent(ChildActivity.this,MainActivity.class);
                in.putExtra("key1",n);
                in.putExtra("key2",p);
                in.putExtra("key3",s);

                setResult(101,in);
                finish();
            }
        });


    }
}