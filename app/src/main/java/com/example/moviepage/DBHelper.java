package com.example.moviepage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper {

    public static final String DBName="Login.db";

    public DBHelper(Context context) {
        super(context, DBName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase mydb) {
        mydb.execSQL("create Table users(username TEXT primary key,password TEXT,email TEXT ,phonenumber TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase mydb, int oldVersion, int newVersion) {
        mydb.execSQL("drop Table if exists users");
    }

    public Boolean insertData(String username,String password,String email,String phonenumber)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        contentValues.put("email",email);
        contentValues.put("phonenumber",phonenumber);

        long result=db.insert("users",null,contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }
    public Boolean updatepassword(String email,String password)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("password",password);

        long result=db.update("users",contentValues,"email = ?",new String[] {email});
        if(result==-1)
            return false;
        else
            return true;
    }

    public Boolean checkusername(String username)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor= db.rawQuery("select * from users where username= ?",new String[] {username});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public Boolean checkusernamepassword(String username,String password)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from users where username= ? and password= ?",new String[] {username,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public Boolean checkemail(String email)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from users where email= ?",new String[] {email});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
}



