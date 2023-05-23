package com.example.digitalden.data.data_sources.api.gog.service;

import com.example.digitalden.data.models.GameFromGog;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GogService {
    @GET("games/ajax/filtered")
    Call<GameFromGog> getGames(@Query("mediaType") String mediaType, @Query("search") String search);
}
