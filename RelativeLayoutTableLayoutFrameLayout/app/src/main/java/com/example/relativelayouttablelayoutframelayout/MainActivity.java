package com.example.relativelayouttablelayoutframelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TableLayout tb;
    private Button b,b1;
    private TextView tv;
    boolean bo=true;
    boolean bo1=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b=findViewById(R.id.b1);
        tb=findViewById(R.id.table1);

        b1=findViewById(R.id.b2);
        tv=findViewById(R.id.tv);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(bo){
                    b.setText("Hide Number");
                }
                else {
                    b.setText("Show Number");
                }
                bo=!bo;

                tb.setColumnCollapsed(2,bo);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bo1=!bo1;
                if(bo1){
                    tv.setVisibility(View.VISIBLE);
                }
                else {
                    tv.setVisibility(View.GONE);
                }
            }
        });

    }
}