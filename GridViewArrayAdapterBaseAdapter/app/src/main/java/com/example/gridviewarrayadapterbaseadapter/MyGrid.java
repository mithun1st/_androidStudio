package com.example.gridviewarrayadapterbaseadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyGrid extends BaseAdapter {

    Context act;
    String[] linux;
    int[] logo;

    //constructor
    public MyGrid(Context c, String[] li, int[] lo){
        this.act=c;
        this.linux=li;
        this.logo=lo;
    }

    @Override
    public int getCount() {
        return linux.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater li=LayoutInflater.from(act);
        View v=li.inflate(R.layout.base_adp_tem,parent,false);

        TextView tv=v.findViewById(R.id.tv1);
        ImageView iv=v.findViewById(R.id.iv1);

        tv.setText(linux[position]);
        iv.setImageResource(logo[position]);

        return v;
    }
}
