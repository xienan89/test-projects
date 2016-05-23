package com.xienan.http;

import java.util.Random;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

/**
 * @author nan.xie
 * @date 2014-11-4 上午11:14:33
 */
public class Hiapk {
	
	public static void main(String[] args) {
		String mktparam = getRandomString(400);
		openHiapk(mktparam);
		downMini(mktparam);
	}

	public static void openHiapk(String mktparam){
		String uri = "http://market.hiapk.com/service/api2.php?qt=5301";
		try {			
			DefaultHttpClient client = new DefaultHttpClient();		
			
			
			HttpGet httpGet = new HttpGet(uri);			
			
			httpGet.addHeader("peer", "1");
			httpGet.addHeader("authorizations", "0");
			httpGet.addHeader("netcode", "1");
			httpGet.addHeader("model", "MI 2SC");
			//httpPost.addHeader("Content-Length", "9");//这个字段会自动设置
			httpGet.addHeader("density", "320");
			httpGet.addHeader("abi", "armeabi-v7a|armeabi");
			httpGet.addHeader("mktvercode", "84");
			httpGet.addHeader("vender", "17001");
			httpGet.addHeader("resolution", "720x1280");
			httpGet.addHeader("marketparams", mktparam);
			httpGet.addHeader("mktvername", "4.3.7");
			httpGet.addHeader("sdkversion", "16");
			httpGet.addHeader("Accept-Encoding", "gzip");
			httpGet.addHeader("pv", "2.2");
			httpGet.addHeader("clientmarket", "1");
			httpGet.addHeader("applang", "3");
			httpGet.addHeader("Host", "market.hiapk.com");
			httpGet.addHeader("Connection", "Keep-Alive");
			httpGet.addHeader("User-Agent", "Apache-HttpClient/UNAVAILABLE (java 1.4)");
					
			
			HttpResponse response = client.execute(httpGet);
			System.out.println("open hiapk:" + EntityUtils.toString(response.getEntity()));
			
		} catch (Exception e) { 
			e.printStackTrace();
		}
	}
	
	public static void openMiniDetail(){
		
	}
	
	public static void downMini(String mktparam){
		String firstUri = "http://59.56.24.225/service/api2.php?qt=9001&apk=3168385&downurl=http%3A%2F%2Fapk.r1.market.hiapk.com%2Fdata%2Fupload%2F2014%2F10_23%2F16%2Fcom.renren.mini.android_163144.apk&downparams=sviptodoc2VpZD05ZmUxOTlhNi1iZDY0LTRmMTMtYjY0MS1hZmMyODA5NjE0OGImcGk9MSZwcz0yMCZwbz0wJnNvdXJjZT0yNiZwaWQ9MzQmY2lkPTQ1&sign=c12d98ec7475ac3f0db8be0898bdc04b&lowapkmd5=null&type=1&daction=2";
		try {			
			DefaultHttpClient client = new DefaultHttpClient();					
			
			HttpGet httpGet = new HttpGet(firstUri);			
			
			httpGet.addHeader("peer", "1");
			httpGet.addHeader("authorizations", "0");
			httpGet.addHeader("netcode", "1");
			httpGet.addHeader("model", "MI 2SC");
			httpGet.addHeader("ts", "2");
			httpGet.addHeader("isretry", "0");
			//httpPost.addHeader("Content-Length", "9");//这个字段会自动设置
			httpGet.addHeader("density", "320");
			httpGet.addHeader("abi", "armeabi-v7a|armeabi");
			httpGet.addHeader("mktvercode", "84");
			httpGet.addHeader("vender", "17001");
			httpGet.addHeader("resolution", "720x1280");
			httpGet.addHeader("partial", "0");
			httpGet.addHeader("marketparams", mktparam);
			httpGet.addHeader("mktvername", "4.3.7");
			httpGet.addHeader("sdkversion", "16");
			httpGet.addHeader("Accept-Encoding", "gzip");
			httpGet.addHeader("pv", "2.2");
			httpGet.addHeader("clientmarket", "1");
			httpGet.addHeader("applang", "3");
			httpGet.addHeader("Host", "market.hiapk.com");
			httpGet.addHeader("Connection", "Keep-Alive");
			httpGet.addHeader("User-Agent", "Apache-HttpClient/UNAVAILABLE (java 1.4)");
					
			
			HttpResponse response = client.execute(httpGet);
			System.out.println("down first get:" + EntityUtils.toString(response.getEntity()));
			
			
			String sencendUri = "http://apk.r1.market.hiapk.com/data/upload/2014/10_23/16/com.renren.mini.android_163144.apk";				
			
			HttpGet secondGet = new HttpGet(sencendUri);	

			secondGet.addHeader("Host", "apk.r1.market.hiapk.com");
			secondGet.addHeader("Connection", "Keep-Alive");
			secondGet.addHeader("User-Agent", "Apache-HttpClient/UNAVAILABLE (java 1.4)");					
			
			HttpResponse secondResponse = client.execute(secondGet);
			System.out.println("down second get:" + EntityUtils.toString(secondResponse.getEntity()).length());
		} catch (Exception e) { 
			e.printStackTrace();
		}
	}
	
	private static String getRandomString(int length) { //length表示生成字符串的长度
	    String base = "abcdefghijklmnopqrstuvwxyz0123456789";   
	    Random random = new Random();   
	    StringBuffer sb = new StringBuffer();   
	    for (int i = 0; i < length; i++) {   
	        int number = random.nextInt(base.length());   
	        sb.append(base.charAt(number));   
	    }   
	    return sb.toString();   
	 }   

}
