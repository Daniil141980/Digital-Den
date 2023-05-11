package com.example.digitalden.ui.main.mainPage;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.digitalden.data.data_sources.room.entites.ItemEntity;
import com.example.digitalden.data.models.LeadersSales;
import com.example.digitalden.data.repositories.ItemsRepository;
import com.example.digitalden.data.repositories.SteamRepository;

import java.util.List;

public class MainPageViewModel extends AndroidViewModel {
    private ItemsRepository mRepository;
    private SteamRepository steamRepository;
    // Using LiveData and caching what getAlphabetizedWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    private final LiveData<List<ItemEntity>> mAllWords;
    private final LiveData<LeadersSales>  mAllGames;

    public MainPageViewModel(Application application) {
        super(application);
        steamRepository = new SteamRepository();
        mAllGames = steamRepository.getLeaders();
        mRepository = new ItemsRepository(application);
        mAllWords = mRepository.getAllWords();
    }

    LiveData<List<ItemEntity>> getAllWords() {
        return mAllWords;
    }
    LiveData<LeadersSales> getAllGames() {
        return mAllGames;
    }

    void insert(ItemEntity word) {
        mRepository.insert(word);
    }

}
