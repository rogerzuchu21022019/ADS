package com.example.test1.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.test1.R;
import com.example.test1.adapter.MyViewPager2Adapter2;
import com.google.android.material.tabs.TabLayout;


public class HomeFragment extends Fragment {
    TabLayout tabLayoutHome;
    TextView tvNameAds1, tvNameAds2, tvNameAds3;
    ViewPager2 viewPagerHome1, viewPagerHome2, viewPagerHome3;
    MyViewPager2Adapter2 adapter = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewHome = inflater.inflate(R.layout.home_fragment, container, false);
        createTextView(viewHome);
        createViewPager(viewHome);
        mappingViewPager(viewPagerHome1);
        mappingViewPager(viewPagerHome2);
        mappingViewPager(viewPagerHome3);
        return viewHome;
    }

    public void createTextView(View viewHome) {
        tvNameAds1 = viewHome.findViewById(R.id.tvNameAds1);
        tvNameAds2 = viewHome.findViewById(R.id.tvNameAds2);
        tvNameAds3 = viewHome.findViewById(R.id.tvNameAds3);
    }

    public void createViewPager(View viewHome) {
        viewPagerHome1 = viewHome.findViewById(R.id.viewPagerHome1);
        viewPagerHome2 = viewHome.findViewById(R.id.viewPagerHome2);
        viewPagerHome3 = viewHome.findViewById(R.id.viewPagerHome3);
    }

    public void mappingViewPager(ViewPager2 viewpager) {
        adapter = new MyViewPager2Adapter2(getActivity());
        viewpager.setAdapter(adapter);
    }
}
