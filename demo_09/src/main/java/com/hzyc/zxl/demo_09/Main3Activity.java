package com.hzyc.zxl.demo_09;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    private Button popUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        popUp = (Button) findViewById(R.id.popUp);

        popUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(Main3Activity.this,v);
                popupMenu.getMenuInflater().inflate(R.menu.one,popupMenu.getMenu());
                //android里所有弹出的内容都要加show()
                popupMenu.show();
                //实现菜单选择的方法
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int id = item.getItemId();
                        switch (id){
                            case R.id.save:
                                Toast.makeText(Main3Activity.this, "保存", Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.update:
                                Toast.makeText(Main3Activity.this, "更新", Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.delete:
                                Toast.makeText(Main3Activity.this, "删除", Toast.LENGTH_SHORT).show();
                                return true;
                        }

                        return false;
                    }
                });
            }
        });
    }
}
