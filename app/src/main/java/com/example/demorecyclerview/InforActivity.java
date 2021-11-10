package com.example.demorecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class InforActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infor);

        int id = getIntent().getIntExtra("id",1);
        String title = getIntent().getStringExtra("title");
        String des = getIntent().getStringExtra("des");

        ((TextView)findViewById(R.id.tv_idshow)).setText(String.valueOf(id));
        ((ImageView)findViewById(R.id.imageView)).setBackgroundResource(id);
        ((TextView)findViewById(R.id.tv_titleshow)).setText(title);
        ((TextView)findViewById(R.id.tv_desshow)).setText(des);
    }
}