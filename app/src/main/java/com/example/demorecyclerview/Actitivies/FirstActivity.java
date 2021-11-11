package com.example.demorecyclerview.Actitivies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.demorecyclerview.R;
import com.example.demorecyclerview.assets.Utils;

public class FirstActivity extends AppCompatActivity {
    Button btn_first, btnAlreadyReadBook, btnWantToReadBook, btnFavoriteBook, btnCurrentlyBook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        btnAlreadyReadBook = findViewById(R.id.btnAlreadyReadBook);
        btnWantToReadBook = findViewById(R.id.btnWantToRead);
        btnFavoriteBook = findViewById(R.id.btnFavoriteBook);
        btnCurrentlyBook = findViewById(R.id.btnCurrentlyReading);



        // hien ra giao dien first
        btn_first = findViewById(R.id.btnAllBooks);
        // bam vao all book thi chuyen sang activity all book and list ra book
        btn_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this, AllBookActivity.class);
                startActivity(intent);
            }
        });
        btnAlreadyReadBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, AlreadyReadBookActivity.class);
                startActivity(intent);
            }
        });

        btnWantToReadBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, WantToReadActivity.class);
                startActivity(intent);
            }
        });

        btnFavoriteBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, FavoriteBookActivity.class);
                startActivity(intent);
            }
        });

        btnCurrentlyBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, CurrentlyReadBookActivity.class);
                startActivity(intent);
            }
        });
        Utils.getInstance();
    }
}