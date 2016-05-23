package com.xienan.serilize;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nan.xie
 * @date 2014-8-26 上午11:57:19
 */
public class SubBean {
	String subbeanName;
	List<DivSubBean> list;
	public SubBean(){
		subbeanName = "subBean";
		list = new ArrayList<DivSubBean>();
		list.add(new DivSubBean());
		list.add(new DivSubBean());
	}
	public String getSubbeanName() {
		return subbeanName;
	}
	public void setSubbeanName(String subbeanName) {
		this.subbeanName = subbeanName;
	}
	public List<DivSubBean> getList() {
		return list;
	}
	public void setList(List<DivSubBean> list) {
		this.list = list;
	}	
}
