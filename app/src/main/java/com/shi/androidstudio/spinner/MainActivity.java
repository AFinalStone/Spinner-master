package com.shi.androidstudio.spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Spinner简单使用
 * @author SHI
 * @time 2017/2/20 17:30
 */
public class MainActivity extends AppCompatActivity {

    private TextView textView;

    //Spinner控件
    private Spinner spinner;

    //数据源
    private List<String> dataList = new ArrayList<>();

    //spinner的数据适配器
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (Spinner) findViewById(R.id.spinner);
        textView = (TextView) findViewById(R.id.textView);

        //为dataList赋值，将下面这些数据添加到数据源中
        dataList.add("北京");
        dataList.add("上海");
        dataList.add("广州");
        dataList.add("深圳");
        dataList.add("杭州");

        //为spinner设置样式
//      adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,dataList);
        adapter = new ArrayAdapter<String>(this,R.layout.layout_spinner_select,dataList);

        //为适配器设置下拉列表的样式。
//      adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.layout_spinner_dropdown);

        //设置数据适配器
        spinner.setAdapter(adapter);

        //为spinner设置点击事件监听
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                textView.setText("当前选择的城市是："+adapter.getItem(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
