package com.test.controller;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2015/12/15.
 */
@Component
public class TestInitializeBean implements InitializingBean{
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("test init bean init!!!");
    }

    public void testindex(){
        System.out.println("test index .");
    }
}
