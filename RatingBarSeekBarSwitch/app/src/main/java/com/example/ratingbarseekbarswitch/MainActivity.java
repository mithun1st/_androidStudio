package com.example.ratingbarseekbarswitch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RatingBar rbv;
    private SeekBar sbv;
    private Switch sv;
    private TextView tvv;

    String s1="";
    String s2="";
    String s3="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rbv=findViewById(R.id.rb);
        sbv=findViewById(R.id.sb);
        sv=findViewById(R.id.s);
        tvv=findViewById(R.id.tv);

        sbv.setMax(60);
        sbv.setProgress(10+30);

        rbv.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                s1= String.valueOf(rating);
                tvv.setText("RatingBar: "+s1+"\nSeekBar: "+s2+"\nSwitch: "+s3);
            }
        });
        float d = rbv.getRating();
        sbv.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                s2= String.valueOf(progress-10);
                tvv.setText("RatingBar: "+s1+"\nSeekBar: "+s2+"\nSwitch: "+s3);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Touch On",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Touch Off",Toast.LENGTH_SHORT).show();
            }
        });

        sv.setChecked(false);
        sv.isChecked();
        sv.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(sv.isChecked()){
                    s3=String.valueOf(sv.getTextOn());
                }
                else{
                    s3=String.valueOf(sv.getTextOff());
                }
                tvv.setText("RatingBar: "+s1+"\nSeekBar: "+s2+"\nSwitch: "+s3);
            }
        });
    }
}