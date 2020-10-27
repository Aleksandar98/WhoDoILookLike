package com.sound.aca.whodoilooklike.DataBase;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.sound.aca.whodoilooklike.Models.Celebrity;
import com.sound.aca.whodoilooklike.Models.CelebrityData;


import java.util.concurrent.Executors;

@Database(entities = {Celebrity.class},version = 1)
public abstract class CelebrityDatabase extends RoomDatabase {

    public static final String DATABASE_NAME = "celebrities_db";

    private static CelebrityDatabase instance;

    static CelebrityDatabase getInstance(final Context context){
        if(instance==null){
            instance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    CelebrityDatabase.class,
                    DATABASE_NAME
            ).addCallback(new Callback() {
                @Override
                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                    super.onCreate(db);
                    Executors.newSingleThreadExecutor().execute(new Runnable() {
                        @Override
                        public void run() {
                            instance.getCelebrityDao().insertAll(CelebrityData.populateData());
                        }
                    });
                }
            })
                    .build();

        }return instance;
    }

    public abstract CelebrityDao getCelebrityDao();
}
