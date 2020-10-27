package com.sound.aca.whodoilooklike.DataBase;

//import android.arch.lifecycle.LiveData;
import android.content.Context;

import androidx.sqlite.db.SimpleSQLiteQuery;

import com.sound.aca.whodoilooklike.Models.Celebrity;

import java.util.List;

import io.reactivex.Single;

public class CelebrityRepository {

    private CelebrityDatabase database;

    public CelebrityRepository(Context context) {
         database = CelebrityDatabase.getInstance(context);
    }

        public void insertCelebrity(Celebrity celebrity){
            database.getCelebrityDao().insertCelebrity(celebrity);
        }
    //    public void updateCelebrities(Celebrity celebrity){
    //
    //    }
//    public Celebrity getCelebritiesWithValue(double value){
//
//        return database.getCelebrityDao().getCelebritiesWithValue(new SimpleSQLiteQuery("SELECT * FROM celebrities WHERE ratio36 = ?",
//                new Object[]{value}));
//    }
    public Celebrity getCelebritiesWithValue(String gender,double mNoseRatio,double mRatio36,double mRatio46){

        return database.getCelebrityDao().getCelebritiesWithValue(new SimpleSQLiteQuery("SELECT * FROM celebrities WHERE fOrM = ? ORDER BY ABS( noseRation+ratio36+ratio46 - ?-?-? )LIMIT 1 "

                ,
                new Object[]{gender,mNoseRatio,mRatio36,mRatio46}));
    }
    public List<Celebrity> getCelebrities(){
        return database.getCelebrityDao().getCelebrities();
    }



}
