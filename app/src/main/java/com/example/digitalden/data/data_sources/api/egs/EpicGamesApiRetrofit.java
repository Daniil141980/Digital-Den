package com.example.digitalden.data.data_sources.api.egs;

import com.example.digitalden.data.data_sources.api.egs.service.EpicGamesService;
import com.example.digitalden.data.models.OneGame;
import com.example.digitalden.data.utils.OneGameDeserializer;
import com.google.common.reflect.TypeToken;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EpicGamesApiRetrofit {
    private static volatile EpicGamesApiRetrofit INSTANCE;
    private static final String URL = "https://store-site-backend-static.ak.epicgames.com/";

    private final Retrofit retrofit;


    public EpicGamesApiRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory
                        .create(new GsonBuilder().registerTypeAdapter(new TypeToken<List<OneGame>>() {
                        }.getType(), new OneGameDeserializer()).create()))
                .build();
    }

    public static EpicGamesApiRetrofit getInstance() {
        if (INSTANCE == null) {
            synchronized (EpicGamesApiRetrofit.class) {
                if (INSTANCE == null) {
                    INSTANCE = new EpicGamesApiRetrofit();
                }
            }
        }
        return INSTANCE;
    }

    public EpicGamesService getService() {
        return retrofit.create(EpicGamesService.class);
    }
}
