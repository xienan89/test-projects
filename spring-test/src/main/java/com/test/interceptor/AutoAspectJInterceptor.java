package com.test.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2015/8/29.
 */
@Component
@Aspect
public class AutoAspectJInterceptor {
//    @Before("execution (* com.test.controller..*.*(..))")
//    public void before(){
//        System.out.println("AutoAspectJInterceptor before");
//    }
//
//    @After("execution (* com.test.controller..*.*(..))")
//    public void after() {
//        System.out.println("AutoAspectJInterceptor after");
//    }

    @Around("execution (* com.test.controller..*.*(..))")
    public Object around(ProceedingJoinPoint point) throws Throwable{
        System.out.println("AutoAspectJInterceptor begin around");
        Object object = point.proceed();
        System.out.println("AutoAspectJInterceptor end around");
        return object;
    }

    @AfterThrowing(pointcut = "execution (* com.test.controller..*.*(..))",throwing = "ex")
    public void afterThrowing(Exception ex){
        System.out.println("AutoAspectJInterceptor afterThrowing");
        System.out.println(ex);
    }
}
