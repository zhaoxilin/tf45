package com.hzyc.zxl.demo_03;

import android.bluetooth.le.AdvertiseData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterViewAnimator;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {



    private GridView gridView;
    private int[] data = { R.drawable.img1, R.drawable.img1, R.drawable.img1, R.drawable.img1,
            R.drawable.img1, R.drawable.img1, R.drawable.img1, R.drawable.img1, R.drawable.img1,
            R.drawable.img1, R.drawable.img1, R.drawable.img1, R.drawable.img1, R.drawable.img1,
            R.drawable.img1, R.drawable.img1, R.drawable.img1, R.drawable.img1, R.drawable.img1,
            R.drawable.img1, R.drawable.img1, R.drawable.img1, R.drawable.img1, R.drawable.img1,
            R.drawable.img1, R.drawable.img1, R.drawable.img1, R.drawable.img1, R.drawable.img1
            , R.drawable.img1, R.drawable.img1, R.drawable.img1, R.drawable.img1, R.drawable.img1
            , R.drawable.img1, R.drawable.img1, R.drawable.img1, R.drawable.img1, R.drawable.img1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = (GridView) findViewById(R.id.gridView);

        //gridView.setOnItemClickListener(AdapterView<?>parent,View view,int position,long id);

        gridView.setAdapter(new MyAdapter());
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Main2Activity.this, "节点编号"+position, Toast.LENGTH_SHORT).show();
            }
        });
    }


    class  MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return data.length;
        }

        @Override
        public Object getItem(int position) {
            return data[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ImageView imageView;
            //若缓存为空，则表示是第一个进入适配器的ImageView
            if(convertView == null){

                imageView = new ImageView(Main2Activity.this);
                imageView.setPadding(8,8,8,8);
                //缓存不为空，则下面适配的ImageView从缓存中取到
            }else {

                imageView = (ImageView) convertView;
            }
            imageView.setImageResource(data[position]);
            return imageView;
        }
    }
}
