package com.example.digitalden.data.repositories;


import androidx.lifecycle.LiveData;
import com.example.digitalden.data.data_sources.api.egs.EpicGamesApiRetrofit;
import com.example.digitalden.data.data_sources.api.egs.service.EpicGamesService;
import com.example.digitalden.data.models.FreeGames;
import com.example.digitalden.data.utils.LiveDataUtils;



public class EpicGamesRepository {
    private final EpicGamesService epicGamesService;

    public EpicGamesRepository() {
        this.epicGamesService = EpicGamesApiRetrofit.getInstance().getService();
    }

    public LiveData<FreeGames> getFreeGames() {
        return LiveDataUtils.callToBodyLiveData(epicGamesService.getFreeGames("ru-RU", "RU"));
    }

}
