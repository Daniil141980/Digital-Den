package com.example.digitalden.data.data_sources.api.steam;

import com.example.digitalden.data.data_sources.api.steam.service.SteamService;
import com.example.digitalden.data.models.OneGame;
import com.example.digitalden.data.utils.OneGameDeserializer;
import com.google.common.reflect.TypeToken;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SteamApiRetrofit {
    private static volatile SteamApiRetrofit INSTANCE;
    private static final String URL = "https://store.steampowered.com/";

    private final Retrofit retrofit;


    public SteamApiRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory
                        .create(new GsonBuilder().registerTypeAdapter(new TypeToken<List<OneGame>>() {
                        }.getType(), new OneGameDeserializer()).create()))
                .build();
    }

    public static SteamApiRetrofit getInstance() {
        if (INSTANCE == null) {
            synchronized (SteamApiRetrofit.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SteamApiRetrofit();
                }
            }
        }
        return INSTANCE;
    }

    public SteamService getService() {
        return retrofit.create(SteamService.class);
    }
}
