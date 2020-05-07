package com.example.teacher.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class CourseHelper extends SQLiteOpenHelper {
    public CourseHelper( Context context,String name,SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String creatsql="CREATE TABLE IF NOT EXISTS Courese(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,Cname VARCHAR NOT NULL,"
        +"TNum VARCHAR NOT NULL);";
        db.execSQL(creatsql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public ArrayList<String> qCourse(SQLiteDatabase db, String TNum){
        ArrayList<String> cname;
        cname=new ArrayList<String>();
        Cursor cursor=db.query("Course",new String[]{"Cname"},"TNum=?",new String[]{TNum},null,null,null);
        while (cursor.moveToNext()){
            cname.add(cursor.getString(0));
        }
        return cname;
    }
}
