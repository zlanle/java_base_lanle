package com.lanle.reflect;

import com.lanle.reflect.model.Book;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class BookReflect {

    private static final String TAG = "BookReflectTag";

    /**
     * 创建对象
     * @throws Exception
     */
    public static void reflectNewInstance(){
        try {
            Class<?> aClass = Class.forName("com.lanle.reflect.model.Book");
            Object newInstance = aClass.newInstance();
            Book book = (Book) newInstance;
            book.setBookName("Java高级进阶");
            book.setBookAuthor("蓝泐");
            System.out.println(TAG+" refectNewInstance book "+book.toString());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    // 反射私有的构造方法
    public static void reflectPrivateConstructor(){
        try {
            Class<?> aClass = Class.forName("com.lanle.reflect.model.Book");
            Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(String.class, String.class);
            declaredConstructor.setAccessible(true);
            Object instance = declaredConstructor.newInstance("Android高级进阶", "泐");
            Book book = (Book)instance;
            System.out.println(TAG+" reflectPrivateConstructor book "+book.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // 反射私有属性
    public static void reflectPrivateFiled(){
        try {
            Class<?> aClass = Class.forName("com.lanle.reflect.model.Book");
            Object instance = aClass.newInstance();
            Field fieldTag = aClass.getDeclaredField("TAG");
            fieldTag.setAccessible(true);
            String tagValue = (String) fieldTag.get(instance);
            System.out.println(TAG+" reflectPrivateFiled "+tagValue);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    // 反射私有方法
    public static void reflectPrivateMethod(){
        try {
            Class<?> aClass = Class.forName("com.lanle.reflect.model.Book");
            Method declaredMethod = aClass.getDeclaredMethod("declaredMethod",int.class);
            declaredMethod.setAccessible(true);
            Object instance = aClass.newInstance();
            String result = (String) declaredMethod.invoke(instance, 0);
            System.out.println(TAG+" reflectPrivateMethod "+result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
