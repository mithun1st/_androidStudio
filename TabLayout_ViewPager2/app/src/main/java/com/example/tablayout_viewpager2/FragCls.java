package com.example.tablayout_viewpager2;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import org.jetbrains.annotations.NotNull;

public class FragCls extends FragmentStateAdapter{

    public FragCls(@NonNull @NotNull FragmentManager fragmentManager, @NonNull @NotNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment f = null;

        switch (position){
            case 0:
                f=new frag1();
                break;
            case 1:
                f=new frag2();
                break;
            case 2:
                f=new frag3();
                break;
        }

        return f;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
