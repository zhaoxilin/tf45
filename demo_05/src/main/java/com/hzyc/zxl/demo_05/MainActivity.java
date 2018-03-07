package com.hzyc.zxl.demo_05;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //实例化控件
        gridView = (GridView) findViewById(R.id.gridView);
        //写适配器
        gridView.setAdapter(new MyAdapter());
    }
    //数据
    public List<Map<String,Object>> getList(){
        //虚拟数据
        List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
        for(int i = 1;i<=15;i++){
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("image",R.drawable.image1);
            map.put("name","应用"+i);

            list.add(map);
        }
        return list;
    }
    class MyAdapter extends BaseAdapter{

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
            view = LayoutInflater.from(MainActivity.this).inflate(R.layout.grid,null); //通过Activity类获取一个外部的布局文件
         }else{
             view = convertView;
         }
            //取出xml中的控件
            ImageView iamgeView =  (ImageView) view.findViewById(R.id.imageView);//在指定的View中找控件
            TextView textView = (TextView) view.findViewById(R.id.textView);

            iamgeView.setImageResource(Integer.parseInt(getList().get(position).get("image").toString()));
            textView.setText(getList().get(position).get("name").toString());

            return view;
        }
    }
}
