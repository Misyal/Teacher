package com.example.teacher.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TeacherHelper extends SQLiteOpenHelper {


    public TeacherHelper( Context context, String name,SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "uesr.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String creatsql="CREATE TABLE IF NOT EXISTS Teacher(TeacherId VARCHAR PRIMARY KEY NOT NULL,TeacherPwd VARCHAR NOT NULL);";
        db.execSQL(creatsql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public int qureyId(SQLiteDatabase db,String TId,String TPwd){
        Cursor cursor=db.query("Teacher",new String[]{"TeacherPwd"},"TeacherId=?",new String[]{TId},null,null,null);
        int result=-1;
        if(cursor.moveToNext()){
           String pwd=cursor.getString(cursor.getColumnIndex("TeacherPwd"));
           if(pwd.equals(TPwd)){
               result=1;
           }

        }
        return  result;
    }


}
