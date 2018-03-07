package com.hzyc.zxl.demo_06;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Switch aSwitch;
    //下拉框
    private Spinner spinner;
    //该适配器是arrayAdapter,为baseAdapter的子类
    private ArrayAdapter<String> aa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aSwitch = (Switch) findViewById(R.id.switch1);
        spinner = (Spinner) findViewById(R.id.spinner);
        aa = new ArrayAdapter<String>(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,new String[]{"长春市","吉林市","松原市"});

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            //选择了其中某一项
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               // Toast.makeText(MainActivity.this, ""+position, Toast.LENGTH_SHORT).show();
                Object object = spinner.getSelectedItem();
                Toast.makeText(MainActivity.this, ""+object.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            //什么都没有选
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner.setAdapter(aa);

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(MainActivity.this, ""+isChecked, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
