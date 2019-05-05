package com.lanle.reflect;

/**
 * 通过反射，创建Class类对象的方法
 */
public class FirstReflect {

    public static void main(String[] args) {
        //第一种使用类的属性
        Class clazz = Demo.class;
        System.out.println("第一个反射对象的哈希码"+clazz.hashCode());
        //第二种使用Class类的forName()方法
        try {
            Class clazz1 = Class.forName("com.lanle.reflect.Demo");
            System.out.println("第二个反射对象的哈希码"+clazz1.hashCode());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //第三种使用Object对象的getClass()方法
        Demo demo = new Demo();
        Class clazz2 = demo.getClass();
        System.out.println("第三个反射对象的哈希码"+clazz2.hashCode());
    }
    /**
     * 结果：
     * 第一个反射对象的哈希码685325104
     * 第二个反射对象的哈希码685325104
     * 第三个反射对象的哈希码685325104
     */
}
class Demo{
}
