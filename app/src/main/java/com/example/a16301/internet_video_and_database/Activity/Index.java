package com.example.a16301.internet_video_and_database.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.a16301.internet_video_and_database.Adapter.MyListAdapter;
import com.example.a16301.internet_video_and_database.Adapter.MyListAdapter1;
import com.example.a16301.internet_video_and_database.AppExecutor;
import com.example.a16301.internet_video_and_database.Datebase.ArticleInterface;
import com.example.a16301.internet_video_and_database.Datebase.CustomInfoSource;
import com.example.a16301.internet_video_and_database.Datebase.CustominfoSource1;
import com.example.a16301.internet_video_and_database.Datebase.DataGenerator;
import com.example.a16301.internet_video_and_database.Datebase.Entity.trainner_info;
import com.example.a16301.internet_video_and_database.Datebase.Entity.tranner_article;
import com.example.a16301.internet_video_and_database.Datebase.InfoSource;
import com.example.a16301.internet_video_and_database.Datebase.datebase.trainer;
import com.example.a16301.internet_video_and_database.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

public class Index extends AppCompatActivity {
    private RecyclerView recyclerView1;
    private List<trainner_info> info;
    private List<tranner_article> info1;
    private MyListAdapter mAdapter;
    private MyListAdapter1 mAdapter1;


    private String TAG = "nihao";
    private RecyclerView recyclerView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);


        recyclerView1 = findViewById(R.id.recycleview1);
        recyclerView2 = findViewById(R.id.recycle_view2);

        mAdapter = new MyListAdapter(this,info);
        mAdapter1 = new MyListAdapter1(this,info1);


        trainer s = trainer.getInstance(this);

        //往数据库中填写数据
//        s.Trainer_info_daos().insertAll(DataGenerator.generateInfo());
//        s.Trainer_article_dao().insertAll(DataGenerator.getarticle());


        //往数据库中读出数据
//        List<trainner_info> info = s.Trainer_info_daos().getAll();
//        List<tranner_article> tranner_articles = s.Trainer_article_dao().getAll();

        info = new ArrayList<>();

        CustomInfoSource source = new CustomInfoSource(s.Trainer_info_daos(),new AppExecutor(Executors.newSingleThreadExecutor(), Executors.newSingleThreadExecutor(), new AppExecutor.MainThreadExecutor()));

//        source.addInfo(DataGenerator.generateInfo());

        source.getInfoList(new InfoSource.LoadInfoListCallBack() {
            @Override
            public void onDataNoAvailable() {
                Log.e(TAG, "没有结果");
            }

            @Override
            public void onLoadSuccess(List<trainner_info> infos) {
                info.addAll(infos);
//                Log.e(TAG, "trainer"+info.toString());
//                for(int i = 0 ; i < info.size();i++){
//                    String a = info.get(i).getName() +info.get(i).getSex()+info.get(i).getPhone()+ info.get(i).getCourse();
//
//                    Log.e(TAG, "trainer"+a);
//                }
                mAdapter.mDatas = info;
                mAdapter.notifyDataSetChanged();
            }
        });

        CustominfoSource1 source1 =  new CustominfoSource1(s.Trainer_article_dao(),new AppExecutor(Executors.newSingleThreadExecutor(), Executors.newSingleThreadExecutor(), new AppExecutor.MainThreadExecutor()));
//        source1.addInfo(DataGenerator.getarticle());

        info1 = new ArrayList<>();
        source1.getInfoList(new ArticleInterface.LoadInfoListCallBack() {
            @Override
            public void onDataNoAvailable() {
                Log.e(TAG, "没有结果");
            }

            @Override
            public void onLoadSuccess(List<tranner_article> infos) {
                info1.addAll(infos);
//                Log.e(TAG, "trainer"+info1.toString());
//                for(int i = 0 ; i < info1.size();i++){
//                    String a = info1.get(i).getTitle() +info1.get(i).getAuthor()+info1.get(i).getContent();
//                    Log.e(TAG, "trainer"+a);
//                }
                mAdapter1.mDatas = info1;
                mAdapter1.notifyDataSetChanged();
            }
        });

        initRecyclerView();
    }

    private void initRecyclerView() {
        //设置布局管理器1
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView1.setLayoutManager(linearLayoutManager);
        recyclerView1.setHasFixedSize(true);
        recyclerView1.setAdapter(mAdapter);
        recyclerView1.addItemDecoration(new DividerItemDecoration(
                this, DividerItemDecoration.HORIZONTAL));

        //设置布局管理器2
        LinearLayoutManager linearLayoutManager1=new LinearLayoutManager(this);
        linearLayoutManager1.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView2.setLayoutManager(linearLayoutManager1);
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setAdapter(mAdapter1);
        recyclerView2.addItemDecoration(new DividerItemDecoration(
                this, DividerItemDecoration.HORIZONTAL));
    }

}
