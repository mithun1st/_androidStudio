package com.example.spinnerarrayadapterbaseadapterprogressbarfullscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner sp1,sp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp1=findViewById(R.id.sp1);
        sp2=findViewById(R.id.sp2);

        String[] lan= getResources().getStringArray(R.array.language);
        String[] lin=getResources().getStringArray(R.array.linux);
        int[] logo= {R.drawable.mint, R.drawable.ubuntu,R.drawable.opensuse, R.drawable.fedora, R.drawable.debian,
                R.drawable.manjaro, R.drawable.arch, R.drawable.kali, R.drawable.popos, R.drawable.elementary};


        //array adapter spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,R.layout.array_tem,R.id.tv,lan);
        sp1.setAdapter(adapter);

        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, sp1.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //base adapter spinner
        MyAdapter myAdapter=new MyAdapter(MainActivity.this, lin, logo);
        sp2.setAdapter(myAdapter);

        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, lin[position],Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}