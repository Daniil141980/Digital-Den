package com.example.digitalden.data.data_sources.api.gog;

import com.example.digitalden.data.data_sources.api.gog.service.GogService;
import com.example.digitalden.data.models.OneGame;
import com.example.digitalden.data.utils.OneGameDeserializer;
import com.google.common.reflect.TypeToken;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GogApiRetrofit {
    private static volatile GogApiRetrofit INSTANCE;
    private static final String URL = "https://embed.gog.com/";

    private final Retrofit retrofit;


    public GogApiRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory
                        .create(new GsonBuilder().registerTypeAdapter(new TypeToken<List<OneGame>>() {
                        }.getType(), new OneGameDeserializer()).create()))
                .build();
    }

    public static GogApiRetrofit getInstance() {
        if (INSTANCE == null) {
            synchronized (GogApiRetrofit.class) {
                if (INSTANCE == null) {
                    INSTANCE = new GogApiRetrofit();
                }
            }
        }
        return INSTANCE;
    }

    public GogService getService() {
        return retrofit.create(GogService.class);
    }
}
