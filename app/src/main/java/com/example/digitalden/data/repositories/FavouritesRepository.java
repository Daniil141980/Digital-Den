package com.example.digitalden.data.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.digitalden.data.data_sources.room.dao.FavDAO;
import com.example.digitalden.data.data_sources.room.dao.ItemDAO;
import com.example.digitalden.data.data_sources.room.entites.FavouriteEntity;
import com.example.digitalden.data.data_sources.room.entites.ItemEntity;
import com.example.digitalden.data.data_sources.room.AppDatabase;

import java.util.List;

public class FavouritesRepository {
    private FavDAO mGameDAO;
    private LiveData<List<FavouriteEntity>> mAllGames;

    public FavouritesRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        mGameDAO = db.favDAO();
        mAllGames = mGameDAO.getGames();
    }

    public LiveData<List<FavouriteEntity>> getAllGames() {
        return mAllGames;
    }


    public void insert(FavouriteEntity game) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            mGameDAO.insert(game);
        });
    }

    public void delete(FavouriteEntity game) {
        AppDatabase.databaseWriteExecutor.execute(() ->{
            mGameDAO.delete(game.getIdGame());
        });
    }
}
