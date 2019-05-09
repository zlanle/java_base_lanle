package com.lanle.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BookFactory {

    public static void getFields(){
        Class<?> aClass = Book.class;
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            String fieldName = field.getName();
            Class<?> fieldType = field.getType();
            System.out.println("字段名称："+fieldName+"\t字段类型："+fieldType.getName());
            if (field.isAnnotationPresent(LanAnnotation.class)){
                LanAnnotation lanAnnotation = field.getAnnotation(LanAnnotation.class);
                String remark = lanAnnotation.remark();
                boolean show = lanAnnotation.show();
                System.out.println("标记："+remark+"\t字段是否显示："+show);
            }
        }
    }

    public static Book addBook(){
        Book book = new Book();
        Class<?> aClass = Book.class;
        Method[] methods = aClass.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(LanAnnotation.class)){
                LanAnnotation methodAnnotation = method.getAnnotation(LanAnnotation.class);
                try {
                    method.invoke(book,methodAnnotation.remark());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return book;
    }
}
