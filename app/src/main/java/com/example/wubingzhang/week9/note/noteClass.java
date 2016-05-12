package com.example.wubingzhang.week9.note;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by wubingzhang on 4/19/16.
 */
public class noteClass implements Serializable{
    private String title;
    private String content;
    private Date date;

    public noteClass(String title,String content){
        this.content = content;
        this.title = title;
        //this.date = date;
    }

    protected noteClass(Parcel in) {
        title = in.readString();
        content = in.readString();
    }

    public String getTitle(){
        return  title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content){
        this.content = content;
    }


    /*public Date getDate(){
        return  date;
    }

    public void setDate(Date date){
        this.date = date;
    }*/
}
