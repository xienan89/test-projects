package com.xienan.classloader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * Created by Administrator on 2016/1/3.
 */
public class ResourceLoad {

    public static void main(String[] a) throws IOException {
        Class clazz = ResourceLoad.class;
        ClassLoader classLoader = ResourceLoad.class.getClassLoader();

/*        System.out.println(clazz.getResource(""));
        System.out.println(clazz.getResource("/"));

        System.out.println(classLoader.getResource(""));
        System.out.println(classLoader.getResource("/"));*/

        System.out.println("get resource in jar " + classLoader.getResource("resource.txt"));
        Enumeration<URL> urls = classLoader.getResources("resource.txt");

        while (urls.hasMoreElements()) {
            URL url = urls.nextElement();
            System.out.println(url);
        }
    }
}
