package com.example.digitalden.ui.main.mainPage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.digitalden.R;
import com.example.digitalden.databinding.FragmentMainPageBinding;

public class FragMainPage extends Fragment {
    private FragmentMainPageBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentMainPageBinding.inflate(inflater);
        return binding.getRoot();
    }
}
