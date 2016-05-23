package com.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2015/10/31.
 */
public class Service2 {
    @Autowired
    Service1 service1;
}
