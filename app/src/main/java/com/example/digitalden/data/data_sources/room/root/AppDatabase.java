package com.example.digitalden.data.data_sources.room.root;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.digitalden.data.data_sources.room.dao.ItemDAO;
import com.example.digitalden.data.data_sources.room.entites.ItemEntity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {ItemEntity.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ItemDAO itemDAO();

    private static volatile AppDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);


    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AppDatabase.class, "word_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
                ItemDAO dao = INSTANCE.itemDAO();
                dao.deleteAll();

                ItemEntity word = new ItemEntity("Horizon zero dawn");
                dao.insert(word);
                word = new ItemEntity("Dishonored");
                dao.insert(word);
                word = new ItemEntity("Konskaya zalupa");
                dao.insert(word);
                word = new ItemEntity("YA LUBLU HARDCODE");
                dao.insert(word);
            });
        }
    };
}
