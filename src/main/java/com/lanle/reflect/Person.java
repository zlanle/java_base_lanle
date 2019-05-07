package com.lanle.reflect;

import java.io.Serializable;

public class Person extends Base implements Serializable {

    public static void main(String[] args) {
        Base base = new Person();
        if (base instanceof Person){
            System.out.println("检查类型向下转型是否合法OK");
        }else{
            System.out.println("检查类型向下转型是否合法Not OK");
        }
    }
}
