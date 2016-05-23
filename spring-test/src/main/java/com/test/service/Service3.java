package com.test.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * Created by Administrator on 2015/10/31.
 */
public class Service3 implements InitializingBean{
      Service4 service4;

    @Autowired
    Service5 service5;

    @Autowired
    public void autowired(){
        System.out.println("service3 autowired method");
    }

    public Service4 getService4() {
        return service4;
    }

    public void setService4(Service4 service4) {
        this.service4 = service4;
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("service3 postConstruct");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("service3 afterPropertiesSet");
    }

    public void initMethod(){
        System.out.println("service3 initMethod");
    }
}
