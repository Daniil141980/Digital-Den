package com.example.digitalden.data.repositories;

import android.app.Application;
import android.view.animation.Transformation;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import com.example.digitalden.data.data_sources.room.dao.ItemDAO;
import com.example.digitalden.data.data_sources.room.entites.ItemEntity;
import com.example.digitalden.data.data_sources.room.root.AppDatabase;
import com.example.digitalden.data.models.Item;

import java.util.List;
import java.util.stream.Collectors;

public class ItemsRepository {
    private ItemDAO mWordDao;
    private LiveData<List<ItemEntity>> mAllWords;

    public ItemsRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        mWordDao = db.itemDAO();
        mAllWords = mWordDao.getAlphabetizedWords();
    }

    public LiveData<List<ItemEntity>> getAllWords() {
        return mAllWords;
    }


    public void insert(ItemEntity word) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            mWordDao.insert(word);
        });
    }
}
