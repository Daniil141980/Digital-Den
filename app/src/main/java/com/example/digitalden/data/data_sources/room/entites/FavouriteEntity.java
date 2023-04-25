package com.example.digitalden.data.data_sources.room.entites;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.digitalden.data.models.Item;

@Entity(tableName = "fav_table")
public class FavouriteEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "name_game")
    private String nameGame;

    public FavouriteEntity() {}

    public FavouriteEntity(@NonNull String value) {
        this.nameGame = value;
    }

    @NonNull
    public String getNameGame() {
        return this.nameGame;
    }
}
