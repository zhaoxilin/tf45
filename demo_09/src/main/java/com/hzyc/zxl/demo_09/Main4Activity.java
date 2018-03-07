package com.hzyc.zxl.demo_09;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main4Activity extends AppCompatActivity {

    private Button alertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        alertDialog =(Button) findViewById(R.id.alertDialog);

        alertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Main4Activity.this);
                builder.setIcon(R.drawable.image1)
                        .setTitle("你喜欢看好莱坞电影吗?")
                        .setMessage("喜欢")
                        .show();
            }
        });
    }
}
