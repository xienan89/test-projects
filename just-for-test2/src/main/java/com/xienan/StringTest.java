package com.xienan;

import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;

import java.io.UnsupportedEncodingException;

public class StringTest {

	public static void StringSplit(){
		String[] strings = {"s1" , "s2", "s3"};
		String string = "ab|c";
		strings = string.split("\\|");
		//strings = new String[0];
		System.out.println(strings.length);
		for (int i = 0; i < strings.length; i++) {
			System.out.println(strings[i]);
		}
	}
	
	public static void StringSplit2(){
		String s = "1021474352,498351200,2014-06-07 00:01:50.0,2014-06-07 00:01:50.0,手机相册,,0";
		String[] ss = s.split(",");
		System.out.println(ss.length);
		for (String string : ss) {
			System.out.println(string);
		}
		if (ss[5] != null) {
			System.out.println(ss[5] + "im not null");
		}		
		
		String[] ss1 = StringUtils.split(s, ",");
		System.out.println(ss1.length);
		for (String string : ss1) {
			System.out.println(string);
		}
	}
	
	public static void StringCompare(){
		String s1 = "20140122";
		String s2 = "20131231";
		System.out.println("ddddd");
		if (s2.compareTo(s1) > 0) {
			System.out.println(s2.compareTo(s1));
			System.out.println("yes");
		}
	}

	public static void split2() {
		String patten = "ad r \n wer";
		patten = patten.replaceAll("\n", " ");
		String[] array = patten.split(" {1,}");
		StringBuilder sb = new StringBuilder();
		for (String string : array) {
			sb.append(string);
			System.out.println(string);
		}
		System.out.println(sb.toString());
		System.out.println(array.length);
		int i = -9;
		System.out.println("" + (1+-i));
	}
	
	public static void matchRegex(){
		String fromid = "234fsf2352哈";
		if (fromid.matches("[0-9a-zA-Z]+")) {
			System.out.println("true");
		}
	}

	public static void trancefer(){
		String s = "abc\r\nde";
		JSONObject json = new JSONObject();
		json.put("data", s);
		System.out.println(s);
		System.out.println(json);
		System.out.println(json.opt("data"));
	}
	
	public static void reference(){
		String s1 = new String("abc");
		String s2 = new String("abc");
		System.out.println(s1==s2); //不相等
		
		String s3 = "abc";
		String s4 = "abc";
		System.out.println(s3==s4);//相等
	}	
	
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		matchRegex();
	}
}
