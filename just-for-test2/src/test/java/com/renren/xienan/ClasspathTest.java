package com.renren.xienan;

import org.junit.Test;

/**
 * Created by Administrator on 2016/1/9.
 */
public class ClasspathTest {

    @Test
    public void classpathProperty(){
        String classPathString =System.getProperty("java.class.path");
        String ss[] = classPathString.split(";");
        for (String s : ss){
            System.out.println(s);
        }
    }

    @Test
    public void appLoaderUrls(){
    }
}
