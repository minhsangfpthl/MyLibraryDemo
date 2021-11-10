package com.example.demorecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class BookActivity extends AppCompatActivity {


    private TextView txtBookName , txtAuthor , txtPage , txtDes;
    private Button btnAddCurrently, btnAddWantTo, btnAddAlready, btnAddFavorite;
    private ImageView bookImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        initView();

        // getdata from recview in here
        Book book = new Book(1,"Book1", "BMS", 1250,R.drawable.ic_launcher_background, "abc", "abcd");
        setData(book);
    }
        private void setData(Book book){
            txtBookName.setText(book.getName());
            txtAuthor.setText(book.getAuthor());
            txtPage.setText(String.valueOf(book.getPages()));
            txtDes.setText(book.getLongDesc());
            bookImage.setBackgroundResource(book.getImageUrl());
        }

    private void initView(){
        txtAuthor = findViewById(R.id.tv_authorName);
        txtBookName = findViewById(R.id.tv_bookName);
        txtPage = findViewById(R.id.tv_page);
        txtDes = findViewById(R.id.tv_longDes);

        btnAddCurrently = findViewById(R.id.btn_addToCurrentlyRead);
        btnAddAlready = findViewById(R.id.btnAlreadyReadBook);
        btnAddWantTo = findViewById(R.id.btn_addToWantToRead);
        btnAddFavorite = findViewById(R.id.btn_addFavorite);

        bookImage = findViewById(R.id.img_book);
    }
}