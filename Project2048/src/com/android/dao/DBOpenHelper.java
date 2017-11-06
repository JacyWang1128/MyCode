package com.android.dao;

import java.io.File;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;

public class DBOpenHelper extends SQLiteOpenHelper 
{
	private static final int VERSION = 1;
	private static final String DBNAME = "mysql.db";
	private static final String PKGNAME = "com.android.Project2048";
	
	public static String getDatabasePath()
	{
		String EXTERN_PATH = null;
		//判断是否存在SD卡
		if(Environment.getExternalStorageState().equals(
		   Environment.MEDIA_MOUNTED)==true)
		{
			//判断是否存在指定文件夹
			EXTERN_PATH = android.os.Environment.getExternalStorageDirectory().getAbsolutePath()
					      +"/Android/data/"+PKGNAME+"/database/";
			File f = new File(EXTERN_PATH);
			if(!f.exists())
			{
				f.mkdirs();
			}	
		}
		return EXTERN_PATH+DBNAME;
	}
	public DBOpenHelper(Context context) 
	{
		super(context, getDatabasePath(), null, VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase arg0) {
		arg0.execSQL("create table userlogin(_id integer primary key,username varchar(20),password varchar(20))");
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		arg0.execSQL("DROP TABLE IF EXISTS userlogin");
		onCreate(arg0);
	}

}
