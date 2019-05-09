package com.lanle.annotation;

public class AnnotationTest {

    public static void main(String[] args) {
        //BookFactory.getFields();
        Book book = BookFactory.addBook();
        System.out.println(book.toString());
    }
}
