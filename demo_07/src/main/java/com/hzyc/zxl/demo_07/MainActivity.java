package com.hzyc.zxl.demo_07;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button toTwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i("生命周期","onCreate()");
        setContentView(R.layout.activity_main);

        toTwo= (Button) findViewById(R.id.toTwo);

        toTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);

                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("生命周期","onStart()");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("生命周期","onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("生命周期","onPause()");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("生命周期","onStop()");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("生命周期","onDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("生命周期","onRestart()");

    }
}
