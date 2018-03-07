package com.hzyc.zxl.tf_45;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText username,password;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);

        //按钮事件
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //获取控件的值
                String name = username.getText().toString().trim();
                String psd = password.getText().toString().trim();

                if("admin".equals(name) && "admin".equals(psd)){
                    //Android里所有的弹出方法都要用show来显示
                    Toast.makeText(MainActivity.this, "登录成功!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "登录失败!", Toast.LENGTH_SHORT).show();
                }
            }
        });


        //添加单击事件
       /* button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //输出一句话
                //Toast.makeText(MainActivity.this, "我爱你中国", Toast.LENGTH_SHORT).show();
                Toast.makeText(
                        ｝
        });*/
    }
}



