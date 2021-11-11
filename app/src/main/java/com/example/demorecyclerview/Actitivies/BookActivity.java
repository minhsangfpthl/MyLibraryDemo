package com.example.demorecyclerview.Actitivies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
                Book incomingBook = Utils.getInstance().getBookByID(bookId);
                if ( null != incomingBook) {
                    setData(incomingBook);

                    handleAlreadyRead(incomingBook);
                    handleWantToReadBook(incomingBook);
                    handleCurrentlyBook(incomingBook);
                    handleFavoriteBook(incomingBook);
                }
            }
        }

    }

    private void handleCurrentlyBook(Book incomingBook) {
        ArrayList<Book> currentlyReadBooks = Utils.getInstance().getCurrentlyReadingBooks();
        boolean existInCurrentlyReadBooks =false;
        for (Book b: currentlyReadBooks) {
            if(b.getId() == incomingBook.getId()){
                existInCurrentlyReadBooks =true;

            }
        }
        if (existInCurrentlyReadBooks){
            btnAddCurrently.setEnabled(false);
        }else {
            btnAddCurrently.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Utils.getInstance().addToCurrentlyBook(incomingBook)){
                        Toast.makeText(BookActivity.this,"Book Added",Toast.LENGTH_SHORT).show();

                        // navigate the user
                        Intent intent = new Intent(BookActivity.this, CurrentlyReadBookActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(BookActivity.this,"Wrong, Try Again",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handleFavoriteBook(Book incomingBook) {

        ArrayList<Book> favoriteReadBooks = Utils.getInstance().getWantToReadBooks();
        boolean existInFavoriteReadBooks =false;
        for (Book b: favoriteReadBooks) {
            if(b.getId() == incomingBook.getId()){
                existInFavoriteReadBooks =true;

            }
        }
        if (existInFavoriteReadBooks){
            btnAddFavorite.setEnabled(false);
        }else {
            btnAddFavorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Utils.getInstance().addToFavoriteBook(incomingBook)){
                        Toast.makeText(BookActivity.this,"Book Added",Toast.LENGTH_SHORT).show();

                        // navigate the user
                        Intent intent = new Intent(BookActivity.this, FavoriteBookActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(BookActivity.this,"Wrong, Try Again",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handleWantToReadBook(final Book incomingBook) {
        ArrayList<Book> wantToReadBooks = Utils.getInstance().getWantToReadBooks();
        boolean existInWantToReadBooks =false;
        for (Book b: wantToReadBooks) {
            if(b.getId() == incomingBook.getId()){
                existInWantToReadBooks =true;

            }
        }
        if (existInWantToReadBooks){
            btnAddWantTo.setEnabled(false);
        }else {
            btnAddWantTo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Utils.getInstance().addToWantToReadBook(incomingBook)){
                        Toast.makeText(BookActivity.this,"Book Added",Toast.LENGTH_SHORT).show();

                        // navigate the user
                        Intent intent = new Intent(BookActivity.this, WantToReadActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(BookActivity.this,"Wrong, Try Again",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    // enable and disable button
    // add the book to already book list
    private void handleAlreadyRead(Book book) {
        ArrayList<Book> alreadyReadBooks = Utils.getInstance().getAlreadyReadBooks();
        boolean existInAlreadyReadBooks =false;
        for (Book b: alreadyReadBooks) {
            if(b.getId() == book.getId()){
                existInAlreadyReadBooks =true;
            }
        }
            if (existInAlreadyReadBooks){
                btnAddAlready.setEnabled(false);
            }else {
                btnAddAlready.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(Utils.getInstance().addToAlreadyBook(book)){
                            Toast.makeText(BookActivity.this,"Book Added",Toast.LENGTH_SHORT).show();

                            // navigate the user
                            Intent intent = new Intent(BookActivity.this, AlreadyReadBookActivity.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(BookActivity.this,"Wrong, Try Again",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
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
        btnAddAlready = findViewById(R.id.btn_addToAlreadyRead);
        btnAddWantTo = findViewById(R.id.btn_addToWantToRead);
        btnAddFavorite = findViewById(R.id.btn_addFavorite);

        bookImage = findViewById(R.id.img_book);
    }
}