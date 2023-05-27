package com.example.digitalden.ui.load;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;

public class LoadingViewModel extends AndroidViewModel {
    private MutableLiveData<Boolean> liveData = new MutableLiveData();
    public LoadingViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Boolean> getLiveData() {
        return liveData;
    }

    public void load() {
        new Thread(() -> {
            while (!isInternetAvailable()) {}
            liveData.postValue(true);
        }).start();
    }

    public boolean isInternetAvailable() {
        try {
            InetAddress ipAddr = InetAddress.getByName("google.com");
            return !ipAddr.equals("");

        } catch (Exception e) {
            return false;
        }
    }
}
