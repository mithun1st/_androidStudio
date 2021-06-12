package com.example.upbutton_style_htmlcontext;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private WebView wb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //enable up Button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Show Logo on ActionBar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setLogo(R.drawable.per);

        //html context
        wb=findViewById(R.id.wb);

        String body="<h2> Headline 2 </h2> \n"+
                "<h4> Headline 4 </h4> \n"+
                "<h6> Headline 6 </h6> \n"+
                "<p> <b>bold</b>, <i>italic</i> </p>"+
                "<p> <del>correct</del>, <u>UnderLine</u> </p>"+
                "<p> (a+b)<sup>3</sup>, H<sub>2</sub>O </p>";
        String html=
                "<html>"+
                    "<head>" +
                    "</head>" +
                    "<body>" +
                        body+
                    "</body>" +
                "</html";

        wb.loadDataWithBaseURL(null,html,"type/html","utf-8",null);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            Toast.makeText(this,"Up Button",Toast.LENGTH_SHORT).show();
        }


        return super.onOptionsItemSelected(item);
    }
}