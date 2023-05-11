package com.example.digitalden.data.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.digitalden.data.data_sources.room.dao.ItemDAO;
import com.example.digitalden.data.data_sources.room.entites.ItemEntity;
import com.example.digitalden.data.data_sources.room.AppDatabase;

import java.util.List;

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
