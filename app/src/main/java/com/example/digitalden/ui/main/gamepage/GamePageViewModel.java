package com.example.digitalden.ui.main.gamepage;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.digitalden.data.models.OneGame;
import com.example.digitalden.data.repositories.SteamRepository;

import java.util.List;

public class GamePageViewModel extends ViewModel {
    private SteamRepository steamRepository;

    private LiveData<List<OneGame>>  aboutGame;

    public GamePageViewModel() {
        steamRepository = new SteamRepository();
    }


    public void setAboutGame(List<Integer> appIds){
        aboutGame = steamRepository.getOneGame(appIds);
    }

    LiveData<List<OneGame>> getAboutGame() {
        return aboutGame;
    }
}
