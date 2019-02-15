package com.example.administrator.registertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    private Button cityBtn, registerBtn;
    private EditText name,psd,psd2,city;
    private RadioButton male;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityBtn=(Button)findViewById(R.id.cityBtn);
        registerBtn=(Button)findViewById(R.id.registerBtn);
        name=(EditText)findViewById(R.id.name);
        psd=(EditText)findViewById(R.id.psd);
        city=(EditText)findViewById(R.id.city);
        male=(RadioButton)findViewById(R.id.male);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
