package com.example.digitalden.ui.main.favourite;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.digitalden.data.data_sources.room.entites.FavouriteEntity;
import com.example.digitalden.data.repositories.FavouritesRepository;

import java.util.List;

public class FavouriteViewModel extends AndroidViewModel {

    private FavouritesRepository mRepository;

    private final LiveData<List<FavouriteEntity>> mAllGames;

    public FavouriteViewModel (Application application) {
        super(application);
        mRepository = new FavouritesRepository(application);
        mAllGames = mRepository.getAllGames();
    }

    LiveData<List<FavouriteEntity>> getAllGames() { return mAllGames; }

    public void insert(FavouriteEntity game) { mRepository.insert(game); }
    public void delete(FavouriteEntity game) {mRepository.delete(game);}
}
