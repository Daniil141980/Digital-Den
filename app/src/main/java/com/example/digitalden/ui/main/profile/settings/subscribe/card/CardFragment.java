package com.example.digitalden.ui.main.profile.settings.subscribe.card;

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
import com.example.digitalden.databinding.FragmentCardBinding;

public class CardFragment extends Fragment {
    private FragmentCardBinding binding;
    private CardViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(CardViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCardBinding.inflate(inflater);
        binding.back.setOnClickListener(v -> {
            NavHostFragment.findNavController(this).navigate(R.id.action_cardFragment_to_subscribeFragment);});
        binding.payBtn.setOnClickListener(v -> {
            NavHostFragment.findNavController(this).navigate(R.id.action_cardFragment_to_okFragment);});
        return binding.getRoot();
    }
}
