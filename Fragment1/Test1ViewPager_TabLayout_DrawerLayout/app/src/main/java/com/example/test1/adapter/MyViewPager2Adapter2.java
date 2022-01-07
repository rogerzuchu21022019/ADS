package com.example.test1.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.test1.fragment.FavoriteFragment;
import com.example.test1.fragment.PlayFragment;
import com.example.test1.fragment.ProfileFragment;
import com.example.test1.fragment.SearchFragment;


public class MyViewPager2Adapter2 extends FragmentStateAdapter {
    public MyViewPager2Adapter2(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new FavoriteFragment();
        } else if (position == 1) {
            return new SearchFragment();
        } else if (position == 2) {
            return new ProfileFragment();
        }
        return new FavoriteFragment();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
