package com.one.apicall.room;

import android.content.Context;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Quote.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static final String databaseName = "quote_database";

    public abstract QuoteDao quoteDao();

    private static volatile AppDatabase INSTANCE;

    public static AppDatabase getInstance(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, databaseName)
                            .allowMainThreadQueries()
                            .build();
                    Log.d("TAG", "New instance created...");
                }
            }
        }
        return INSTANCE;
    }
}