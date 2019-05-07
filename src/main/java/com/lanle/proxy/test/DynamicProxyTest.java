package com.lanle.proxy.test;

import com.lanle.proxy.DynamicProxyHandler;
import com.lanle.proxy.DynamicServiceImpl;
import com.lanle.proxy.service.DynamicService;

import java.lang.reflect.Proxy;

/**
 * 通过调用Proxy静态方法Proxy.newProxyInstance()可以创建动态代理，
 * 这个方法需要得到一个类加载器，一个你希望该代理实现的接口列表(不是类或抽象类)，以及InvocationHandler的一个实现类。
 * 动态代理可以将所有调用重定向到调用处理器，因此通常会调用处理器的构造器传递一个”实际”对象的引用，
 * 从而将调用处理器在执行中介任务时，将请求转发。
 */
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
