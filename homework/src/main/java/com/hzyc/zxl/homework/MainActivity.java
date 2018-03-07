package com.hzyc.zxl.homework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //获取菜单填充器
        MenuInflater menuInflater = getMenuInflater();
        //把自定义菜单放到右上角
        menuInflater.inflate(R.menu.one,menu);
        return super.onCreateOptionsMenu(menu);
    }
    //实现菜单选择的方法

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //可以在选择菜单的时候自动触发
        //item (用来区分点的是哪一个)
        int id = item.getItemId();
        switch (id){
            case R.id.insert:
                //Toast.makeText(MainActivity.this, "新建", Toast.LENGTH_SHORT).show();

                break;
            case R.id.select:
                Toast.makeText(MainActivity.this, "查询", Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
