package com.hzyc.zxl.demo_010;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private Button alertDialog,alertDialogKz,dataPickerDialog,timePickerDialog,progressDialog;
    private String [] data = {"喜欢","不喜欢","一般般"};

    //公共的事件处理
    private DialogInterface.OnClickListener dc = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which) {
                case -2:
                    Toast.makeText(MainActivity.this, "喜欢" + which, Toast.LENGTH_SHORT).show();
                    break;
                case -1:
                    Toast.makeText(MainActivity.this, "不喜欢" + which, Toast.LENGTH_SHORT).show();
                    break;
                case -3:
                    Toast.makeText(MainActivity.this, "一般般" + which, Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alertDialog = (Button) findViewById(R.id.alertDialog);
        alertDialogKz = (Button) findViewById(R.id.alertDialogKz);

        dataPickerDialog = (Button) findViewById(R.id.dataPickerDialog);
        timePickerDialog = (Button) findViewById(R.id.timePickerDialog);
        progressDialog = (Button)findViewById(R.id.progressDialog);

        alertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

            builder.setIcon(R.drawable.image1)
                    .setTitle("问卷调查")
            .setMessage("你喜欢看好莱坞电影吗?")
            .setNegativeButton("喜欢", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, "喜欢"+which, Toast.LENGTH_SHORT).show();
                }
            })
                    .setPositiveButton("不喜欢", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, "不喜欢"+which, Toast.LENGTH_SHORT).show();

                }
            })
                    .setNeutralButton("一般", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, "一般般"+which, Toast.LENGTH_SHORT).show();

                }
            })
                    .show();*/

                //R.style.MyCommonDialog为修改样式的参数，带主题的
               /*  AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this,R.style.MyCommonDialog);

            builder.setIcon(R.drawable.image1)
                    .setTitle("问卷调查")
            .setMessage("你喜欢看好莱坞电影吗?")
            .setNegativeButton("喜欢",dc)
                    .setPositiveButton("不喜欢",dc)
                    .setNeutralButton("一般", dc)
                    .show();*/

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setIcon(R.drawable.image1)
                        .setTitle("问卷调查")
                        .setMessage("你喜欢看好莱坞电影吗?")
                        .setNegativeButton("喜欢", dc)
                        .setPositiveButton("不喜欢", dc)
                        .setNeutralButton("一般", dc);

                //得到当前的弹出窗口对象
                AlertDialog dialog = builder.create();
                dialog.show();//显示

                //写代码修改控件的主题
                //从窗口对象取出窗口，赋给dialogWindow对象
                Window dialogWindow = dialog.getWindow();
                //取出窗口管理者
                WindowManager m = dialogWindow.getWindowManager();
                //获取屏幕的宽和高
                Display d = m.getDefaultDisplay();
                //获取dialog属性
                WindowManager.LayoutParams layout = dialogWindow.getAttributes();

                //修改高度和宽度为原来的几倍
                layout.width = (int) (d.getWidth() * 0.6);
                layout.height = (int) (d.getHeight() * 0.4);
                layout.alpha = 0.5f;
                layout.gravity = Gravity.BOTTOM;
                dialogWindow.setAttributes(layout);


            }
        });
        alertDialogKz.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
               /* //单选
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setIcon(R.drawable.image1)
                        .setTitle("问卷调查")
                       .setSingleChoiceItems(data, 0, new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialog, int which) {
                               Toast.makeText(MainActivity.this, ""+which, Toast.LENGTH_SHORT).show();
                           }
                       }).show();*/

                //多选
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setIcon(R.drawable.image1)
                        .setTitle("问卷调查")
                        .setMultiChoiceItems(data, new boolean[]{true, false, true}, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                Toast.makeText(MainActivity.this, ""+which, Toast.LENGTH_SHORT).show();
                            }
                        }).show();

            }
        });
        //日期控件
        dataPickerDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();

                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dp = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        String sj = year+"-"+(monthOfYear+1)+"-"+dayOfMonth;
                        Toast.makeText(MainActivity.this, sj, Toast.LENGTH_SHORT).show();
                    }
                },year,month,day);
                dp.show();
            }
        });
        //时间控件
        timePickerDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();

                int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
                int minute = calendar.get(Calendar.MINUTE);
               // int day = calendar.get(Calendar.DAY_OF_MONTH);
                TimePickerDialog tp = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        String sj = hourOfDay+":"+minute;
                        Toast.makeText(MainActivity.this, ""+sj, Toast.LENGTH_SHORT).show();
                    }
                },hourOfDay,minute,true);
                tp.show();

            }
        });

        //进度条
        progressDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setIcon(R.drawable.image1);
                progressDialog.setTitle("请等待");
                progressDialog.setMessage("正在加载......");
                //设置进度条样式水平
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.show();
                //最大进度100,当前进度50
                progressDialog.setMax(100);
                //progressDialog.setProgress(50);

               /* int i = 1;
                while(i<=100){
                    progressDialog.setProgress(i);
                    i++;
                }*/

                class MyThread extends Thread{
                    @Override
                    public void run() {
                        int i = 0;
                        while(true){
                            try {
                                sleep(2000);
                                progressDialog.setProgress(i+=10);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            if(i==100){
                                break;
                            }
                        }
                    }
                }
                new MyThread().start();
            }
        });
    }
}
