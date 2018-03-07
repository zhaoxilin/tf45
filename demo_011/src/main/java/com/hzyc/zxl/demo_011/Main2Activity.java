package com.hzyc.zxl.demo_011;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {


    private Button createDataBase,upDataBase,editor,call;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        createDataBase = (Button) findViewById(R.id.createDataBase);
        upDataBase = (Button) findViewById(R.id.upDataBase);
        editor = (Button) findViewById(R.id.editor);
        call = (Button) findViewById(R.id.call);

        createDataBase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //得到数据库建库工具类的对象
                MyDbCreate myDbCreate = new MyDbCreate(Main2Activity.this);
                //激活数据库(会调用onCreate方法,只调用一次)
                SQLiteDatabase sqLiteDatabase = myDbCreate.getReadableDatabase();

                //sqLiteDatabase.execSQL("insert into person (name) values ('张三')");
                sqLiteDatabase.execSQL("insert into person (name) values (?)",new Object[]{"李四"});

            }
        });

        upDataBase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //得到数据库建库工具类的对象
                MyDbCreate myDbCreate = new MyDbCreate(Main2Activity.this);
                //激活数据库(会调用onCreate方法,只调用一次)
                SQLiteDatabase sqLiteDatabase = myDbCreate.getReadableDatabase();

                sqLiteDatabase.execSQL("update person set age = 23 where id = 1");
                sqLiteDatabase.execSQL("update person set age = 23 where id = 2");


            }
        });

        editor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //得到数据库建库工具类的对象
                MyDbCreate myDbCreate = new MyDbCreate(Main2Activity.this);
                //激活数据库(会调用onCreate方法,只调用一次)
                SQLiteDatabase sqLiteDatabase = myDbCreate.getReadableDatabase();

                /*sqLiteDatabase.execSQL("insert into person (name,age) values('王五',20)");
                sqLiteDatabase.execSQL("insert into person (name,age) values('小明',21)");
                sqLiteDatabase.execSQL("insert into person (name,age) values('小强',22)");*/

                Cursor cursor = sqLiteDatabase.rawQuery("select * from person",null);

                while(cursor.moveToNext()){
                    String name = cursor.getString(1);
                    String age = cursor.getString(2);
                    Log.i("数据库信息",name+"@@"+age);

                }
            }
        });

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:10010"));
                if (ActivityCompat.checkSelfPermission(Main2Activity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(intent);
            }
        });
    }
}
