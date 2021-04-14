package com.example.mlearning;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {


    public DBHelper( Context context) {
        super(context, "UserData.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Userdetails(name TEXT primary key,password TEXT,confirmpassword TEXT,emailid TEXT,contact TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists Userdetails ");
    }

    public Boolean insertData(String name,String password,String confirmpassword,String emailid,String contact){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("password",password);
        contentValues.put("confirmpassword",confirmpassword);
        contentValues.put("emailid",emailid);
        contentValues.put("contact",contact);

        long result = DB.insert("Userdetails",null,contentValues);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }

    public Cursor readData(){
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("select * from Userdetails",null);
        return cursor;

    }

    public Boolean updateData(String name,String emailid,String contact){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("contact",contact);
        Cursor cursor = DB.rawQuery("select * from Userdetails where emailid = ?",new String[]{emailid});
        if(cursor.getCount()>0){
            long result = DB.update("Userdetails",contentValues,"emailid=?",new String[]{emailid});
            if(result == -1){
                return false;
            }else{
                return true;
            }
        }else{
            return false;
        }
    }

    public Boolean deleteData(String emailid){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("select * from Userdetails where emailid=?",new String[]{emailid});
        if(cursor.getCount()>0){
            long result = DB.delete("Userdetails","emailid=?",new String[]{emailid});
            if(result == -1){
                return false;
            }else{
                return true;
            }
        }else{
            return false;
        }

    }


    public Boolean checkLoginData(String emailid, String password){
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("select * from Userdetails where emailid = ? and password = ?", new String[] {emailid,password});
        if(cursor.getCount() > 0){
            return true;
        }else{
            return false;
        }
    }

    //for reset password
    public Boolean checkEmailId(String emailid){
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("select * from Userdetails where emailid = ?",new String[]{emailid});
        if(cursor.getCount() >0){
            return true;
        }else{
            return false;
        }
    }

    public Boolean updatePassword(String emailid,String password){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("password",password);
        long result = DB.update("Userdetails",contentValues,"emailid = ?",new String[]{emailid});
        if(result == -1){
            return false;
        }else{
            return true;
        }

    }
}
