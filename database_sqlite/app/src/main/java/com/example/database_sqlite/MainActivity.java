package com.example.database_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv1,tv2,tv3;
    private Button c,r,u,d,clear;
    private EditText id,name,dep;
    Cls o;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tv1=findViewById(R.id.view1);
        tv2=findViewById(R.id.view2);
        tv3=findViewById(R.id.view3);

        clear=findViewById(R.id.clear);

        c=findViewById(R.id.b1);
        r=findViewById(R.id.b2);
        u=findViewById(R.id.b3);
        d=findViewById(R.id.b4);

        id=findViewById(R.id.id);
        name=findViewById(R.id.name);
        dep=findViewById(R.id.dep);

        c.setOnClickListener(this);
        r.setOnClickListener(this);
        u.setOnClickListener(this);
        d.setOnClickListener(this);

        clear.setOnClickListener(this);

        o = new Cls(MainActivity.this);
        SQLiteDatabase o1=o.getWritableDatabase();


    }

    @Override
    public void onClick(View v) {

        String col1=id.getText().toString();
        String col2=name.getText().toString();
        String col3=dep.getText().toString();


        if(v.getId()==c.getId()){
            o.insert(col1,col2,col3);
        }

        if(v.getId()==r.getId()){
            Cursor cu= o.read(col1);

            StringBuffer sb1=new StringBuffer();
            StringBuffer sb2=new StringBuffer();
            StringBuffer sb3=new StringBuffer();

            sb1.append("ID\n");
            sb2.append("Name\n");
            sb3.append("Dep\n");

            if(cu.getCount()==0){
                tv1.setText("ID\nNo");
                tv2.setText("Name\nData");
                tv3.setText("Dep\nFound");
                return;
            }

            while (cu.moveToNext()){
                sb1.append(cu.getString(0)+"\n");
                sb2.append(cu.getString(1)+"\n");
                sb3.append(cu.getString(2)+"\n");
            }

            tv1.setText(sb1);
            tv2.setText(sb2);
            tv3.setText(sb3);

            System.out.println(sb1);
            System.out.println(sb2);
            System.out.println(sb3);

        }

        if(v.getId()==u.getId()){
            o.update(col1,col2,col3);
        }

        if(v.getId()==d.getId()){
            o.delete(col1);
        }

        if(v.getId()==clear.getId()){
            id.setText("");
            name.setText("");
            dep.setText("");
        }

    }
}