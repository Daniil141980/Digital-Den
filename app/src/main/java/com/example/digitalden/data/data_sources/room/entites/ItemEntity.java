package com.example.digitalden.data.data_sources.room.entites;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.digitalden.data.models.Item;

@Entity(tableName = "game_table")
public class ItemEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "name_game")
    private String nameGame;

    public ItemEntity() {}

    public ItemEntity(@NonNull String value) {
        this.nameGame = value;
    }

    @NonNull
    public String getNameGame() {
        return this.nameGame;
    }

    public void setNameGame(String nameGame) {
        this.nameGame = nameGame;
    }
}
