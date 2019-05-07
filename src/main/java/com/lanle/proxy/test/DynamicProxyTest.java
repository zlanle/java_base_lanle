package com.lanle.proxy.test;

import com.lanle.proxy.DynamicProxyHandler;
import com.lanle.proxy.DynamicServiceImpl;
import com.lanle.proxy.service.DynamicService;

import java.lang.reflect.Proxy;

public class DynamicProxyTest {
    public static void main(String[] args) {
        DynamicServiceImpl dynamicService = new DynamicServiceImpl();
        /**
         * 返回指定接口的代理类的实例，该接口将方法调用分派给指定的调用处理程序
         * 第一个参数指定接口的类加载器
         * 第二个参数指定接口类
         * 第三个参数处理类
         */
        DynamicService proxyInstance = (DynamicService) Proxy.newProxyInstance(
                DynamicService.class.getClassLoader(),
                new Class[]{DynamicService.class},
                new DynamicProxyHandler(dynamicService));
        proxyInstance.doSomething();
        proxyInstance.somethindElse("蓝泐");
    }
}
