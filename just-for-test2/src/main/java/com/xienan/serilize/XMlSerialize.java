package com.xienan.serilize;

import net.sf.json.JSONObject;
import net.sf.json.xml.XMLSerializer;

public class XMlSerialize {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Feed2talk feed2talk = new Feed2talk(23, "fasd");
		feed2talk.setAlbum(new Album("album"));
		
		XMLSerializer xmlSerializer = new XMLSerializer();
		JSONObject jsonBefore = JSONObject.fromObject(feed2talk);
		System.out.println("jsonbefore: " + jsonBefore);
		String s = xmlSerializer.write(jsonBefore);
		System.out.println(s);
		
		JSONObject json = (JSONObject) xmlSerializer.read(s);
		System.out.println(json);
		
		Feed2talk feed2talk2 = (Feed2talk) JSONObject.toBean(json, Feed2talk.class);
		System.out.println(feed2talk2.getAlbum().getTitle());	
		System.out.println(feed2talk2.map1);
			
		//System.out.println(feed2talk2.getAlbum().getPhotos().get(0).getImgUrl());
	}

}
