package com.example.digitalden.data.data_sources.api.steam.service;

import com.example.digitalden.data.models.AllGamesFromSteam;

import retrofit2.Call;
import retrofit2.http.GET;


public interface SteamAllGamesService {
    @GET("ISteamApps/GetAppList/v2/")
    Call<AllGamesFromSteam> getAllGames();
}
