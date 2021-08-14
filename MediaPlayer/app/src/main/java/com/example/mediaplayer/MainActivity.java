package com.example.mediaplayer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.io.IOException;
import java.net.URI;
import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton play,pause,next,prev;
    TextView tv;
    SeekBar sb;

    Thread t;
    Uri[] u;
    MediaPlayer mp;
    byte music=1;
    boolean con=false;

    AlertDialog ad;
    AlertDialog.Builder adb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        play=findViewById(R.id.play);
        pause = findViewById(R.id.pause);
        next = findViewById(R.id.next);
        prev = findViewById(R.id.prev);
        tv=findViewById(R.id.tv);
        sb=findViewById(R.id.sb);

        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        next.setOnClickListener(this);
        prev.setOnClickListener(this);

        u= new Uri[] {Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.vibration),
                Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.beating_heart),
                Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.rington)};



    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();

        adb=new AlertDialog.Builder(MainActivity.this);
        adb.setCancelable(false);
        adb.setTitle("Player Quit");
        adb.setMessage("Do u want to Exit?");
        adb.setIcon(R.drawable.ic_baseline_pause_24);

        adb.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(mp!=null){
                    mp.stop();
                }
                finish();
            }
        });

        adb.setNeutralButton("Netrul (no)", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(mp!=null){
                    mp.stop();
                }
            }
        });

        adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        ad=adb.create();
        ad.show();
    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.play){
            if(mp!=null){
                mp.stop();
            }
            mp=MediaPlayer.create(MainActivity.this, u[music]);
            duration(mp.getDuration());
            mp.start();
            Toast.makeText(this,"play",Toast.LENGTH_SHORT).show();
        }

        if(v.getId()==R.id.pause){
            if(mp!=null){
                mp.stop();
            }
            if(con){
                con=false;
            }

            Toast.makeText(this,"stop",Toast.LENGTH_SHORT).show();
        }

        if(v.getId()==R.id.next){
            music++;
            if(music>2){
                music=2;
            }
            if(mp!=null){
                mp.stop();
            }
            mp=MediaPlayer.create(MainActivity.this,u[music]);
            duration(mp.getDuration());
            mp.start();
            Toast.makeText(this,"next",Toast.LENGTH_SHORT).show();
        }

        if(v.getId()==R.id.prev){
            music--;
            if(music<0){
                music=0;
            }
            if(mp!=null){
                mp.stop();
            }
            mp=MediaPlayer.create(MainActivity.this,u[music]);
            duration(mp.getDuration());
            mp.start();
            Toast.makeText(this,"prev",Toast.LENGTH_SHORT).show();
        }

    }

    public void duration(int i){
        DecimalFormat df=new DecimalFormat("##.##");
        double d=(((double)i)/1000)/(60);
        tv.setText("Duration: "+String.valueOf(df.format(d)));


        int length=(int)(d*60);
        sb.setMax(length);

        if(con){
            con=false;
        }

        con=true;

        t = new Thread(new Runnable() {
            @Override
            public void run() {
                int ii=0;
                while(ii<length && con){
                    try {
                        Thread.sleep(1000);
                        sb.setProgress(ii);
                    }catch (Exception exception){
                        exception.printStackTrace();
                    }
                    ii++;
                }
            }
        });
        t.start();

    }
}