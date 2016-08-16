package cn.xxx.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MyHttpClient {
	
	public static String sendGet(String url, String codeType) throws IOException{
		URL getUrl = new URL(url);

		HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();

		connection.connect();

		BufferedReader netreader = new BufferedReader(new InputStreamReader(connection.getInputStream(), codeType));

		String lines = "", line;

		while ((line = netreader.readLine()) != null) {
			lines += line;
		}

		connection.disconnect();
		
		return lines;
	}
	
	public static InputStream getUrlInputStream(String url) throws IOException{
		URL getUrl = new URL(url);

		HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
		connection.connect();


		connection.disconnect();
		
		return connection.getInputStream();
	}

}
