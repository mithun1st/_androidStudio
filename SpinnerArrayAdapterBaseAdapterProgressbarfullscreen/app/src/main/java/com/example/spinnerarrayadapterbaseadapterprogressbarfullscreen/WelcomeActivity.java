package com.example.spinnerarrayadapterbaseadapterprogressbarfullscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.UiAutomation;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;

public class WelcomeActivity extends AppCompatActivity {

    ProgressBar pb;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Remove ActionBar
        getSupportActionBar().hide();

        //Remove NotificationBar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_welcome);
        //----------------

        pb=findViewById(R.id.pb);
        b=findViewById(R.id.b);

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                progress();
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t.start();
            }
        });
    }

    public void progress() {
        int i=0;
        while(i<=100){
            try {
                Thread.sleep((500-(5*i)));
                pb.setProgress(i);
            }catch (Exception e){

            }
            Log.v("loop",String.valueOf((500-(5*i))));
            i+=10;
        }
        Intent in = new Intent(WelcomeActivity.this, MainActivity.class);
        startActivity(in);
        finish();
    }
}