package com.example.digitalden.ui.main.profile;

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
import com.example.digitalden.databinding.FragmentProfileBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileFragment extends Fragment {
    private FragmentProfileBinding binding;
    private ProfileViewModel viewModel;
    private FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(ProfileViewModel.class);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater);
        binding.topConstraintLay.setOnClickListener(v -> {
            if (firebaseUser == null) {
                NavHostFragment.findNavController(this).navigate(R.id.action_profileFragment_to_signInFragment);
            } else {
                NavHostFragment.findNavController(this).navigate(R.id.action_profileFragment_to_signOutFragment);
            }
        });
        binding.settingsBtn.setOnClickListener(v -> {
            NavHostFragment.findNavController(this).navigate(R.id.action_profileFragment_to_settingsFragment);
        });
        binding.subscriptionBtn.setOnClickListener(v -> {
            NavHostFragment.findNavController(this).navigate(R.id.action_profileFragment_to_subscribeFragment);
        });
        binding.aboutAppBtn.setOnClickListener(v -> {
            NavHostFragment.findNavController(this).navigate(R.id.action_profileFragment_to_aboutAppFragment);
        });

        return binding.getRoot();
    }
}
