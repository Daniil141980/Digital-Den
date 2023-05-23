package com.example.digitalden.data.data_sources.api.steam.service;

import com.example.digitalden.data.models.LeadersSales;
import com.example.digitalden.data.models.OneGame;
import com.example.digitalden.data.models.PriceGame;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SteamService {
    @GET("api/appdetails/")
    Call<List<PriceGame>> getPrice(@Query("appids") String appId, @Query("filters") String filters);

    @GET("api/appdetails/")
    Call<List<OneGame>> getInfoAboutOneGame(@Query("appids") String app_id, @Query("filters") String filters,
                                @Query("cc") String price_country, @Query("l") String language);

    @GET("api/featuredcategories/")
    Call<LeadersSales> getSalesLeader(@Query("cc") String price_country, @Query("l") String language);

}
