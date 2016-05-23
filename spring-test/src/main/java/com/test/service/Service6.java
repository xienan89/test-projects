package com.test.service;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by xienan on 2015/11/4.
 */
public class Service6 {
    static {
        System.out.println("service6 cinit");
    }
    @Autowired
    private Service5 service5;

    public Service5 getService5() {
        return service5;
    }

    public void setService5(Service5 service5) {
        this.service5 = service5;
    }
}
