package com.test.mains;

import com.xienan.classloader.ResourceLoad;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * Created by Administrator on 2016/1/6.
 */
public class ClasspathResourceTest {

    public static void main(String[] args) throws IOException {
        ResourceLoad.main(null);

        System.out.println("=========");
        ClassLoader classLoader = ClasspathResourceTest.class.getClassLoader();
        Enumeration<URL> urls = ClasspathResourceTest.class.getClassLoader().getResources("resource.txt");

        while (urls.hasMoreElements()) {
            URL url = urls.nextElement();
            System.out.println(url);
        }

        System.out.println("print get source=============");
        System.out.println(classLoader.getResource("resource.txt"));

        System.out.println("print class path");
        String classPathString =System.getProperty("java.class.path");
        String ss[] = classPathString.split(";");
        for (String s : ss){
            System.out.println(s);
        }
    }
}
