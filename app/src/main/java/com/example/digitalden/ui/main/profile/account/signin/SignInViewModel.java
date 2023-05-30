package com.example.digitalden.ui.main.profile.account.signin;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.digitalden.data.repositories.AuthRepository;

public class SignInViewModel extends ViewModel {
    private AuthRepository authRepository;
    private LiveData<Boolean> signInSuccess;

    public SignInViewModel() {
        this.authRepository = new AuthRepository();
    }

    public void signIn(String email, String password) {
        authRepository.signIn(email, password);
        signInSuccess = authRepository.getSignInSuccess();

    }

    public LiveData<Boolean> getSignInSuccess() {
        return signInSuccess;
    }

}
