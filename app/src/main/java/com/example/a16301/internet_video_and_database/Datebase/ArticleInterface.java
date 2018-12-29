package com.example.a16301.internet_video_and_database.Datebase;
import com.example.a16301.internet_video_and_database.Datebase.Entity.tranner_article;

import java.util.List;

public interface  ArticleInterface {

    interface LoadInfoListCallBack {

        void onDataNoAvailable();

        void onLoadSuccess(List<tranner_article> list);
    }

    interface GetInfoCallBack {
        void onDataNoAvailable();

        void onLoadSuccess(tranner_article entity);
    }

    void getInfoList(LoadInfoListCallBack callBack);

    void getInfo(String uuid, GetInfoCallBack callBack);

    void addInfo(List<tranner_article> entity);

    void deleteInfo(tranner_article entity);

    void updateInfo(tranner_article entity);

}