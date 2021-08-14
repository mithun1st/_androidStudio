package com.example.tablayout_viewpager2;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import org.jetbrains.annotations.NotNull;

public class FragCls extends FragmentPagerAdapter {

    Fragment[] f = new Fragment[]{new frag1(), new frag2(), new frag3()};

    public FragCls(FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        return f[position];

    }

    @Override
    public int getCount() {
        return f.length;
    }
}
