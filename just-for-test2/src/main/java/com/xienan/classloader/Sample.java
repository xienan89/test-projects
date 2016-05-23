package com.xienan.classloader;

/**
 * @author nan.xie
 * @date 2014-9-4 下午3:40:41
 */
public class Sample {
	 private Sample instance; 

	    public void setSample(Object instance) { 
	        this.instance = (Sample) instance; 
	        System.out.println("setSample success!");
	    } 
}
