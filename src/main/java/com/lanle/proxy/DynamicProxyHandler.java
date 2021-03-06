package com.lanle.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxyHandler implements InvocationHandler {

    private Object proxyed;

    public DynamicProxyHandler(Object proxyed) {
        this.proxyed = proxyed;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理类处理");
        return method.invoke(proxyed,args);
    }
}
