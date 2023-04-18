package com.example.digitalden.ui.main.profile.settings.subscribe;

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
import com.example.digitalden.databinding.FragmentSubscribeBinding;

public class SubscribeFragment extends Fragment {
    private FragmentSubscribeBinding binding;
    private SubscribeViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(SubscribeViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentSubscribeBinding.inflate(inflater);
        binding.back.setOnClickListener(v -> {
            NavHostFragment.findNavController(this).navigate(R.id.action_subscribeFragment_to_profileFragment);});
        binding.buyBtn.setOnClickListener(v -> {
            NavHostFragment.findNavController(this).navigate(R.id.action_subscribeFragment_to_cardFragment);});
        return binding.getRoot();
    }
}
