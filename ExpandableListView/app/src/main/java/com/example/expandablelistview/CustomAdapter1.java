package com.example.expandablelistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class CustomAdapter1 extends BaseExpandableListAdapter {

    Context cc;
    ArrayList<String> al;
    HashMap<Integer,ArrayList<String>> hm;

    CustomAdapter1(Context c, ArrayList<String> a, HashMap<Integer,ArrayList<String>> h){
        this.cc=c;
        this.al=a;
        this.hm=h;
    }
    
    
    @Override
    public int getGroupCount() {
        return al.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return hm.get(groupPosition).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return al.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return hm.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String str=al.get(groupPosition);

        LayoutInflater li=LayoutInflater.from(cc);
        View v= li.inflate(R.layout.header_tem,null);
        TextView tv= v.findViewById(R.id.htv);
        tv.setText(str);
        return v;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String str=hm.get(groupPosition).get(childPosition);
        //String s= getGroup(groupPosition).toString();

        LayoutInflater li=LayoutInflater.from(cc);
        View v= li.inflate(R.layout.child_tem,null);
        TextView tv= v.findViewById(R.id.ctv);
        tv.setText(str);
        return v;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
