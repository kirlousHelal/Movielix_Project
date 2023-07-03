package com.example.moviepage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class movieDatabase extends SQLiteOpenHelper {
    private static String databaseName="movieDatabase";
    SQLiteDatabase movieDatabase;
    movieDatabase(Context context)
    {
        super(context,databaseName,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table movie(id integer primary key,name text not null,data text,type text,describtion text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("drop table if exists movie");
    onCreate(db);
    }
    public void create_movie(int id,String name,String data,String type,String describtion)
    {
        ContentValues row=new ContentValues();
        row.put("id",id);
        row.put("name",name);
        row.put("data",data);
        row.put("type",type);
        row.put("describtion",describtion);
        movieDatabase=this.getWritableDatabase();
        movieDatabase.insert("movie",null,row);
        movieDatabase.close();
    }

    public String getData(int id)
    {
        movieDatabase=this.getReadableDatabase();

        String[] arg={String.valueOf(id)};
        Cursor cursor=movieDatabase.rawQuery("Select data from  movie where id like ?",arg);
        cursor.moveToFirst();
        movieDatabase.close();
        return cursor.getString(cursor.getColumnIndex("data"));
    }
    public String getType(int id)
    {
        movieDatabase=this.getReadableDatabase();
        String[] arg={String.valueOf(id)};
        Cursor cursor=movieDatabase.rawQuery("Select type from  movie where id like ?",arg);
        cursor.moveToFirst();
        movieDatabase.close();
        return cursor.getString(cursor.getColumnIndex("type"));
    }
    public String getDescribtion(int id)
    {
        movieDatabase=this.getReadableDatabase();
        String[] arg={String.valueOf(id)};
        Cursor cursor=movieDatabase.rawQuery("Select describtion from  movie where id like ?",arg);
        cursor.moveToFirst();
        movieDatabase.close();
        return cursor.getString(cursor.getColumnIndex("describtion"));
    }
    public  String getNmae(int id)
    {
        movieDatabase=this.getReadableDatabase();
        String[] arg={String.valueOf(id)};
        Cursor cursor=movieDatabase.rawQuery("Select name from  movie where id like ?",arg);cursor.moveToFirst();
        movieDatabase.close();
        return cursor.getString(cursor.getColumnIndex("name"));

    }
    public void deletemovie(String name)
    {
        movieDatabase=this.getWritableDatabase();
        movieDatabase.delete("movie","name='"+name+"'",null);
        movieDatabase.close();
    }
    

}
