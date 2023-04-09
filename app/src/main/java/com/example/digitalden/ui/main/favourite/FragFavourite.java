package com.example.digitalden.ui.main.favourite;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.digitalden.R;
import com.example.digitalden.databinding.FragmentFavouriteBinding;

public class FragFavourite extends Fragment {
    private FragmentFavouriteBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentFavouriteBinding.inflate(inflater);
        return binding.getRoot();
    }
}
