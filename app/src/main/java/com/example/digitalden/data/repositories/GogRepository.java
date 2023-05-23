package com.example.digitalden.data.repositories;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.example.digitalden.data.data_sources.api.gog.GogApiRetrofit;
import com.example.digitalden.data.data_sources.api.gog.service.GogService;
import com.example.digitalden.data.models.GameFromGog;
import com.example.digitalden.data.utils.LiveDataUtils;


public class GogRepository {
    private final GogService gogService;

    public GogRepository() {
        this.gogService = GogApiRetrofit.getInstance().getService();
    }

    public LiveData<GameFromGog> getGameGog(String gameName) {
        return LiveDataUtils.callToBodyLiveData(gogService.getGames("game", gameName));
    }

}
