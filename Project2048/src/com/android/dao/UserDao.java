package com.android.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class UserDao 
{
	private SQLiteDatabase db;

	public UserDao(Context context) 
	{
		super();
		db = new DBOpenHelper(context).getWritableDatabase();
	}
	public long add(String strUserName,String strPwd)
	{
		ContentValues values = new ContentValues();
		values.put("username", strUserName);
		values.put("password", strPwd);
		return db.insert("userlogin", null, values);
	}
	//check用的实例化对象Cursor
	public boolean check(String strUserName,String strPassword) {
		String sql = "select * from userlogin where username=? and password=?";
		Cursor cursor = db.rawQuery(sql,new String[]{strUserName,strPassword});
		if(cursor.moveToFirst()==true){  
            cursor.close();  
            return true;  
        }  
		
		return false;
	}
}
