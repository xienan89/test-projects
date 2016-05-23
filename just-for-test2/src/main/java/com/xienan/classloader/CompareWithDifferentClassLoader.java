package com.xienan.classloader;

import java.lang.reflect.Method;

/**
 * @author nan.xie
 * @date 2014-8-25 下午5:48:01
 */
public class CompareWithDifferentClassLoader {

	public static void main(String[] args){
		  String classDataRootPath = "D:\\ideaProducts\\test-projects\\just-for-test2\\target\\classes";
		    FileSystemClassLoader fscl1 = new FileSystemClassLoader(classDataRootPath); 
		    FileSystemClassLoader fscl2 = new FileSystemClassLoader(classDataRootPath); 
		    String className = "com.xienan.classloader.Sample";
		    
		    Sample sample = new Sample();
		    System.out.println(sample.getClass().getClassLoader());
		    try { 
		        Class<?> class1 = fscl1.loadClass(className); 
		        Object obj1 = class1.newInstance(); 
		        System.out.println(obj1 + "," + obj1.getClass().getClassLoader());
		        
		        Class<?> class2 = fscl2.loadClass(className); 
		        Object obj2 = class2.newInstance();
		        System.out.println(obj2 + "," + obj2.getClass().getClassLoader());
		        
		        System.out.println("fsdfasdfasdf==================");
		        System.out.println("==" + class1.getClassLoader().equals(class2.getClassLoader()));
		        Method setSampleMethod = class1.getMethod("setSample", java.lang.Object.class); 
		        setSampleMethod.invoke(obj1, obj2); 
		        
		    } catch (Exception e) { 
		        e.printStackTrace(); 
		    } 
		    
		    System.exit(0);
	}
}
