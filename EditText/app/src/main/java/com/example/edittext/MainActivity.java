package com.example.edittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button bv1;
    EditText etv1,etv2,etv3;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv=findViewById(R.id.tv1);
        bv1=findViewById(R.id.b1);
        etv1=findViewById(R.id.et1);
        etv2=findViewById(R.id.et2);
        etv3=findViewById(R.id.et3);

        tv.setOnClickListener(this);
        bv1.setOnClickListener(this);
        etv1.setOnClickListener(this);
        etv2.setOnClickListener(this);
        etv3.setOnClickListener(this);

        etv1.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);
    }


    /*
    random num between 5 to 7
    x= (max-min)+1;
    y=max;
    num=new Random.nextInt(x)+y;
     */

    public void randomNum(){
        Random r=new Random();
        int num= r.nextInt(3)+5;
        tv.setText(String.valueOf(num));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv1:
                etv1.setText("123");
                etv2.setText("");
                etv3.setText("");
                randomNum();
                break;

            case R.id.b1:
                if(etv1.getText().toString().isEmpty()){
                    etv1.setError("Field is empty");
                    etv1.requestFocus();
                }
                else {
                    tv.setText(etv1.getText()+etv2.getText().toString()+ etv3.getText());
                }
                break;

        }
    }
}