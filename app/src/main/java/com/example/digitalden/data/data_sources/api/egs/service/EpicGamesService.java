package com.example.digitalden.data.data_sources.api.egs.service;

import com.example.digitalden.data.models.FreeGames;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface EpicGamesService {
    @GET("freeGamesPromotions")
        Call<FreeGames> getFreeGames(@Query("locale") String locale, @Query("country") String country);
}
