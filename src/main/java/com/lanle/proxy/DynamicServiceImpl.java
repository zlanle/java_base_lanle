package com.lanle.proxy;

import com.lanle.proxy.service.DynamicService;

public class DynamicServiceImpl implements DynamicService {
    @Override
    public void doSomething() {
        System.out.println("doSomething.......");
    }

    @Override
    public void somethindElse(String arg) {
        System.out.println("somethingElse......."+arg);
    }
}
