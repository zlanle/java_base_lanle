package com.lanle.reflect.test;

import com.lanle.reflect.BookReflect;

public class BookReflectTest {

    public static void main(String[] args) {
        BookReflect.reflectNewInstance();
        BookReflect.reflectPrivateConstructor();
        BookReflect.reflectPrivateFiled();
        BookReflect.reflectPrivateMethod();
    }
}
