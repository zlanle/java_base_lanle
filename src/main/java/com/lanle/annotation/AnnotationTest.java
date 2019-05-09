package com.lanle.annotation;

import java.lang.reflect.Field;

public class AnnotationTest {

    public static void main(String[] args) {
        Book book = new Book();
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
}
