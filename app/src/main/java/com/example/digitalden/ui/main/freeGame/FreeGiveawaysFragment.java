package com.example.digitalden.ui.main.freeGame;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.digitalden.databinding.FragmentFreeGiveawaysBinding;

public class FreeGiveawaysFragment extends Fragment {
    private FragmentFreeGiveawaysBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentFreeGiveawaysBinding.inflate(inflater);
        return binding.getRoot();
    }
}
