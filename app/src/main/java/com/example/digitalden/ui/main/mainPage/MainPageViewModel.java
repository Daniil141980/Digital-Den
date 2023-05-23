package com.example.digitalden.ui.main.mainPage;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.digitalden.data.data_sources.room.entites.FavouriteEntity;
import com.example.digitalden.data.data_sources.room.entites.ItemEntity;
import com.example.digitalden.data.models.AllGamesFromSteam;
import com.example.digitalden.data.models.GameFromGog;
import com.example.digitalden.data.models.LeadersSales;
import com.example.digitalden.data.repositories.FavouritesRepository;
import com.example.digitalden.data.repositories.GogRepository;
import com.example.digitalden.data.repositories.SteamRepository;

import java.util.List;

public class MainPageViewModel extends AndroidViewModel {
    private SteamRepository steamRepository;
    private GogRepository gogRepository;
    private FavouritesRepository favouritesRepository;

    private final LiveData<LeadersSales>  mAllGames;
    private final LiveData<List<FavouriteEntity>> gameFromDatabase;
    private LiveData<GameFromGog> gameFromGogLiveData;

    public MainPageViewModel(Application application) {
        super(application);
        steamRepository = new SteamRepository();
        mAllGames = steamRepository.getLeaders();

        favouritesRepository = new FavouritesRepository(application);
        gameFromDatabase = favouritesRepository.getAllGames();

        gogRepository = new GogRepository();
    }

    void setGameFromGogLiveData(String text) {
        gameFromGogLiveData = gogRepository.getGameGog(text);
    }

    LiveData<GameFromGog> getGameFromGogLiveData() {
        return gameFromGogLiveData;
    }

    LiveData<LeadersSales> getAllGames() {
        return mAllGames;
    }

    LiveData<List<FavouriteEntity>> getGameFromDatabase() { return gameFromDatabase; }
    public void insert(FavouriteEntity game) { favouritesRepository.insert(game); }
    public void delete(FavouriteEntity game) {favouritesRepository.delete(game);}

}
