package com.example.expandablelistview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {

    ArrayList <String> al;
    HashMap <Integer,ArrayList<String>> hm;
    private ExpandableListView elv;
    private int locCol=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        elv=findViewById(R.id.elv);
        al=new ArrayList<String>(0);
        hm=new HashMap<Integer, ArrayList<String>>(0);

        dataInsert();

        CustomAdapter1 o= new CustomAdapter1(this,al,hm);
        elv.setAdapter(o);

        //listener
        elv.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                String s=al.get(groupPosition);
                Toast.makeText(MainActivity.this,s,Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        elv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                String s=hm.get(groupPosition).get(childPosition);
                Toast.makeText(MainActivity.this,s,Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        elv.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                collapse(groupPosition);
                String s=al.get(groupPosition)+" +";
                Toast.makeText(MainActivity.this,s,Toast.LENGTH_SHORT).show();
            }
        });

        elv.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                String s=al.get(groupPosition)+" -";
                Toast.makeText(MainActivity.this,s,Toast.LENGTH_SHORT).show();
            }
        });

    }


    //function
    public void dataInsert(){
        String[] header = getResources().getStringArray(R.array.header);
        String[] child = getResources().getStringArray(R.array.child);


        for(int i=0;i<header.length;i++){
            al.add(header[i]);

            ArrayList<String> a=new ArrayList<String>(0);
            a.add(child[i]);

            hm.put(i,a);
        }

    }

    public void collapse(int i){
       if(locCol!=-1 && locCol!=i){
            elv.collapseGroup(locCol);
        }
        locCol=i;
    }
}