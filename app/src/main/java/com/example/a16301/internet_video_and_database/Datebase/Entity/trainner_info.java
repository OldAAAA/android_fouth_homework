package com.example.a16301.internet_video_and_database.Datebase.Entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class trainner_info extends entity {
    @PrimaryKey
    public int tid;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {

        return name;
    }

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "sex")
    public String sex;

    @ColumnInfo(name = "phone")
    public String phone;

    @ColumnInfo(name = "course")
    public String course;

    public void setTid(int tid) {
        this.tid = tid;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getTid() {

        return tid;
    }

    public String getSex() {
        return sex;
    }

    public String getPhone() {
        return phone;
    }

    public String getCourse() {
        return course;
    }


}
