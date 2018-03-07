package com.hzyc.yy.demo_08;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //如果使用组件  给其他的类传值 （只能使用构造方法 activity  传值给  adapter）
    //如果组件之间传值  （不能使用构造方法的  使用的是intent）
    private EditText toValue;
    private Button toTwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toValue = (EditText) findViewById(R.id.toValue);
        toTwo = (Button) findViewById(R.id.toTwo);

        toTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = toValue.getText().toString().trim();
                //1.直接使用意图 设计的时候（map  .put("key"，value)）
                //类似于请求转发
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
               /* intent.putExtra("name",value);
                startActivity(intent);*/

                //2.javaBean (model 模型（开发的时候使用模型来开发 使用模型来传值）)
                //v 视图  C 控制   访问数据库操作也的类
                //公共的bean对象

                Bundle bundle = new Bundle();
                bundle.putString("name",value);
                bundle.putInt("age",23);
                bundle.putString("sex","男");
                intent.putExtras(bundle);
                //startActivity(intent);//不期待的结果的
                startActivityForResult(intent,0);//如果结果回来了会激活另外一个函数  ---1
                //动画效果（画面转移位置动画效果）
                overridePendingTransition(R.anim.tip_right,R.anim.tip_left);
            }
        });

        SharedPreferences spf = getSharedPreferences("data",0);
        String name = spf.getString("name","nothing");
        //需要保护
        if(!"nothing".equals(name)){
            toValue.setText(name);
        }
    }

    //------3
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 0 && resultCode == 200){
            Toast.makeText(MainActivity.this, ""+data.getStringExtra("back"), Toast.LENGTH_SHORT).show();
        }
    }
    //保护现场

    @Override
    //保存数据的状态变化
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //判断保护的值是否存在
        String value = toValue.getText().toString().trim();
        if("".equals(value)){
            Toast.makeText(MainActivity.this, "不需要保护", Toast.LENGTH_SHORT).show();
        }else{
            //xml存储在手机中
            //会在手机内存中检索有没有这个文件，没有则新建，有则获取
            SharedPreferences spf = getSharedPreferences("data",0);
            //存储 编辑 得到这个文件的编辑权限
            SharedPreferences.Editor editor = spf.edit();
           //key是要存储的xml文件的名。value是要保护的值
            editor.putString("name",value);
            //提交事务
            boolean bol = editor.commit();//返回一个布尔值
            Toast.makeText(MainActivity.this, "保护成功"+true, Toast.LENGTH_SHORT).show();
            //查看存储到了哪里

        }
    }
}
