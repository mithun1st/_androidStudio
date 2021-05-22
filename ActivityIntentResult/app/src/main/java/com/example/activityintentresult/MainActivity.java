package com.example.activityintentresult;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private EditText et;
    private Button b,b1;
    private TextView tv,tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("cycle","on create");

        et=findViewById(R.id.et);
        b=findViewById(R.id.b);
        tv=findViewById(R.id.tv);
        b1=findViewById(R.id.b1);
        tv1=findViewById(R.id.tv1);

        //---send data to ChildActivity (1)
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //data
                int num=13;
                double pi=3.1416;
                String str= et.getText().toString();

                Intent i = new Intent(MainActivity.this,ChildActivity.class);
                i.putExtra("number", num);
                i.putExtra("piValue",pi);
                i.putExtra("string1",str);
                startActivity(i);
            }
        });

        //---request data from ChildActivity (2)
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this, ChildActivity.class);
                startActivityForResult(i,101);
            }
        });
    }
    //if request response
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==101){

            int n= data.getIntExtra("key1",0);
            double p= data.getDoubleExtra("key2",0);
            String str=data.getStringExtra("key3");

            tv1.setText(String.valueOf(n)+"\n"+String.valueOf(p)+"\n"+str);
        }

    }



    //activity life cycle

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("cycle","on start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("cycle","on resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("cycle","on pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("cycle","on stop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("cycle","on restart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("cycle","on destroy");
    }
}