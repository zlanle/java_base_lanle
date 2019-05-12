package com.lanle.reflect.model;

public class LanGetConstructor {

    String s;
    int a,b,c;

    private LanGetConstructor(){}

    protected LanGetConstructor(String s,int a){
        this.s = s;
        this.a = a;
    }

    public LanGetConstructor(String... strings) throws NumberFormatException{
        if (strings.length > 0){
            a = Integer.valueOf(strings[0]);
        }
        if (strings.length > 1){
            b = Integer.valueOf(strings[1]);
        }
        if (strings.length > 2){
            b = Integer.valueOf(strings[2]);
        }
    }

    public void print(){
        System.out.println("s="+s);
        System.out.println("a="+a);
        System.out.println("b="+b);
        System.out.println("c="+c);

    }
}
