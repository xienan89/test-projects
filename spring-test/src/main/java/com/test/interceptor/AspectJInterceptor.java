package com.test.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2015/8/29.
 */
@Component
 public class AspectJInterceptor {
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("AspectJInterceptor around before");
        Object object = proceedingJoinPoint.proceed();
        System.out.println("AspectJInterceptor around after");
        return object;
    }
}
