package com.lanle.reflect.model;

public class Book {
    private static final String TAG = "BookTag";
    private String bookName;
    private String bookAuthor;

    public Book(){}
    public Book(String bookName,String bookAuthor){
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
    }
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                '}';
    }

    private String declaredMethod(int index){
        String result = "";
        switch (index){
            case 0:
                result = "我是第一个方法";
                break;
            case 1:
                result = "我是第二个方法";
                break;
                default:
                    result = "我是默认方法";

        }
        return result;
    }
}
