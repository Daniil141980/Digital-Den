package com.example.digitalden.ui.main.sort;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.example.digitalden.data.models.FilteredGames;
import com.example.digitalden.data.repositories.GogRepository;


public class SortingMainViewModel extends ViewModel {
    private String genre;

    public SortingMainViewModel() {
        genre = "Жанры";
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
