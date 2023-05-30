package com.example.digitalden.ui.main.profile.account.signup;

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
import com.example.digitalden.databinding.FragmentSignUpBinding;
import com.example.digitalden.ui.main.profile.account.signup.SignUpViewModel;

public class SignUpFragment extends Fragment {
    private FragmentSignUpBinding binding;
    private SignUpViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(SignUpViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentSignUpBinding.inflate(inflater);
        binding.backBtn.setOnClickListener(v -> {
            NavHostFragment.findNavController(this).navigate(R.id.action_signUpFragment_to_profileFragment);});
        binding.btnLogInrform.setOnClickListener(v -> {
            NavHostFragment.findNavController(this).navigate(R.id.action_signUpFragment_to_signInFragment);});
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btnSignUp.setOnClickListener(v -> {
            try{
                String email = binding.etEmail.getText().toString();
                String password = binding.etPass.getText().toString();
                viewModel.registration(email, password);
                viewModel.getRegistrationSuccess().observe(getViewLifecycleOwner(), l -> {
                    if (Boolean.TRUE.equals(viewModel.getRegistrationSuccess().getValue())){
                        NavHostFragment.findNavController(SignUpFragment.this).navigate(R.id.action_signUpFragment_to_signOutFragment);
                    }
                    else{
                        Toast.makeText(getContext(), "Ошибка регистрации", Toast.LENGTH_SHORT).show();
                    }
                });
            } catch (IllegalArgumentException e) {
                Toast.makeText(getContext(), "Все поля должны быть заполнены", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
