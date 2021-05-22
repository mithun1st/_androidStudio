package com.example.sharefeedbackautocompletetextview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button share,feedback;
    private AutoCompleteTextView actv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        share=findViewById(R.id.b1);
        feedback=findViewById(R.id.b2);
        actv=findViewById(R.id.actv);


        String su="Mahadi Hassan";
        String te="having fun with android studio";
        String[] linux=getResources().getStringArray(R.array.linux);

        //auto complete text view
        ArrayAdapter<String> ad=new ArrayAdapter<>(MainActivity.this,R.layout.auto_complete_text_view,R.id.tv,linux);
        actv.setThreshold(1);
        actv.setAdapter(ad);

        actv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,actv.getText(),Toast.LENGTH_SHORT).show();
            }
        });


        //share button
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent is=new Intent(Intent.ACTION_SEND);
                is.setType("text/plain");

                is.putExtra(Intent.EXTRA_SUBJECT,su);
                is.putExtra(Intent.EXTRA_TEXT,te);

                startActivity(Intent.createChooser(is,"Share Now"));
            }
        });

        //feedback button
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ifb=new Intent(Intent.ACTION_SEND);
                ifb.setType("text/email");

                ifb.putExtra(Intent.EXTRA_SUBJECT,su);
                ifb.putExtra(Intent.EXTRA_TEXT,te);

                ifb.putExtra(Intent.EXTRA_EMAIL,new String[]{"mithun.2121@yahoo.com","m2n1st@gmail.com"});

                startActivity(Intent.createChooser(ifb,"feedback Now"));
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater mi=getMenuInflater();
        mi.inflate(R.menu.menu_layout,menu);

        //MenuItem se= menu.findItem(R.id.mSearch);
        //SearchView sv= (SearchView) se.getActionView();

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.mSearch){
            Toast.makeText(MainActivity.this,"Search",Toast.LENGTH_SHORT).show();
        }

        if(item.getItemId()==R.id.mShare){
            Toast.makeText(MainActivity.this,"Share",Toast.LENGTH_SHORT).show();
        }

        if(item.getItemId()==R.id.mFeedback){
            Toast.makeText(MainActivity.this,"Feedback",Toast.LENGTH_SHORT).show();
        }


        return super.onOptionsItemSelected(item);
    }
}