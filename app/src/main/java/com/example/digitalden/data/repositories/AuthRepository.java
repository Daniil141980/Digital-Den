package com.example.digitalden.data.repositories;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AuthRepository {
    private FirebaseAuth mAuth;
    private String email;
    private String password;
    private final FirebaseDatabase database = FirebaseDatabase.getInstance();
    private final MutableLiveData<Boolean> registrationSuccess = new MutableLiveData<>();
    private MutableLiveData<Boolean> signInSuccess = new MutableLiveData<>();

    public void setRegistrationSuccess(boolean registrationSuccess) {
        this.registrationSuccess.postValue(registrationSuccess);
    }

    public MutableLiveData<Boolean> getRegistrationSuccess() {
        return registrationSuccess;
    }

    public void registration(String email, String password) {
        mAuth = FirebaseAuth.getInstance();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        setRegistrationSuccess(true);
                        this.email = email;
                        this.password = password;
                        FirebaseUser user = mAuth.getCurrentUser();
                        Log.d("Mytest", "   RegistrationAccess");
                        loadDataToDataBase(user);
                    } else {
                        setRegistrationSuccess(false);
                        Exception exception = task.getException();
                        if (exception != null) {
                            Log.e("Mytest", "Registration failed", exception);
                        }
                    }
                });
    }

    public void loadDataToDataBase(FirebaseUser user) {
        String userId = user.getUid();
        DatabaseReference userRef = database.getReference("users/" + userId);
        userRef.child("password").setValue(password);
        userRef.child("email").setValue(email);
        Log.d("Mytest", "CountOrganizedEvents set");
    }


    public void setSignInSuccess(boolean signInSuccess) {
        this.signInSuccess.postValue(signInSuccess);
    }

    public MutableLiveData<Boolean> getSignInSuccess() {
        return signInSuccess;
    }

    public void signIn(String email, String password) {
        mAuth = FirebaseAuth.getInstance();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Вход выполнен успешно, получаем информацию о пользователе
                            FirebaseUser user = mAuth.getCurrentUser();
                            Log.d("Mytest", "access");
                            setSignInSuccess(true);
                        } else {
                            // Вход не выполнен, выводим сообщение об ошибке
                            Log.d("Mytest", "error");
                            setSignInSuccess(false);
                        }
                    }
                });
    }
}
