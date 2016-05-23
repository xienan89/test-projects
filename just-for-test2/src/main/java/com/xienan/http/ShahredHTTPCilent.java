package com.xienan.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class ShahredHTTPCilent {

	public static void main(String[] args) throws IOException {
		String getURL = "http://www.baidu.com";
		String sData = "";

		URL getUrl = new URL(getURL);

		// 根据拼凑的URL，打开连接，URL.openConnection()函数会根据
		// URL的类型，返回不同的URLConnection子类的对象，在这里我们的URL是一个http，因此它实际上返回的是HttpURLConnection
		HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
		connection.setDoOutput(true);

		// 建立与服务器的连接，并未发送数据
		connection.connect();
		
		OutputStreamWriter ow;
        ow = new OutputStreamWriter(connection.getOutputStream(), "utf-8");
        ow.write(sData);
        ow.flush();
        
        InputStream in = null;
        try {
            in = connection.getInputStream();
        } catch (Exception e) {
            in = connection.getErrorStream();
        }

        StringBuilder sb = new StringBuilder();
        byte[] b = new byte[512];
        while (in.read(b)!=-1) {
        	b = new byte[512];
        	sb.append(new String(b));
		}
        System.out.println(sb.toString());
        
        connection.disconnect();
	}

}
