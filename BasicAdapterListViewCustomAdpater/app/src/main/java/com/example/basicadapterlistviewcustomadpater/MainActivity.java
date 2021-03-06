package com.example.basicadapterlistviewcustomadpater;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView iv;
    private TextView tv,tv1;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv=findViewById(R.id.lv);
        iv=findViewById(R.id.iv);
        tv=findViewById(R.id.tv);
        tv1=findViewById(R.id.tv1);

        int[] logo = {R.drawable.mint, R.drawable.ubuntu, R.drawable.opensuse, R.drawable.fedora, R.drawable.debian,
                R.drawable.manjaro, R.drawable.arch, R.drawable.kali, R.drawable.popos, R.drawable.elementary};
        String[] linux= getResources().getStringArray(R.array.linux);

        CustomAdapter1 customBaseAdapter = new CustomAdapter1(MainActivity.this, linux, logo);
        lv.setAdapter(customBaseAdapter);

        System.out.println(customBaseAdapter.getCount());

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, linux[position],Toast.LENGTH_SHORT).show();
            }
        });
    }
}