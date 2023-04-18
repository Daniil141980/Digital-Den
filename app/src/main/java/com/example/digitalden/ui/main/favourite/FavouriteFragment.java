package com.example.digitalden.ui.main.favourite;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.digitalden.R;
import com.example.digitalden.databinding.FragmentFavouriteBinding;

public class FavouriteFragment extends Fragment {
    private FragmentFavouriteBinding binding;
    private FavouriteViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(FavouriteViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentFavouriteBinding.inflate(inflater);
        binding.sortingBtn.setOnClickListener(v -> {
            NavHostFragment.findNavController(this).navigate(R.id.action_favouriteFragment_to_sortingFavFragment);});
        return binding.getRoot();
    }

}
