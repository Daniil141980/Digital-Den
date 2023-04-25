package com.example.digitalden.ui.main.mainPage;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.digitalden.data.data_sources.room.entites.ItemEntity;
import com.example.digitalden.data.models.Item;
import com.example.digitalden.data.repositories.ItemsRepository;

import java.util.List;

public class MainPageViewModel extends AndroidViewModel {
    private ItemsRepository mRepository;
    // Using LiveData and caching what getAlphabetizedWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    private final LiveData<List<ItemEntity>> mAllWords;

    public MainPageViewModel(Application application) {
        super(application);
        mRepository = new ItemsRepository(application);
        mAllWords = mRepository.getAllWords();
    }

    LiveData<List<ItemEntity>> getAllWords() {
        return mAllWords;
    }

    void insert(ItemEntity word) {
        mRepository.insert(word);
    }

}
