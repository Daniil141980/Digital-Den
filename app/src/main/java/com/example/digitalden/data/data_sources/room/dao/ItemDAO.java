package com.example.digitalden.data.data_sources.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.digitalden.data.data_sources.room.entites.ItemEntity;

import java.util.List;

@Dao
public interface ItemDAO {
    @Query("SELECT * FROM game_table ORDER BY name_game ASC")
    LiveData<List<ItemEntity>> getAlphabetizedWords();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(ItemEntity word);

    @Query("DELETE FROM game_table")
    void deleteAll();
}
