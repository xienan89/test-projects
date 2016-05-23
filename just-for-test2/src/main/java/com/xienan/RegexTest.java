package com.xienan;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

	public static void t1(){
		String platformType = "iPhone OS3.2";
		Pattern pattern = Pattern.compile("iPhone OS[6-9].");
		Matcher matcher = pattern.matcher(platformType);
		if (matcher.find()) {
			System.out.println("yes");
		}
	}
	
	public static void t2(){
		String platformType = "iPhone OS3.2";
		Pattern pattern = Pattern.compile("iPhone OS3\\.2");
		Matcher matcher = pattern.matcher(platformType);
		if (matcher.find()) {
			System.out.println("yes");
		}
	}
	
	private static void t3(){
		String address = "北京还但  却4单      元32";
		address = address.replaceAll(" ", "");
		Pattern pattern = Pattern.compile("\\d+单元");
		Matcher matcher = pattern.matcher(address);
		if (matcher.find()) {
			address = address.substring(0, matcher.start());
		}
		System.out.println(address);
	}
	
	public static void group(){
		String s = "宝马ML级";
		Pattern pattern = Pattern.compile("[A-Z]+级");
		Matcher matcher = pattern.matcher(s);
		if (matcher.find()) {
			System.out.println(matcher.group());
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		group();
	}

}
