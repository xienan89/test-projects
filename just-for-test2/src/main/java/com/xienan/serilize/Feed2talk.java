package com.xienan.serilize;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Feed2talk {
	int id;
	String name;	
	Album album;
	Map<SubBean, DivSubBean> map1;
	List<SubBean> list;	
	
	public Album getAlbum() {
		return album;
	}
	public void setAlbum(Album album) {
		this.album = album;
	}
	
	public Feed2talk(){}
	public Feed2talk(int i, String string) {
		this.id = i;
		this.name = string;	
		map1 = new HashMap<SubBean, DivSubBean>();
		map1.put(new SubBean(), new DivSubBean());
		
		list = new ArrayList<SubBean>();
		list.add(new SubBean());
		list.add(new SubBean());
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Map<SubBean, DivSubBean> getMap1() {
		return map1;
	}
	public void setMap1(Map<SubBean, DivSubBean> map1) {
		this.map1 = map1;
	}
	public List<SubBean> getList() {
		return list;
	}
	public void setList(List<SubBean> list) {
		this.list = list;
	}		
}
