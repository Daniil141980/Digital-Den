package com.example.digitalden.ui.main.profile.account.signup;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.digitalden.data.repositories.AuthRepository;


public class SignUpViewModel extends ViewModel {
    private AuthRepository authRepository;
    private LiveData<Boolean> registrationSuccess;

    public SignUpViewModel() {
        this.authRepository = new AuthRepository();
    }

    public void registration(String email, String password) {
        authRepository.registration(email, password);
        registrationSuccess = authRepository.getRegistrationSuccess();

    }

    public LiveData<Boolean> getRegistrationSuccess() {
        return registrationSuccess;
    }
}
