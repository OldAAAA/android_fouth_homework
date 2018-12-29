package com.example.a16301.internet_video_and_database.Datebase;

import android.support.annotation.NonNull;

import com.example.a16301.internet_video_and_database.AppExecutor;
import com.example.a16301.internet_video_and_database.Datebase.DAO.trainer_info_dao;
import com.example.a16301.internet_video_and_database.Datebase.Entity.trainner_info;

import java.util.List;

public class CustomInfoSource implements InfoSource {

    private trainer_info_dao dao;
    private AppExecutor appExecutor;

    public CustomInfoSource(@NonNull trainer_info_dao dao, @NonNull AppExecutor appExecutor) {
        this.dao = dao;
        this.appExecutor = appExecutor;
    }

    @Override
    public void getInfoList(final LoadInfoListCallBack callBack) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                final List<trainner_info> infoList = dao.getAll();
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
    public void addInfo(final List<trainner_info> entity) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                dao.insertAll(entity);
            }
        };

        appExecutor.getDiskIO().execute(runnable);
    }

    @Override
    public void deleteInfo(trainner_info entity) {

    }

    @Override
    public void updateInfo(trainner_info entity) {

    }
}