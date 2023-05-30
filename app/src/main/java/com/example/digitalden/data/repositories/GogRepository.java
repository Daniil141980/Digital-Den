package com.example.digitalden.data.repositories;

import androidx.lifecycle.LiveData;
import com.example.digitalden.data.data_sources.api.gog.GogApiRetrofit;
import com.example.digitalden.data.data_sources.api.gog.service.GogService;
import com.example.digitalden.data.models.FilteredGames;
import com.example.digitalden.data.models.GameFromGog;
//import com.example.digitalden.data.models.GameWithSort;
import com.example.digitalden.data.utils.LiveDataUtils;


public class GogRepository {
    private final GogService gogService;

    public GogRepository() {
        this.gogService = GogApiRetrofit.getInstance().getService();
    }

    public LiveData<GameFromGog> getGameGog(String gameName) {
        return LiveDataUtils.callToBodyLiveData(gogService.getGames("game", gameName));
    }

    public LiveData<FilteredGames> getFilteredGame(String category) {
        return LiveDataUtils.callToBodyLiveData(gogService.getFilteredGames("game", category));
    }

}
