package com.example.a16301.internet_video_and_database.Datebase.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.a16301.internet_video_and_database.Datebase.Entity.trainner_info;

import java.util.List;

@Dao
public interface trainer_info_dao {
    @Query("SELECT * FROM trainner_info")
    List<trainner_info> getAll();

    @Insert
    void insertAll(List<trainner_info> trainer_info_daos);
}
