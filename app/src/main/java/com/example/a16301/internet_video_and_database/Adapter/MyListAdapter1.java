package com.example.a16301.internet_video_and_database.Adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a16301.internet_video_and_database.Datebase.Entity.tranner_article;
import com.example.a16301.internet_video_and_database.R;

import java.util.List;

public class MyListAdapter1 extends RecyclerView.Adapter<MyListAdapter1.MyViewHolder> {

    private Context mContext;
    public List<tranner_article> mDatas;

    public MyListAdapter1(Context context, List<tranner_article> data) {
        this.mContext = context;
        this.mDatas = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.list_item2, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.title.setText(mDatas.get(position).title);
        holder.author.setText(mDatas.get(position).author);
        holder.content.setText(mDatas.get(position).content);
    }

    @Override
    public int getItemCount() {
        if(mDatas == null){
            return 0;
        }else{
            return mDatas.size();
        }
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView author;
        TextView content;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            author = itemView.findViewById(R.id.author);
            content = itemView.findViewById(R.id.content);
        }
    }
    //测试Push
    //测试update
}
