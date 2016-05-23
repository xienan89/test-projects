package com.xienan.javaserilize;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


/**
 * @author nan.xie
 * @date 2014-6-24 下午6:11:24
 */
public class Noserizable implements Serializable{

	private static final long serialVersionUID = -769594772692111506L;
	public String name = "inner noserizable class";
	public Map<Integer, String> map;
	
	Noserizable(){
		map = new HashMap<Integer, String>();
		map.put(123, "abd");
	}
}
