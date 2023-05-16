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

    @ColumnInfo(name = "id_game")
    private Integer idGame;

    @ColumnInfo(name = "img")
    private String imgUrl;

    @ColumnInfo(name = "sale")
    private String salePercent;

    @ColumnInfo(name = "base_price")
    private Integer basePrice;

    public FavouriteEntity() {}

    public FavouriteEntity(@NonNull String nameGame, @NonNull Integer idGame, @NonNull String imgUrl, @NonNull String salePercent, @NonNull Integer basePrice) {
        this.nameGame = nameGame;
        this.idGame = idGame;
        this.imgUrl = imgUrl;
        this.salePercent = salePercent;
        this.basePrice = basePrice;
    }

    @NonNull
    public String getNameGame() {
        return this.nameGame;
    }

    public void setNameGame(String nameGame) {
        this.nameGame = nameGame;
    }

    public Integer getIdGame() {
        return this.idGame;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public void setIdGame(Integer idGame) {
        this.idGame = idGame;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setSalePercent(String salePercent) {
        this.salePercent = salePercent;
    }

    public void setBasePrice(Integer basePrice) {
        this.basePrice = basePrice;
    }

    public String getSalePercent() {
        return this.salePercent;
    }

    public Integer getBasePrice() {
        return this.basePrice;
    }
}
