package com.example.a16301.internet_video_and_database.Datebase.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.a16301.internet_video_and_database.Datebase.Entity.tranner_article;

import java.util.List;

@Dao
public interface trainer_article_dao {
    @Query("SELECT * FROM tranner_article")
    List<tranner_article> getAll();

    @Insert
    void insertAll(List<tranner_article> trainer_info);
}
