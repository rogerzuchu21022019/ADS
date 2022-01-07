package com.example.test1.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.test1.fragment.FavoriteFragment;
import com.example.test1.fragment.HomeFragment;
import com.example.test1.fragment.ProfileFragment;
import com.example.test1.fragment.SearchFragment;


public class MyViewPager2Adapter extends FragmentStateAdapter {
    public MyViewPager2Adapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if(position==0){
            return new HomeFragment();
        }else if(position==1){
            return new FavoriteFragment();
        }else if(position==2){
            return new SearchFragment();
        }else if(position==3){
            return new ProfileFragment();
        }
        return new HomeFragment();
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
