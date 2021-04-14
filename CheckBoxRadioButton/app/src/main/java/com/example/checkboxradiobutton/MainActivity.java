package com.example.checkboxradiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button bv1;
    private TextView tvv1;
    private RadioGroup rgv1;
    private RadioButton rbv1;
    private CheckBox cbv1,cbv2,cbv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assign view
        bv1=findViewById(R.id.b1);
        tvv1=findViewById(R.id.tv1);

        rgv1=findViewById(R.id.rg1);

        rbv1=findViewById(R.id.rb1);

        cbv1=findViewById(R.id.cb1);
        cbv2=findViewById(R.id.cb2);
        cbv3=findViewById(R.id.cb3);

        //set Listener
        bv1.setOnClickListener(MainActivity.this);
    }

    @Override
    public void onClick(View v) {
        StringBuilder sb=new StringBuilder();

        if(cbv1.isChecked()){
            sb.append(cbv1.getText()+" ");
        }
        if(cbv2.isChecked()){
            sb.append(cbv2.getText()+" ");
        }
        if(cbv3.isChecked()){
            sb.append(cbv3.getText()+" ");
        }

        sb.append("\n>");

        int radioButtonId = rgv1.getCheckedRadioButtonId();
        rbv1=findViewById(radioButtonId);
        sb.append(rbv1.getText().toString());

        tvv1.setText(sb.toString());

    }
}