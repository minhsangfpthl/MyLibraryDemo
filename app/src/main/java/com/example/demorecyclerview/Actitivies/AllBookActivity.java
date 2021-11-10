package com.example.demorecyclerview.Actitivies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.demorecyclerview.Object.Book;
import com.example.demorecyclerview.Adapters.MyCustomAdapter;
import com.example.demorecyclerview.R;
import com.example.demorecyclerview.assets.Utils;

import java.util.ArrayList;
import java.util.List;

public class AllBookActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    AllBookActivity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rec_view);
        MyCustomAdapter adapter = new MyCustomAdapter(Utils.getInstance().getAllBooks());

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(adapter);

    }
    public void onAttach(AllBookActivity activity){
        this.activity = activity;
    }
}