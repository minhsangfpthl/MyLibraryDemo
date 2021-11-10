package com.example.demorecyclerview.assets;

import com.example.demorecyclerview.Object.Book;
import com.example.demorecyclerview.R;

import java.util.ArrayList;

public class Utils {
    private static Utils instance;


    private static ArrayList<Book> allBooks;
    private static ArrayList<Book> alreadyReadBooks;
    private static ArrayList<Book> wantToReadBooks;
    private static ArrayList<Book> currentlyReadingBooks;
    private static ArrayList<Book> favoriteBooks;

    private Utils(){
        if (null == allBooks){
            allBooks = new ArrayList<>();
            initData();
        }
        if (alreadyReadBooks == null) {
            alreadyReadBooks = new ArrayList<>();
        }
        if (wantToReadBooks == null) {
            wantToReadBooks = new ArrayList<>();
        }
        if (currentlyReadingBooks == null) {
            currentlyReadingBooks = new ArrayList<>();
        }
        if (favoriteBooks == null) {
            favoriteBooks = new ArrayList<>();
        }
    }
    // set Data
    private void initData() {
        allBooks.add(new Book(1,"Đắc Nhân Tâm", "Nguyễn Văn Phước",1999, R.drawable.ic_launcher_background
                ,"Những ai có thể đặt mình vào vị trí người khác","Những ai có thể đặt mình vào vị trí người khác,những ai có thể hiểu những suy tư, cảm nhận của mọi người thì không bao giờ phải lo lắng cho tương lai."));
        allBooks.add(new Book(2,"Nhà giả kim", "Paulo Coelho",350,R.drawable.ic_launcher_background
                ,"Cuốn sách bán chạy nhất chỉ sau kinh thánh","Nhân vật chính trong truyện là Santiago. Cha mẹ Santiago mong muốn cậu trở thành linh mục để mang lại niềm tự hào cho gia đình, nhưng vì ước mơ từ nhỏ của chính mình là đi đây đi đó khắp thế giới, Santigo đã thuyết phục được cha cậu và trở thành một người chăn cừu."));
        allBooks.add(new Book(3,"Ở quán cà phê của tuổi trẻ lạc lối", "Partrick Modiano",289,R.drawable.ic_launcher_background
                ,"Liệu những con đường ta qua thời tuổi trẻ có thực sự là đường vòng?","Tuổi trẻ là một khối dồn nén. Nó có sức phá hoại đến nỗi, vào một thời điểm những tưởng đã quay lưng với cuộc đời, ta chợt nhìn lại và thấy vần vũ quanh mình những gương mặt, mối tình, những lần gặp gỡ, các cảm xúc chân thực và sống động như dao cứa"));
        allBooks.add(new Book(4,"Cha và Con", "Tony Parsons",311,R.drawable.ic_launcher_background
                ,"CÂU CHUYỆN XÚC ĐỘNG VỀ SỰ TRƯỞNG THÀNH CỦA MỘT NGƯỜI ĐÀN ÔNG","Cha và Con là cuốn sách viết về những khó khăn và diễn biến tâm lý của nhân vật nam chính sau khi vợ bỏ đi để lại anh một mình với cậu con trai nhỏ."));
        allBooks.add(new Book(5,"Tỷ Phú Bán Giày", "Tony Hsieh",469,R.drawable.ic_launcher_background
                ,"xếp thứ 5 trong những cuốn sách hay về Marketing và Bán hàng","Với “Tỷ Phú Bán Giày”, bạn sẽ nhận được cảm hứng, hết lòng và cả một chút điên rồ cho những ý tưởng buôn bán mà nghe qua tưởng như vô cùng liều mạng. "));
        allBooks.add(new Book(6,"Ông Già Và Biển Cả", "Hemingway",350,R.drawable.ic_launcher_background
                ," là truyện ngắn dạng viễn tưởng cuối cùng được viết bởi Hemingway. ","Đây là một tác phẩm lý tưởng, nó thật sự mang ý nghĩa rất lớn đặc biệt là đối với những ai đang muốn bỏ cuộc, đang muốn đầu hàng chính bản thân mình, bạn không thể biết được điều gì đang đợi bạn phía trước, hãy tin tưởng vào con đường bạn đã chọn, tin tưởng vào khả năng của chính mình."));

    }

    //call one by one
    public static synchronized Utils getInstance() {
        if (instance != null) {
            return instance;
        }else {
            instance = new Utils();
            return instance;
        }
    }

    public static ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    public static ArrayList<Book> getAlreadyReadBooks() {
        return alreadyReadBooks;
    }

    public static ArrayList<Book> getWantToReadBooks() {
        return wantToReadBooks;
    }

    public static ArrayList<Book> getCurrentlyReadingBooks() {
        return currentlyReadingBooks;
    }

    public static ArrayList<Book> getFavoriteBooks() {
        return favoriteBooks;
    }
    public Book getBookByID(int id){
        for (Book b: allBooks ) {
            if (b.getId() == id){
                return b;
            }
        }
        return null;
    }

    public boolean addToAlreadyBook(Book book){
        return  alreadyReadBooks.add(book);
    }
}
