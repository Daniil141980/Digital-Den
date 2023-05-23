package com.example.digitalden.data.repositories;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.example.digitalden.data.data_sources.api.steam.SteamApiRetrofit;
import com.example.digitalden.data.data_sources.api.steam.service.SteamAllGamesService;
import com.example.digitalden.data.data_sources.api.steam.service.SteamService;
import com.example.digitalden.data.models.AllGamesFromSteam;
import com.example.digitalden.data.models.LeadersSales;
import com.example.digitalden.data.models.OneGame;
import com.example.digitalden.data.models.PriceGame;
import com.example.digitalden.data.utils.LiveDataUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SteamRepository {
    private final SteamService steamService;
    private final SteamAllGamesService steamAllGamesService;

    public SteamRepository() {
        this.steamService = SteamApiRetrofit.getInstance().getService();
        this.steamAllGamesService = SteamApiRetrofit.getInstance().getServiceForAllGames();
    }

    public LiveData<LeadersSales> getLeaders() {
        return LiveDataUtils.callToBodyLiveData(steamService.getSalesLeader("ru", "russian"));
    }

    public LiveData<AllGamesFromSteam> getAllGames() {
        return LiveDataUtils.callToBodyLiveData(steamAllGamesService.getAllGames());
    }

    public LiveData<List<OneGame>> getOneGame(List<Integer> appIds, PriceFilters... filters) {
        return LiveDataUtils.callToListLiveData(steamService.getInfoAboutOneGame(
                appIds.stream().map(Object::toString).collect(Collectors.joining(",")),
                Arrays.stream(filters).map(PriceFilters::toString).collect(Collectors.joining(",")),
                "ru", "russian"));
    }

    public LiveData<List<PriceGame>> getPrices(List<Integer> appIds, PriceFilters... filters) {
        return LiveDataUtils.callToListLiveData(steamService.getPrice(
                appIds.stream().map(Object::toString).collect(Collectors.joining(",")),
                Arrays.stream(filters).map(PriceFilters::toString).collect(Collectors.joining(","))
        ));
    }

    public enum PriceFilters {
        BASIC("basic"), PRICE_OVERVIEW("price_overview");

        private final String value;

        PriceFilters(String value) {
            this.value = value;

        }

        @NonNull
        @Override
        public String toString() {
            return value;
        }

    }
}
