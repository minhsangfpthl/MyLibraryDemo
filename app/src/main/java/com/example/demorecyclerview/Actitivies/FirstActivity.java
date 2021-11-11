package com.example.demorecyclerview.Actitivies;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.demorecyclerview.R;
import com.example.demorecyclerview.assets.Utils;

public class FirstActivity extends AppCompatActivity {
    Button btn_first, btnAlreadyReadBook, btnWantToReadBook, btnFavoriteBook, btnCurrentlyBook, btnBuy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        btnAlreadyReadBook = findViewById(R.id.btnAlreadyReadBook);
        btnWantToReadBook = findViewById(R.id.btnWantToRead);
        btnFavoriteBook = findViewById(R.id.btnFavoriteBook);
        btnCurrentlyBook = findViewById(R.id.btnCurrentlyReading);
        btnBuy = findViewById(R.id.btnBuy);



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

        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(FirstActivity.this);
                builder.setTitle(getString(R.string.app_name));
                builder.setMessage("Do You Want To Visit Website To Buy Book Online?");
                builder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                builder.setPositiveButton("Visit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // show the website
                        Intent intent = new Intent(FirstActivity.this, WebsiteActivity.class);
                        startActivity(intent);
                    }
                });
                builder.create().show();
            }
        });
        Utils.getInstance();
    }
}