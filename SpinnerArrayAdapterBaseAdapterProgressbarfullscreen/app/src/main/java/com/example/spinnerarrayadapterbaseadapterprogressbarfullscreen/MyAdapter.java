package com.example.spinnerarrayadapterbaseadapterprogressbarfullscreen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {

    Context cc;
    String[] ss;
    int[] ll;

    public MyAdapter(Context c, String[] s, int[] l){
        cc=c;
        ss=s;
        ll=l;
    }

    @Override
    public int getCount() {
        return ss.length;
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
        LayoutInflater li= LayoutInflater.from(cc);
        View v= li.inflate(R.layout.base_tem,parent,false);

        TextView tv=v.findViewById(R.id.tv1);
        ImageView iv=v.findViewById(R.id.iv);

        tv.setText(ss[position]);
        iv.setImageResource(ll[position]);

        return v;
    }
}
