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


public class PlayFragment extends Fragment {
    TextView tieFavorite1;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewFavorite = inflater.inflate(R.layout.play_fragment,container,false);
        tieFavorite1 = viewFavorite.findViewById(R.id.tieFavorite1);
        return viewFavorite;
    }
}
