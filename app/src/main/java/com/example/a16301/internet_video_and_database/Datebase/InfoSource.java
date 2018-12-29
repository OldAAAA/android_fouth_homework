package com.example.a16301.internet_video_and_database.Datebase;

import com.example.a16301.internet_video_and_database.Datebase.Entity.trainner_info;

import java.util.List;

public interface InfoSource {

    interface LoadInfoListCallBack {

        void onDataNoAvailable();

        void onLoadSuccess(List<trainner_info> list);
    }

    interface GetInfoCallBack {
        void onDataNoAvailable();

        void onLoadSuccess(trainner_info entity);
    }

    void getInfoList(LoadInfoListCallBack callBack);

    void getInfo(String uuid, GetInfoCallBack callBack);

    void addInfo(List<trainner_info> entity);

    void deleteInfo(trainner_info entity);

    void updateInfo(trainner_info entity);

}