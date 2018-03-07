package com.hzyc.zxl.demo_012;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button createDataBase,updateData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createDataBase = (Button) findViewById(R.id.createDataBase);
        updateData = (Button) findViewById(R.id.updateData);


        createDataBase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDbCreate mc = new MyDbCreate(MainActivity.this);
                //激活数据库 获取操作对象
                SQLiteDatabase sqLiteDatabase = mc.getReadableDatabase();

            }
        });

        updateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDbCreate mc = new MyDbCreate(MainActivity.this);
                //激活数据库 获取操作对象
                SQLiteDatabase sqLiteDatabase = mc.getReadableDatabase();
                //非Sql模式  ORM模式
               /* ContentValues contentValues = new ContentValues();
                contentValues.put("name","张三");
                contentValues.put("age",23);
                long i = sqLiteDatabase.insert("person",null,contentValues);
                Log.i("数据库信息","@@@@"+i);*/

                /*ContentValues contentValues = new ContentValues();
                contentValues.put("name","王五");
                contentValues.put("age",30);
                long i = sqLiteDatabase.update("person",contentValues,"where id = ?",new String[]{"1"});*/
               // Log.i("数据库信息","@@@@"+i);

                Cursor cursor = sqLiteDatabase.query("person",new String[]{"name","age"},null,null,null,null,null);
                while(cursor.moveToNext()){
                    String name = cursor.getString(cursor.getColumnIndex("name"));
                    int age = cursor.getInt(cursor.getColumnIndex("age"));
                    Log.i("数据库信息",name+"@@@@"+age);
                }

            }
        });
    }
}
