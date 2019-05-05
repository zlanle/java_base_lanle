package com.lanle.reflect;

import java.lang.reflect.Constructor;

/**
 * 通过反射，创建Class类对象的方法
 */
public class FirstReflect {

    public static void main(String[] args) {
        //第一种使用类的属性
        Class clazz = Demo.class;
        System.out.println("第一个反射对象的哈希码："+clazz.hashCode());
        //第二种使用Class类的forName()方法
        try {
            Class clazz1 = Class.forName("com.lanle.reflect.Demo");
            System.out.println("第二个反射对象的哈希码："+clazz1.hashCode());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //第三种使用Object对象的getClass()方法
        Demo demo = new Demo();
        Class clazz2 = demo.getClass();
        System.out.println("第三个反射对象的哈希码："+clazz2.hashCode());

        Package aPackage = clazz.getPackage();
        System.out.println("获得Demo类的存放路径："+aPackage.toString());
        String name = aPackage.getName();
        System.out.println("获得类名称："+ name);
        Class superclass = clazz.getSuperclass();
        System.out.println("获得该类的继承类："+ superclass);
        Class[] interfaces = clazz.getInterfaces();
        for (Class anInterface : interfaces) {
            System.out.println("获得该类实现的所有接口："+ anInterface.getName());
        }
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            boolean varArgs = constructor.isVarArgs();
            if(varArgs){
                System.out.println("获得所有权限为public的指定构造方法："+constructor.getName());
            }else{
                System.out.println("获得所有权限为public的构造方法："+constructor.getName());
            }
        }
        System.out.println("获得所有权限为public的构造方法个数："+constructors.length);
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        System.out.println("获得所有权限的构造方法个数："+declaredConstructors.length);
    }
    /**
     * 结果：
     * 第一个反射对象的哈希码685325104
     * 第二个反射对象的哈希码685325104
     * 第三个反射对象的哈希码685325104
     */
}
class Demo implements DemoService{
    public Demo(){};
    private Demo(String a){};
    public Demo(String a,Integer b){};
    @Override
    public void demoPrint() {
        System.out.println("测试打印类");
    }
}
