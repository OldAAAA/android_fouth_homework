package com.example.a16301.internet_video_and_database.Datebase;

import android.support.annotation.NonNull;

import com.example.a16301.internet_video_and_database.AppExecutor;
import com.example.a16301.internet_video_and_database.Datebase.DAO.trainer_article_dao;
import com.example.a16301.internet_video_and_database.Datebase.DAO.trainer_info_dao;
import com.example.a16301.internet_video_and_database.Datebase.Entity.trainner_info;
import com.example.a16301.internet_video_and_database.Datebase.Entity.tranner_article;

import java.util.List;

public class CustominfoSource1 implements ArticleInterface {

    private trainer_article_dao dao;
    private AppExecutor appExecutor;

    public CustominfoSource1(@NonNull trainer_article_dao dao, @NonNull AppExecutor appExecutor) {
        this.dao = dao;
        this.appExecutor = appExecutor;
    }

    @Override
    public void getInfoList(final LoadInfoListCallBack callBack) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                final List<tranner_article> infoList = dao.getAll();
                appExecutor.getMainThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        if (infoList == null || infoList.size() == 0) {
                            callBack.onDataNoAvailable();
                        } else {
                            callBack.onLoadSuccess(infoList);
                        }
                    }
                });

            }
        };

        appExecutor.getDiskIO().execute(runnable);
    }

    @Override
    public void getInfo(String uuid, GetInfoCallBack callBack) {

    }

    @Override
    public void addInfo(final List<tranner_article> entity) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                dao.insertAll(entity);
            }
        };

        appExecutor.getDiskIO().execute(runnable);
    }

    @Override
    public void deleteInfo(tranner_article entity) {

    }

    @Override
    public void updateInfo(tranner_article entity) {

    }
}