package com.test.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectFactory;

/**
 * Created by Administrator on 2015/10/31.
 */
public class Service4 {
    Service3 service3;
    Service6 service6;

    public Service6 getService6() {
        return service6;
    }

    public void setService6(Service6 service6) {
        this.service6 = service6;
    }

    public Service3 getService3() {
        return service3;
    }

    public void setService3(Service3 service3) {
        this.service3 = service3;
    }
}
