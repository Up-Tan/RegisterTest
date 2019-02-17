package com.example.administrator.registertest;

import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListAdapter;

public class ChooseCityActivity extends ExpandableListActivity {
    private String[] provinces = new String[]{"江西", "江苏", "浙江"};
    private String[][] cities = new String[][]{
            { "南昌", "九江", "赣州", "吉安" },
            { "南京", "苏州", "无锡", "扬州" },
            { "杭州", "温州" , "台州" , "金华" }
    };


}
