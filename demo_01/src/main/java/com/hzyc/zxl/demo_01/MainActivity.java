package com.hzyc.zxl.demo_01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
   private Button button;
   private CheckBox lq;
    private CheckBox zq;
    private CheckBox yy;
    private CheckBox js;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one);
        button = (Button)findViewById(R.id.print);

       /* button.setOnClickListener(new View.OnClickListen);*/

    }
    public void check(View view){
        int id = view.getId();
        Log.i("标识",""+id);
        Log.i("标识",""+R.id.lq);
        switch (id){
            case R.id.lq:
                Toast.makeText(MainActivity.this, "篮球", Toast.LENGTH_SHORT).show();
                break;
            case R.id.zq:
                Toast.makeText(MainActivity.this, "足球", Toast.LENGTH_SHORT).show();
                break;
            case R.id.yy:
                Toast.makeText(MainActivity.this, "游泳", Toast.LENGTH_SHORT).show();
                break;
            case R.id.js:
                Toast.makeText(MainActivity.this, "健身", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}

