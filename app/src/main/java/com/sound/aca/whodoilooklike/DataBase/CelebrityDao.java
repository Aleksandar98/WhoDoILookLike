package com.sound.aca.whodoilooklike.DataBase;


//import android.arch.lifecycle.LiveData;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.room.Update;
import androidx.sqlite.db.SupportSQLiteQuery;

import com.sound.aca.whodoilooklike.Models.Celebrity;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface CelebrityDao {


    @Insert
    void insertCelebrity(Celebrity...celebrities);

    @Query("SELECT * FROM celebrities")
    List<Celebrity> getCelebrities();
//
//    @Query("SELECT * FROM celebrities WHERE id = :id")
//    LiveData<List<Celebrity>> getCelebritiesWithId(int id);

    @RawQuery
    Celebrity getCelebritiesWithValue(SupportSQLiteQuery query);

    @Insert
    void insertAll(Celebrity...celebrities);
    //@Update
}
