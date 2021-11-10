package com.example.demorecyclerview.Actitivies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.demorecyclerview.Object.Book;
import com.example.demorecyclerview.R;
import com.example.demorecyclerview.assets.Utils;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {
    public static final String BOOK_ID_KEY = "bookId";

    private TextView txtBookName , txtAuthor , txtPage , txtDes;
    private Button btnAddCurrently, btnAddWantTo, btnAddAlready, btnAddFavorite;
    private ImageView bookImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        initView();

        // getdata from recview in here
        Intent intent = getIntent();
        if (intent != null) {
            int bookId = intent.getIntExtra(BOOK_ID_KEY,-1);
            if (bookId != -1){
                Book imcomingBook = Utils.getInstance().getBookByID(bookId);
                if (imcomingBook != null) {
                    setData(imcomingBook);

                    handleAlreadyRead(imcomingBook);
                }
            }
        }

    }

    private void handleAlreadyRead(Book imcomingBook) {
        ArrayList<Book> alreadyReadBooks = Utils.getInstance().getAlreadyReadBooks();
        boolean existInAlreadyReadBooks =false;
        for (Book b: alreadyReadBooks) {
            if(b.getId() == imcomingBook.getId()){
                existInAlreadyReadBooks =true;
            }
            if (existInAlreadyReadBooks){
                btnAddAlready.setEnabled(false);
            }else {
                btnAddAlready.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
            }
        }
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