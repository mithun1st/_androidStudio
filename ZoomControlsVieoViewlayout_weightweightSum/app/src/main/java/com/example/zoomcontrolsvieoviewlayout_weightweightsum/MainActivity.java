package com.example.zoomcontrolsvieoviewlayout_weightweightsum;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;
import android.widget.ZoomControls;

public class MainActivity extends AppCompatActivity {

    private ImageView iv;
    private ZoomControls zc;
    private VideoView vv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv=findViewById(R.id.iv);
        zc=findViewById(R.id.zc);
        vv=findViewById(R.id.vv);

        //Zoom Controls
        zc.setOnZoomInClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float x=iv.getScaleX();
                float y=iv.getScaleY();

                iv.setScaleX((float) (x+.5));
                iv.setScaleY((float) (y+.5));
            }
        });

        zc.setOnZoomOutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float x=iv.getScaleX();
                float y=iv.getScaleY();

                iv.setScaleX((float) (x-.5));
                iv.setScaleY((float) (y-.5));
            }
        });

        //VideoView
        Uri uri= Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.rubiks);
        vv.setVideoURI(uri);
        vv.start();

        MediaController mc=new MediaController(this);
        vv.setMediaController(mc);
    }
}