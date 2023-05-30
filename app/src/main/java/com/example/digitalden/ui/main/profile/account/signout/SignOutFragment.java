package com.example.digitalden.ui.main.profile.account.signout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.digitalden.R;
import com.example.digitalden.databinding.FragmentSignOutBinding;
import com.example.digitalden.ui.main.profile.account.signout.SignOutViewModel;
import com.google.firebase.auth.FirebaseAuth;

public class SignOutFragment extends Fragment {
    private FragmentSignOutBinding binding;
    private SignOutViewModel viewModel;
    private FirebaseAuth mAuth;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(SignOutViewModel.class);
        mAuth = FirebaseAuth.getInstance();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentSignOutBinding.inflate(inflater);
        binding.backBtn.setOnClickListener(v -> {
            NavHostFragment.findNavController(this).navigate(R.id.action_signOutFragment_to_profileFragment);});
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.signOut.setOnClickListener(v -> {
            mAuth.signOut();
            NavHostFragment.findNavController(this).navigate(R.id.action_signOutFragment_to_profileFragment);
    });
    }
}
