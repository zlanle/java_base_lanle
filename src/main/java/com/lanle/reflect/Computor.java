package com.lanle.reflect;

import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Computor  implements Serializable {

    private String brand;

    private String price;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public static void main(String[] args) throws Exception {
        Computor computor = new Computor();
        //获取computor的加载类
        Class<? extends Computor> aClass = computor.getClass();
        Field field = aClass.getDeclaredField("brand");
        System.out.println("获取指定字段："+field.getName()+"\t" + field.getType().getName());
        Field[] fields = aClass.getDeclaredFields();
        for (Field field1 : fields) {
            //获取字段名称
            String field1Name = field1.getName();
            //获取bean的某个属性的描述符
            PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field1Name, aClass);
            //从属性描述器中获取 set 方法
            Method writeMethod = propertyDescriptor.getWriteMethod();
            if ("brand".equals(field1Name)){
                writeMethod.invoke(computor,"Thinkpad");
            }else{
                writeMethod.invoke(computor,"6500￥");
            }
            //从属性描述器中获取 get 方法
            Method readMethod = propertyDescriptor.getReadMethod();
            Object invoke = readMethod.invoke(computor);
            System.out.println(field1Name + "：" + invoke);
        }
    }
}
