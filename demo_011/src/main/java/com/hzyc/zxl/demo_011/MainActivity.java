package com.hzyc.zxl.demo_011;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private Button save,read;
    private EditText username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.two);

        save = (Button) findViewById(R.id.save);
        read = (Button) findViewById(R.id.read);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        /*save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = username.getText().toString().trim();
                String psd = password.getText().toString().trim();
                //创建data.xml文件
                SharedPreferences sharedPreferences = getSharedPreferences("data",0);
                //得到文件的编辑权限
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name",name);
                editor.putString("psd",psd);

                boolean bol = editor.commit();
                Toast.makeText(MainActivity.this, "保存"+bol, Toast.LENGTH_SHORT).show();

            }
        });

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取data.xml文件
                SharedPreferences sharedPreferences = getSharedPreferences("data",0);
                String name = sharedPreferences.getString("name","nothingName");
                String psd = sharedPreferences.getString("psd","nothingPassword");

                Toast.makeText(MainActivity.this, "名称"+name+"@@密码"+psd,Toast.LENGTH_SHORT).show();

            }
        });
*/
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileOutputStream out = null;
                boolean bol =false;

                try {
                    String name = username.getText().toString().trim();
                    String psd = password.getText().toString().trim();

                    out = openFileOutput("data.txt",0);
                    String value = name+"@@"+psd;
                    out.write(value.getBytes());
                    bol = true;
                    out.close();
                    Toast.makeText(MainActivity.this, "保存"+bol, Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileInputStream input = null;
                try {
                    input = openFileInput("data.txt");
                    byte[] data = new byte[1024];

                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                    int len = 0;
                    while ((len=input.read(data))!=-1){
                        out.write(data,0,len);
                    }
                    //转换为字符串
                    String str = out.toString();
                    String [] str1 = str.split("@@");
                    Toast.makeText(MainActivity.this, str1[0], Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, str1[1], Toast.LENGTH_SHORT).show();

                    input.close();
                    out.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


    }
}
