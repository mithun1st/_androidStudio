package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Fragment frg;
    ListView lv;
    String[] linux;
    Linux l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv=findViewById(R.id.lv);

        linux=getResources().getStringArray(R.array.linux);

        ArrayAdapter ad=new ArrayAdapter(MainActivity.this,R.layout.lv_tem,R.id.adtv,linux);
        lv.setAdapter(ad);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(linux[position].matches(Linux.Arch.name())){
                    frg=new archF();
                    FragmentTransaction ft=getFragmentManager().beginTransaction();
                    ft.replace(R.id.f, frg).commit();
                }
                else if(linux[position].matches(Linux.Fedora.name())){
                    frg=new fedoraF();
                    FragmentTransaction ft=getFragmentManager().beginTransaction();
                    ft.replace(R.id.f, frg).commit();
                }
                else if(linux[position].matches(Linux.Kali.name())){
                    frg=new kaliF();
                    FragmentTransaction ft=getFragmentManager().beginTransaction();
                    ft.replace(R.id.f, frg).commit();
                }
                else if(linux[position].matches(Linux.Ubuntu.name())){
                    frg=new ubuntuF();
                    FragmentTransaction ft=getFragmentManager().beginTransaction();
                    ft.replace(R.id.f, frg).commit();
                }
                else if(linux[position].matches(Linux.Debian.name())){
                    frg=new debianF();
                    FragmentTransaction ft=getFragmentManager().beginTransaction();
                    ft.replace(R.id.f, frg).commit();
                }
                else if(linux[position].matches(Linux.Elementary.name())){
                    frg=new elemenF();
                    FragmentTransaction ft=getFragmentManager().beginTransaction();
                    ft.replace(R.id.f, frg).commit();
                }
                else if(linux[position].matches(Linux.Manjaro.name())){
                    frg=new manjaroF();
                    FragmentTransaction ft=getFragmentManager().beginTransaction();
                    ft.replace(R.id.f, frg).commit();
                }
                else if(linux[position].matches(Linux.Mint.name())){
                    frg=new mintF();
                    FragmentTransaction ft=getFragmentManager().beginTransaction();
                    ft.replace(R.id.f, frg).commit();
                }
            }
        });
    }
}