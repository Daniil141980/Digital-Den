package com.example.digitalden.ui.main.sort.favourite;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.digitalden.R;
import com.example.digitalden.databinding.FragmentSortingBinding;
import com.example.digitalden.ui.main.sort.favourite.SortingFavouriteViewModel;

public class SortingFavouriteFragment extends Fragment {
    private FragmentSortingBinding binding;
    private SortingFavouriteViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(SortingFavouriteViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentSortingBinding.inflate(inflater);
        binding.backBtn.setOnClickListener(v -> {
            NavHostFragment.findNavController(this).navigate(R.id.action_sortFavouriteFragment_to_favouriteFragment);});
        return binding.getRoot();
    }
}
