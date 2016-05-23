package com.test.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by Administrator on 2015/8/29.
 */
public class MethodInvokeInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("before method invoke");
        Object object = methodInvocation.proceed();
        System.out.println("after method invoke");
        return object;
    }
}
