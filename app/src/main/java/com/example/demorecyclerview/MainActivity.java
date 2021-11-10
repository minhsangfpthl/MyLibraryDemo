package com.example.demorecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rec_view);
        Chapter chap1= new Chapter(R.drawable.ic_launcher_background, "Chapter1", "Introduce Android 1");
        Chapter chap2= new Chapter(R.drawable.ic_launcher_background, "Chapter2", "Introduce Android 2");
        Chapter chap3= new Chapter(R.drawable.ic_launcher_background, "Chapter3", "Introduce Android 3");
        Chapter chap4= new Chapter(R.drawable.ic_launcher_background, "Chapter4", "Introduce Android 4");
        Chapter chap5= new Chapter(R.drawable.ic_launcher_background, "Chapter5", "Introduce Android 5");

        List<Chapter> list = new ArrayList<>();
        list.add(chap1);
        list.add(chap2);
        list.add(chap3);
        list.add(chap4);
        list.add(chap5);

        MyCustomAdapter adapter = new MyCustomAdapter(list);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(adapter);
    }
}