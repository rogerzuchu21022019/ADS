package com.example.test1.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.test1.R;


public class FavoriteFragment extends Fragment {
    TextView tieFavorite;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewFavorite = inflater.inflate(R.layout.favorite_fragment,container,false);
        tieFavorite = viewFavorite.findViewById(R.id.tieFavorite);
        return viewFavorite;
    }
}
