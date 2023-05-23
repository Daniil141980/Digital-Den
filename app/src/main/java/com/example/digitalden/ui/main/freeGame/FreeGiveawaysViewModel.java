package com.example.digitalden.ui.main.freeGame;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.digitalden.data.models.FreeGames;
import com.example.digitalden.data.models.LeadersSales;
import com.example.digitalden.data.repositories.EpicGamesRepository;


public class FreeGiveawaysViewModel extends ViewModel {
    private EpicGamesRepository epicGamesRepository;

    private final LiveData<FreeGames> freeGames;

    public FreeGiveawaysViewModel() {
        epicGamesRepository = new EpicGamesRepository();
        freeGames = epicGamesRepository.getFreeGames();

    }
    LiveData<FreeGames> getFreeGames() {
        return freeGames;
    }

}
