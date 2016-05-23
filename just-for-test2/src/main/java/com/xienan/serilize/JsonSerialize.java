package com.xienan.serilize;

import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author nan.xie
 * @date 2014-8-26 上午11:49:49
 */
public class JsonSerialize {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Feed2talk feed2talk = new Feed2talk(2, "feed");
		feed2talk.setAlbum(new Album("album"));
		
		JSONObject json = JSONObject.fromObject(feed2talk);
		System.out.println(json);
		
		Map<String, Class<?>> classMap = new HashMap<String, Class<?>>();
		//classMap.put("map1", HashMap.class);
		//classMap.put("list", ArrayList.class);
		Feed2talk newfeed = (Feed2talk) JSONObject.toBean(json, Feed2talk.class );
		System.out.println(newfeed.getList());
	
	}

}
