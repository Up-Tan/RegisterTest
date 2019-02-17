package com.example.administrator.registertest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){
        setContentView(R.layout.activity_result);

        TextView resultName=(TextView)findViewById(R.id.resultName);
        TextView resultPsd=(TextView)findViewById(R.id.resultPsd);
        TextView resultGender=(TextView)findViewById(R.id.resultGender);
        TextView resultCity=(TextView)findViewById(R.id.resultCity);

        Intent intent=getIntent();
        resultName.setText(intent.getStringExtra("name"));
        resultPsd.setText(intent.getStringExtra("psd"));
        resultGender.setText(intent.getStringExtra("gender"));
        resultPsd.setText(intent.getStringExtra("city"));

    }
}
