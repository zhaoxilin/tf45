package com.hzyc.zxl.demo_09;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> arrayAdapter;
    //ActionMode是上下文菜单的升级模式
    private ActionMode actionMode;

    //注册ActionMode,需要实现内部类
    private ActionMode.Callback callback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.one,menu);

            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            int id = item.getItemId();
            switch (id){
                case R.id.save:
                    Toast.makeText(Main2Activity.this, "保存", Toast.LENGTH_SHORT).show();
                    //android关闭统一使用finish()
                    mode.finish();
                    return true;
                case R.id.update:
                    Toast.makeText(Main2Activity.this, "更新", Toast.LENGTH_SHORT).show();
                    mode.finish();
                    return true;
                case R.id.delete:
                    Toast.makeText(Main2Activity.this, "删除", Toast.LENGTH_SHORT).show();
                    mode.finish();
                    return true;
            }
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
          //释放
            actionMode = null;
        }
    };
    //实现创建菜单的方法
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listView = (ListView) findViewById(R.id.listView);
        arrayAdapter = new ArrayAdapter<String>(Main2Activity.this,R.layout.support_simple_spinner_dropdown_item,
                         new String[]{"数据1","数据2","数据3","数据4","数据5","数据6"});

        listView.setAdapter(arrayAdapter);
        //注册actionMode 手动注册到长点击事件上
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                //不等于空，证明正在打开 ,让它继续执行 即return true
                if(actionMode != null){
                    return false;
                }
                //如果菜单是开着的，这行代码不执行
               actionMode = Main2Activity.this.startActionMode(callback); //注册
                return true;
            }
        });




        //注册菜单
        //实现创建上下文菜单的方法
        //这种菜单通过控件触发
        //为了防止误操作,菜单默认注册到控件,长点击事件
      // registerForContextMenu(listView);(注册ContextMenu)

    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.one,menu);

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    //实现选择菜单的方法
   /* @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.save:
                Toast.makeText(Main2Activity.this, "保存", Toast.LENGTH_SHORT).show();
                break;
            case R.id.update:
                Toast.makeText(Main2Activity.this, "更新", Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete:
                Toast.makeText(Main2Activity.this, "删除", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }*/
}
