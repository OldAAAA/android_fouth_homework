package com.example.a16301.internet_video_and_database.Adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a16301.internet_video_and_database.Datebase.Entity.trainner_info;
import com.example.a16301.internet_video_and_database.R;

import java.util.List;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.MyViewHolder> {

    private Context mContext;
    public List<trainner_info> mDatas;

    public MyListAdapter(Context context, List<trainner_info> data) {
        this.mContext = context;
        this.mDatas = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.list_item1, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.name.setText(mDatas.get(position).name);
        holder.sex.setText(mDatas.get(position).sex);
        holder.phone.setText(mDatas.get(position).phone);
        holder.course.setText(mDatas.get(position).course);
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
        TextView name;
        TextView sex;
        TextView phone;
        TextView course;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            sex = itemView.findViewById(R.id.sex);
            phone = itemView.findViewById(R.id.phone);
            course = itemView.findViewById(R.id.course);
        }
    }
    //测试Push
    //测试update
}
