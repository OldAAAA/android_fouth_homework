package com.example.a16301.internet_video_and_database.Datebase.datebase;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.a16301.internet_video_and_database.Datebase.DAO.trainer_article_dao;
import com.example.a16301.internet_video_and_database.Datebase.DAO.trainer_info_dao;
import com.example.a16301.internet_video_and_database.Datebase.Entity.trainner_info;
import com.example.a16301.internet_video_and_database.Datebase.Entity.tranner_article;

@Database(entities = {trainner_info.class,tranner_article.class},version = 1, exportSchema = false)
public abstract class trainer extends RoomDatabase {
    private static trainer sInstance;
    private static String DATABASE_NAME = "triner";

    public abstract trainer_article_dao Trainer_article_dao();
    public abstract trainer_info_dao Trainer_info_daos();

    public static trainer getInstance(Context context) {
        if (sInstance == null) {
            synchronized (trainer.class) {
                if (sInstance == null) {
                    sInstance = Room.databaseBuilder(context.getApplicationContext(), trainer.class,DATABASE_NAME).build();
                }
            }
        }
        return sInstance;
    }
}
