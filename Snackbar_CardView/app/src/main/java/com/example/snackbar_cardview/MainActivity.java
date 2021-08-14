package com.example.snackbar_cardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv;
    private CardView cv;
    boolean con=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cv=findViewById(R.id.cv);
        tv=findViewById(R.id.tv);


        cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                con=!con;

                if(con){
                    tv.setVisibility(View.VISIBLE);
                }
                else {
                    tv.setVisibility(View.INVISIBLE);
                }
            }
        });

    }
}