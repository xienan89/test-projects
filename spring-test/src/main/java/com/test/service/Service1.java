package com.test.service;

import com.test.controller.IndexController;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/10/25.
 */
public class Service1 implements InitializingBean{
    Service2 service2;

    @Resource(type = Service5.class)
    Service5 service5;

    List<Integer> list1 = new ArrayList<Integer>(4);

    @PostConstruct
    public void postConstruct(){
        System.out.println("service1 postConstruct");
    }

    @PostConstruct
    public void postConstruct1(){
        System.out.println("service1 postConstruct1");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("service1 afterPropertiesSet");
    }

    public void initMethod(){
        System.out.println("service1 initMethod");
    }
}
