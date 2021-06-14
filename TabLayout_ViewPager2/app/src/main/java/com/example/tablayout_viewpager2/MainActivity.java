package com.example.tablayout_viewpager2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private TabLayout tl;
    private ViewPager2 vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tl=findViewById(R.id.tl);
        vp=findViewById(R.id.vp);

        //tab create
        tl.addTab(tl.newTab().setText("One"));
        tl.addTab(tl.newTab().setText("Two"));
        tl.addTab(tl.newTab().setText("Three"));



        //initial fragment adapter
        FragmentManager fm=getSupportFragmentManager();
        FragCls obj = new FragCls(fm,getLifecycle());
        vp.setAdapter(obj);


        //initial tab click listener
        tl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vp.setCurrentItem(tab.getPosition());
                Toast.makeText(MainActivity.this,String.valueOf(tab.getPosition()),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //view Pager Listener
        vp.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tl.selectTab(tl.getTabAt(position));
            }
        });


        //initial selected tab
        tl.selectTab(tl.getTabAt(1));

    }
}