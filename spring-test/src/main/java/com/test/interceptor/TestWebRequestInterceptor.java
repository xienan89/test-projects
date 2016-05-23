package com.test.interceptor;

import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

/**
 * Created by Administrator on 2015/8/29.
 */
public class TestWebRequestInterceptor implements WebRequestInterceptor {
    @Override
    public void preHandle(WebRequest request) throws Exception {
        System.out.println("TestWebRequestInterceptor preHandle");
    }

    @Override
    public void postHandle(WebRequest request, ModelMap model) throws Exception {
        System.out.println("TestWebRequestInterceptor postHandle");
    }

    @Override
    public void afterCompletion(WebRequest request, Exception ex) throws Exception {
        System.out.println("TestWebRequestInterceptor afterCompletion");
    }
}
