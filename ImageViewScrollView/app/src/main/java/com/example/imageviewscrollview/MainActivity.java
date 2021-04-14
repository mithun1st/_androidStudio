package com.example.imageviewscrollview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView iv1,iv2,iv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv1=findViewById(R.id.i1);
        iv2=findViewById(R.id.i2);
        iv3=findViewById(R.id.i3);

        Toast t = Toast.makeText(this,"Mithun",Toast.LENGTH_SHORT);



        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("1st Picture");

                Toast.makeText(MainActivity.this,"1st picture",Toast.LENGTH_SHORT).show();
            }
        });

        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("2nd Picture");
                t.show();
            }
        });

        iv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("3rd Picture");
            }
        });
    }
}