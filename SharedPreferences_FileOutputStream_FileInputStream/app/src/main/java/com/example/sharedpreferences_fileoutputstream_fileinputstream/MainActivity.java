package com.example.sharedpreferences_fileoutputstream_fileinputstream;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

    private EditText et,et1,et2,et3;
    private Button save1, load1, save2, load2;

    String str, par;
    int num;
    float flo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et=findViewById(R.id.et);
        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);
        et3=findViewById(R.id.et3);

        save1=findViewById(R.id.b1);
        load1=findViewById(R.id.b2);
        save2=findViewById(R.id.b3);
        load2=findViewById(R.id.b4);


        save1.setOnClickListener(this);
        load1.setOnClickListener(this);
        save2.setOnClickListener(this);
        load2.setOnClickListener(this);



    }

    //SharedPreferences- write
    public void writeSP(String s, int i, Float f){
        SharedPreferences sp = getSharedPreferences("details", Context.MODE_PRIVATE);
        SharedPreferences.Editor spe = sp.edit();

        spe.putString("key1", s);
        spe.putInt("key2", i);
        spe.putFloat("key3",f);

        spe.commit();
    }
    //SharedPreferences- read
    public void readSP(){
        SharedPreferences sp = getSharedPreferences("details", Context.MODE_PRIVATE);

        if(sp.contains("key1") && sp.contains("key2") && sp.contains("key3")){
            String s=sp.getString("key1", "Data Not Found");
            int i=sp.getInt("key2", 1);
            float f=sp.getFloat("key3", (float) 1.1);

            et1.setText(s);
            et2.setText(String.valueOf(i));
            et3.setText(String.valueOf(f));
        }

    }


    //FileOutputStream- write
    public void writeF(String s){
        try{
            FileOutputStream f=openFileOutput("doc", Context.MODE_PRIVATE);

            f.write(s.getBytes());
            f.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //FileInputStream- read
    public void readF(){
        try{
            FileInputStream f=openFileInput("doc");
            InputStreamReader is = new InputStreamReader(f);
            BufferedReader br = new BufferedReader(is);

            String s= new String(br.readLine());
            et.setText(s);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }



    @Override
    public void onClick(View v) {

        if(v==save1){
            str = et1.getText().toString();
            num = Integer.parseInt(et2.getText().toString());
            flo = Float.parseFloat(et3.getText().toString());

            writeSP(str,num,flo);
        }

        else if (v==load1){
            readSP();
        }

        if (v==save2){
            par=et.getText().toString();

            writeF(par);
        }

        else if (v==load2){
            readF();
        }

    }
}