package com.example.gridviewarrayadapterbaseadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private GridView gv1,gv2;
    private String[] osPl,linux;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gv1=findViewById(R.id.gv1);
        gv2=findViewById(R.id.gv2);

        osPl=getResources().getStringArray(R.array.osPl);

        //Grid View 1
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this,R.layout.array_adp_tem,R.id.tv,osPl);
        gv1.setAdapter(arrayAdapter);

        gv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,osPl[position],Toast.LENGTH_SHORT).show();
            }
        });


        //Grid View 2
        linux=getResources().getStringArray(R.array.pl);
        int[] logo = {R.drawable.mint, R.drawable.ubuntu, R.drawable.opensuse, R.drawable.fedora, R.drawable.debian,
                R.drawable.manjaro, R.drawable.arch, R.drawable.kali, R.drawable.popos, R.drawable.elementary};

        MyGrid baseAdapter = new MyGrid(MainActivity.this,linux,logo);
        gv2.setAdapter(baseAdapter);

        gv2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, linux[position],Toast.LENGTH_SHORT).show();
            }
        });
    }
}









