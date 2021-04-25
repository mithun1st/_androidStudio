package com.example.basicadapterlistviewcustomadpater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter1 extends BaseAdapter {

    Context cc;
    String[] ss;
    int[] ii;

    public CustomAdapter1(Context c, String[] s, int[] i){
        this.cc=c;
        this.ss=s;
        this.ii=i;
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

        if(convertView==null){
            LayoutInflater li = (LayoutInflater) cc.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = li.inflate(R.layout.costom_adapter,parent,false);
        }

        TextView tv= convertView.findViewById(R.id.tv);
        TextView tv1= convertView.findViewById(R.id.tv1);
        ImageView iv= convertView.findViewById(R.id.iv);

        iv.setImageResource(ii[position]);
        tv.setText(ss[position]);
        tv1.setText("Click here for details about "+ ss[position]);

        return convertView;
    }
}
