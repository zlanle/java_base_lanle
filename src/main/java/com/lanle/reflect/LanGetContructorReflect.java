package com.lanle.reflect;

import com.lanle.reflect.model.LanGetConstructor;

import java.lang.reflect.Constructor;

public class LanGetContructorReflect {

    public static void reflect(){
        LanGetConstructor lanGetConstructor = new LanGetConstructor("10","20","30");
        Class<? extends LanGetConstructor> clazz = lanGetConstructor.getClass();
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        for (int i = 0; i < constructors.length; i++) {
            Constructor<?> constructor = constructors[i];
            System.out.println("查看是否允许带有可变数量的参数："+constructor.isVarArgs());
            System.out.println("该构造方法的入口参数类型依次为：");
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            for (int j = 0; j < parameterTypes.length; j++) {
                print(parameterTypes,j);
            }
            System.out.println("构造方法可能抛出的异常类型为：");
            Class<?>[] exceptionTypes = constructor.getExceptionTypes();
            for (int j = 0; j < exceptionTypes.length; j++) {
                print(exceptionTypes,j);
            }
            LanGetConstructor lanGetConstructor1 = null;
            while (lanGetConstructor1 == null){
                try {
                    if (i == 2){
                        lanGetConstructor1 = (LanGetConstructor)constructor.newInstance();
                    } else if (i == 1){
                        lanGetConstructor1 = (LanGetConstructor)constructor.newInstance("33",2);
                    }else{
                        Object parameters = new Object[]{new String[] {"150","250","350"} };
                        lanGetConstructor1 = (LanGetConstructor)constructor.newInstance(parameters);
                    }
                } catch (Exception e) {
                    System.out.println("在创建对象时抛出异常，下面执行setAccessible()方法");
                    constructor.setAccessible(true);
                }
            }
            if (lanGetConstructor1 != null){
                lanGetConstructor1.print();
            }
        }
    }

    private static void print(Class<?>[] clazz,int j){
        if (j == clazz.length-1){
            System.out.println("\t" + clazz[j]);
        }else {
            System.out.print("\t" + clazz[j]);
        }
    }

    public static void main(String[] args) {
        LanGetContructorReflect.reflect();
    }
}
