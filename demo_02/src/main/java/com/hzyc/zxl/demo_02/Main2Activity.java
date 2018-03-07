package com.hzyc.zxl.demo_02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

   private Button print;
   private CheckBox lq,zq,yy,js;
   private String str="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        print = (Button) findViewById(R.id.print);
        lq = (CheckBox) findViewById(R.id.lq);
        zq = (CheckBox) findViewById(R.id.zq);
        yy = (CheckBox) findViewById(R.id.yy);
        js = (CheckBox) findViewById(R.id.js);
       /* print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/
    }
    public void check(View view){
        //Toast.makeText(Main2Activity.this, "点击了", Toast.LENGTH_SHORT).show();
        int id = view.getId();
        Log.i("标识",""+id);
        Log.i("标识",""+R.id.lq);
        switch (id){
            case R.id.lq:
                Toast.makeText(Main2Activity.this, "篮球", Toast.LENGTH_SHORT).show();
            break;
            case R.id.zq:
                Toast.makeText(Main2Activity.this, "足球", Toast.LENGTH_SHORT).show();
                break;
            case R.id.yy:
                Toast.makeText(Main2Activity.this, "游泳", Toast.LENGTH_SHORT).show();
                break;
            case R.id.js:
                Toast.makeText(Main2Activity.this, "健身", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
