package com.example.digitalden.ui.main.profile.account.signin;

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
import com.example.digitalden.databinding.FragmentSignInBinding;
import com.example.digitalden.ui.main.profile.account.signin.SignInViewModel;

public class SignInFragment extends Fragment {
    private FragmentSignInBinding binding;
    private SignInViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(SignInViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentSignInBinding.inflate(inflater);
        binding.backBtn.setOnClickListener(v -> {
            NavHostFragment.findNavController(this).navigate(R.id.action_signInFragment_to_profileFragment);});
        binding.btnSignUplform.setOnClickListener(v -> {
            NavHostFragment.findNavController(this).navigate(R.id.action_signInFragment_to_signUpFragment);});
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btnSignIn.setOnClickListener(v -> {
            try{
                String email = binding.etEmail.getText().toString();
                String password = binding.etPass.getText().toString();
                viewModel.signIn(email, password);
                viewModel.getSignInSuccess().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
                    @Override
                    public void onChanged(Boolean aBoolean) {
                        if (Boolean.TRUE.equals(viewModel.getSignInSuccess().getValue())){
                            NavHostFragment.findNavController(SignInFragment.this).navigate(R.id.action_signInFragment_to_signOutFragment);
                        }
                        else{
                            Toast.makeText(getContext(), "Ошибка авторизации", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            } catch (IllegalArgumentException e) {
                Toast.makeText(getContext(), "Все поля должны быть заполнены", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
