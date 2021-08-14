package com.example.tablayout_viewpager2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private TabLayout tl;
    private ViewPager vp;

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
        FragCls obj = new FragCls(getSupportFragmentManager());
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
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                tl.selectTab(tl.getTabAt(position));
                System.out.println("--------"+vp.getCurrentItem());
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });


        //initial selected tab
        tl.selectTab(tl.getTabAt(1));

    }
}