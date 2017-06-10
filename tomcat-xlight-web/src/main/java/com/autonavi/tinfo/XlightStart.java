package com.autonavi.tinfo;

import org.apache.log4j.xml.DOMConfigurator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by xienan.xn
 *
 * @date 2016/8/17 10:27
 */
public class XlightStart {

    public static void main(String[] args){
        DOMConfigurator.configure(XlightStart.class.getResource("/log4j.xml"));
        new ClassPathXmlApplicationContext("classpath:applicationContext*.xml");
    }
}
