package com.example.digitalden.data.data_sources.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.digitalden.data.data_sources.room.entites.FavouriteEntity;

import java.util.List;

@Dao
public interface FavDAO {
    @Query("SELECT * FROM fav_table")
    LiveData<List<FavouriteEntity>> getGames();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(FavouriteEntity game);

    @Query("DELETE FROM fav_table WHERE id_game=:idGame")
    void delete(Integer idGame);

    @Query("DELETE FROM fav_table")
    void deleteAll();
}
