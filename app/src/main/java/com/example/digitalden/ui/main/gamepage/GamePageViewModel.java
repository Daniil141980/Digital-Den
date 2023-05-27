package com.example.digitalden.ui.main.gamepage;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.digitalden.data.models.AllGamesFromSteam;
import com.example.digitalden.data.models.GameFromGog;
import com.example.digitalden.data.models.OneGame;
import com.example.digitalden.data.repositories.GogRepository;
import com.example.digitalden.data.repositories.SteamRepository;

import java.util.List;

public class GamePageViewModel extends ViewModel {
    private SteamRepository steamRepository;
    private GogRepository gogRepository;

    private LiveData<List<OneGame>>  aboutGame;
    private LiveData<GameFromGog>  gameFromGog;
    private  LiveData<AllGamesFromSteam> allGamesFromSteam;

    public GamePageViewModel() {
        steamRepository = new SteamRepository();
        gogRepository = new GogRepository();
        allGamesFromSteam = steamRepository.getAllGames();
    }


    public void setAboutGame(List<Integer> appIds){
        aboutGame = steamRepository.getOneGame(appIds);
    }

    public void setGameFromGog(String gameName) {
        gameFromGog = gogRepository.getGameGog(gameName);
    }

    LiveData<List<OneGame>> getAboutGame() {
        return aboutGame;
    }
    LiveData<GameFromGog> getGameFromGog() {
        return gameFromGog;
    }
    LiveData<AllGamesFromSteam> getAllGames() {
        return allGamesFromSteam;
    }
}
