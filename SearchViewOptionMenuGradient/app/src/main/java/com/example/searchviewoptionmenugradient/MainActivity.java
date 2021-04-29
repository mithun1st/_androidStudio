package com.example.searchviewoptionmenugradient;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    private SearchView sv;
    ArrayAdapter<String> ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv=findViewById(R.id.lv);
        sv=findViewById(R.id.sv);
        String[] program = getResources().getStringArray(R.array.pl);

        ad = new ArrayAdapter<String>(MainActivity.this,R.layout.list_view,R.id.tv,program);
        lv.setAdapter(ad);

        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ad.getFilter().filter(newText);
                return false;
            }
        });
    }

    //OptionMenu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater mi=getMenuInflater();
        mi.inflate(R.menu.option_menu,menu);

        //for search on actionbar
        MenuItem mit=menu.findItem(R.id.i);
        SearchView svi= (SearchView) mit.getActionView();

        svi.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ad.getFilter().filter(newText);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.i){
            Toast.makeText(this,item.toString(),Toast.LENGTH_SHORT).show();
        }
        if(item.getItemId()==R.id.i1){
            Toast.makeText(this,item.toString(),Toast.LENGTH_SHORT).show();
        }
        if(item.getItemId()==R.id.i2){
            Toast.makeText(this,item.toString(),Toast.LENGTH_SHORT).show();
        }
        if(item.getItemId()==R.id.i3){
            Toast.makeText(this,item.toString(),Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
}