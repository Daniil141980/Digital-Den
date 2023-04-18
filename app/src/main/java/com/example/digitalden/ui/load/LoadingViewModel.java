package com.example.digitalden.ui.load;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

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
            try {
                Thread.sleep(1000);
                liveData.postValue(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
