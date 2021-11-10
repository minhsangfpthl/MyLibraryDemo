package com.example.demorecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class AllBookActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rec_view);
/*
        Book book1 = new Book(1,"Book1", "BMS", 1250,R.drawable.ic_launcher_background, "abc", "abcd");
        Book book2 = new Book(2,"Book2", "BMS", 1250,R.drawable.ic_launcher_background, "abc", "abcd");
        Book book3 = new Book(3,"Book3", "BMS", 1250,R.drawable.ic_launcher_background, "abc", "abcd");
        Book book4 = new Book(4,"Book4", "BMS", 1250,R.drawable.ic_launcher_background, "abc", "abcd");
        List<Book> list = new ArrayList<>();
        list.add(book1);
        list.add(book2);
        list.add(book3);
        list.add(book4);*/
        List<Book> books = new ArrayList<>();
        books.add(new Book(1,"Đắc Nhân Tâm", "Nguyễn Văn Phước",1999,R.drawable.ic_launcher_background
                ,"Những ai có thể đặt mình vào vị trí người khác","Những ai có thể đặt mình vào vị trí người khác,những ai có thể hiểu những suy tư, cảm nhận của mọi người thì không bao giờ phải lo lắng cho tương lai."));
        books.add(new Book(2,"Nhà giả kim", "Paulo Coelho",350,R.drawable.ic_launcher_background
                ,"Cuốn sách bán chạy nhất chỉ sau kinh thánh","Nhân vật chính trong truyện là Santiago. Cha mẹ Santiago mong muốn cậu trở thành linh mục để mang lại niềm tự hào cho gia đình, nhưng vì ước mơ từ nhỏ của chính mình là đi đây đi đó khắp thế giới, Santigo đã thuyết phục được cha cậu và trở thành một người chăn cừu."));
        books.add(new Book(3,"Ở quán cà phê của tuổi trẻ lạc lối", "Partrick Modiano",289,R.drawable.ic_launcher_background
                ,"Liệu những con đường ta qua thời tuổi trẻ có thực sự là đường vòng?","Tuổi trẻ là một khối dồn nén. Nó có sức phá hoại đến nỗi, vào một thời điểm những tưởng đã quay lưng với cuộc đời, ta chợt nhìn lại và thấy vần vũ quanh mình những gương mặt, mối tình, những lần gặp gỡ, các cảm xúc chân thực và sống động như dao cứa"));
        books.add(new Book(4,"Cha và Con", "Tony Parsons",311,R.drawable.ic_launcher_background
                ,"CÂU CHUYỆN XÚC ĐỘNG VỀ SỰ TRƯỞNG THÀNH CỦA MỘT NGƯỜI ĐÀN ÔNG","Cha và Con là cuốn sách viết về những khó khăn và diễn biến tâm lý của nhân vật nam chính sau khi vợ bỏ đi để lại anh một mình với cậu con trai nhỏ."));
        books.add(new Book(5,"Tỷ Phú Bán Giày", "Tony Hsieh",469,R.drawable.ic_launcher_background
                ,"xếp thứ 5 trong những cuốn sách hay về Marketing và Bán hàng","Với “Tỷ Phú Bán Giày”, bạn sẽ nhận được cảm hứng, hết lòng và cả một chút điên rồ cho những ý tưởng buôn bán mà nghe qua tưởng như vô cùng liều mạng. "));
        books.add(new Book(6,"Ông Già Và Biển Cả", "Hemingway",350,R.drawable.ic_launcher_background
                ," là truyện ngắn dạng viễn tưởng cuối cùng được viết bởi Hemingway. ","Đây là một tác phẩm lý tưởng, nó thật sự mang ý nghĩa rất lớn đặc biệt là đối với những ai đang muốn bỏ cuộc, đang muốn đầu hàng chính bản thân mình, bạn không thể biết được điều gì đang đợi bạn phía trước, hãy tin tưởng vào con đường bạn đã chọn, tin tưởng vào khả năng của chính mình."));

        MyCustomAdapter adapter = new MyCustomAdapter(books);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(adapter);
    }
}