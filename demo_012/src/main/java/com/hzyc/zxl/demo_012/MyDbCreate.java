package com.hzyc.zxl.demo_012;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Administrator on 2018/2/26 0026.
 */
public class MyDbCreate extends SQLiteOpenHelper{

    private static final String DB_NAME = "data.db";

    //private static final int VERSION = 1;
    private static final int VERSION = 2;

    public MyDbCreate(Context context) {
        super(context, DB_NAME, null, VERSION);
        Log.i("数据库消息","构造函数");

    }

    @Override
    //创建数据库表
    public void onCreate(SQLiteDatabase db) {
        boolean bol = false;
        db.execSQL("create table person (id integer primary key autoincrement,name varchar(10))");
        bol = true;
        Log.i("数据库消息","创建状态="+bol);
    }

    @Override
    //更新数据库表
    //更新时把MyDbCreate中的版本号改为其他整数，如2，这样再次激活的时候，就会调用onUpgrade()方法
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        boolean bol = false;
        db.execSQL("alter table person add age int(10)");
        bol = true;
        Log.i("数据库消息","更新状态="+bol);
    }
}
