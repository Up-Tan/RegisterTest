package com.example.administrator.registertest;

import android.app.ExpandableListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ChooseCityActivity extends ExpandableListActivity {
    private String[] provinces = new String[]{"江西", "江苏", "浙江"};
    private String[][] cities = new String[][]{
            { "南昌", "九江", "赣州", "吉安" },
            { "南京", "苏州", "无锡", "扬州" },
            { "杭州", "温州" , "台州" , "金华" }
    };
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        ExpandableListAdapter adapter = new BaseExpandableListAdapter() {
            //获取该扩展列表的组数，即省份数
            @Override
            public int getGroupCount() {
                return provinces.length;
            }

            //获取指定组的列表项数，即各省份的城市数
            @Override
            public int getChildrenCount(int groupPosition) {
                return cities[groupPosition].length;
            }

            private TextView getTextView(){
                AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,64);
                TextView textView = new TextView(ChooseCityActivity.this);
                textView.setLayoutParams(lp);
                textView.setGravity(Gravity.CENTER_VERTICAL|Gravity.LEFT);
                textView.setTextSize(20);
                return textView;
            }

            //获取指定组位置处的组数据
            @Override
            public Object getGroup(int groupPosition) {
                return provinces[groupPosition];
            }
            //获得指定组位置的指定子类表项数据
            @Override
            public Object getChild(int groupPosition, int childPosition) {
                return cities[groupPosition][childPosition];
            }

            @Override
            public long getChildId(int groupPosition, int childPosition) {
                return childPosition;
            }

            //获取组的ID号，即省份的ID号
            @Override
            public long getGroupId(int groupPosition) {
                return groupPosition;
            }



            @Override
            public boolean hasStableIds() {
                return true;
            }

            //该方法决定每个组选项的外观
            @Override
            public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
                LinearLayout ll = new LinearLayout(ChooseCityActivity.this);
                ll.setOrientation(LinearLayout.VERTICAL);
                ImageView logo = new ImageView(ChooseCityActivity.this);
                ll.addView(logo);
                TextView textView = getTextView();
                textView.setText(getGroup(groupPosition).toString());
                ll.addView(textView);
                return ll;
            }
            //该方法决定每个子选项的外观
            @Override
            public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
                TextView textView = getTextView();
                textView.setText(getChild(groupPosition, childPosition).toString());
                return textView;
            }

            @Override
            public boolean isChildSelectable(int groupPosition, int childPosition) {
                return true;
            }
        };

        //设置该窗口显示列表
        setListAdapter(adapter);
        getExpandableListView().setOnChildClickListener(
                new ExpandableListView.OnChildClickListener() {
                    @Override
                    public boolean onChildClick(ExpandableListView parent, View source, int groupPosition, int childPosition, long id) {
                        //获取启动该Activity之前对应的Intent
                        Intent intent = getIntent();
                        Bundle data = new Bundle();
                        data.putString("city",cities[groupPosition][childPosition]);
                        intent.putExtras(data);
                        //设置该SelectActivity的结果码，并设置结束之后退回的Activity
                        ChooseCityActivity.this.setResult(0,intent);
                        //结束SelectCityActivity.
                        ChooseCityActivity.this.finish();
                        return false;
                    }
                }
        );
    }

}
