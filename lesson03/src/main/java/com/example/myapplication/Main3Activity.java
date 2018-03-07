package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main3Activity extends AppCompatActivity {

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        listView = (ListView)findViewById(R.id.listView);

        listView.setAdapter(new MyAdapter());
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Main3Activity.this, ""+position, Toast.LENGTH_SHORT).show();
            }
        });
    }
    //数据
    public List<Map<String,Object>> getList(){
        //虚拟数据
        List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
        for(int i = 1;i<=15;i++){
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("photo",R.drawable.image1);
            map.put("name","商品"+i);
            map.put("price",12.5+i);
            map.put("bz","华为手机");
            map.put("rating",i%5);

            list.add(map);
        }
        return list;
    }

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return getList().size();
        }

        @Override
        //取索引码
        public Object getItem(int position) {
            return getList().get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view; //创建一份View,用来接受外部的xml文件
            //如果缓存是空，则表示第一次来
            if(convertView==null){
                view = LayoutInflater.from(Main3Activity.this).inflate(R.layout.image_text,null); //通过Activity类获取一个外部的布局文件
            }else{
                view = convertView;
            }
            //取出xml中的控件
            ImageView photo =  (ImageView) view.findViewById(R.id.photo);//在指定的View中找控件
            TextView name = (TextView) view.findViewById(R.id.name);
            TextView price = (TextView) view.findViewById(R.id.price);
            TextView bz = (TextView) view.findViewById(R.id.bz);
            RatingBar ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);


            photo.setImageResource(Integer.parseInt(getList().get(position).get("photo").toString()));
            name.setText(getList().get(position).get("name").toString());
            price.setText(getList().get(position).get("price").toString());
            bz.setText(getList().get(position).get("bz").toString());
            ratingBar.setRating(Float.parseFloat(getList().get(position).get("rating").toString()));


            return view;
        }
    }
}
