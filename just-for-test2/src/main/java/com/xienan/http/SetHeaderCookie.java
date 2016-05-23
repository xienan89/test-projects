package com.xienan.http;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.Header;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * @author nan.xie
 * @date 2014-10-31 下午9:16:01
 */
public class SetHeaderCookie {

	public static void main(String args[]){
		String uri = "http://10.3.20.160:43671/http";
		try {			
			DefaultHttpClient client = new DefaultHttpClient();
			/*Integer socketTimeout = 10000;
			Integer connectionTimeout = 10000;
			client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, socketTimeout);
			client.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, connectionTimeout);
			client.getParams().setParameter(CoreConnectionPNames.TCP_NODELAY, false);
			client.getParams().setParameter(CoreConnectionPNames.SOCKET_BUFFER_SIZE, 1024 * 1024);			*/

			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

			nameValuePairs.add(new BasicNameValuePair("msg", "parammsg"));
			nameValuePairs.add(new BasicNameValuePair("param2", "123123"));
			
			HttpPost httpPost = new HttpPost(uri);
			
			httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs,"UTF-8"));
			
			httpPost.addHeader("Accept", "application/json, text/javascript, */*; q=0.01");
			httpPost.addHeader("Accept-Encoding", "gzip,deflate,sdch");
			httpPost.addHeader("Accept-Language", "zh-CN,zh;q=0.8");
			httpPost.addHeader("Connection", "keep-alive");
			//httpPost.addHeader("Content-Length", "9");//这个字段会自动设置
			httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
			httpPost.addHeader("Cookie", "Hm_lvt_c896b22b31eac0a9bc398e963b87fc56=1414753075,1414753956,1414760312,1414760353; Hm_lpvt_c896b22b31eac0a9bc398e963b87fc56=1414760353; UOR=blog.sina.com.cn,blog.sina.com.cn,; U_TRS1=000000f9.f9697b46.5374635d.fb198673; SINAGLOBAL=123.125.40.249_1400136541.315409; vjuids=5cf5c5f67.145fea43b6f.0.eedaeaab; SGUID=1400136547464_94081536; U_TRS2=000000f9.cc4e1d32.54536a18.a1a33364; PHPSESSID=u7ptsff9evt5pmh2i3bh8trdj6; dpha=usrmdinst_9; Apache=123.125.40.249_1414752794.356527; dpvar=usrmdinst_1; ULV=1414752823980:11:4:1:123.125.40.249_1414752794.356527:1414128424248; vjlast=1414752825; user_survey=2014103101; lxlrtst=1414746709_o; lxlrttp=1414746709; SUS=SID-1804668111-1414753071-XD-ldbu4-6a80f80982d31e3dc5d02bc509b83bee; SUE=es%3D28ce5e9c05e18ff9edbef0460eabe9d6%26ev%3Dv1%26es2%3D6df233ac15a04122513328068ac1e5af%26rs0%3D3I9KPBOKK4VQ%252BeGYtESV2f%252F4Pz%252BF8TFvZ4cTIDnfRRCeNebuEkT%252BfqqiHEeIvdPgMbw11sAFb%252FtiZBPLTj1Cq%252Fzvxg%252BY4i2NjjRdp%252FSLKzohSwvjJKfIYHuHBBNG8qx91mtUQD2zgjE6u2HstCat12%252FGu6JuQ1ftO7bTfoo5ouE%253D%26rv%3D0; SUP=cv%3D1%26bt%3D1414753071%26et%3D1414839471%26d%3D40c3%26i%3D3bee%26us%3D1%26vf%3D0%26vt%3D0%26ac%3D2%26st%3D0%26lt%3D1%26uid%3D1804668111%26user%3Dxienan89.cn%26ag%3D8%26name%3Dxienan89%2540sina.cn%26nick%3D%25E7%2594%25A8%25E6%2588%25B71804668111%26sex%3D%26ps%3D0%26email%3Dxienan89%2540sina.cn%26dob%3D%26ln%3Dxienan89%2540sina.cn%26os%3D%26fmp%3D%26lcp%3D; SUB=_2AkMjD-QYa8NlrAJZmPwTymPjbYxH-jyQ3-juAn7tJhIyHRh-7mY_qSXPL75Bo43iwvaYAQ2U8VDpK06afA..; SUBP=0033WrSXqPxfM725Ws9jqgMF55529P9D9WFgIMuGK_WLhDYCLK3l06HG; ALF=1446289071; sso_info=v02m6alo5qztKWRk5yljpOQpZCToKWRk5iljoOgpZCjnLGOg4C0jaOYuIyThLGJp5WpmYO0sY6DgLSNo5i4jJOEsQ==");
			httpPost.addHeader("Host", "all.vic.sina.com.cn");
			httpPost.addHeader("Origin", "http://all.vic.sina.com.cn");
			httpPost.addHeader("Referer", "http://all.vic.sina.com.cn/201410mxg/index.php?anu=weibo");
			httpPost.addHeader("Host", "all.vic.sina.com.cn");
			httpPost.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.63 Safari/537.36");
			httpPost.addHeader("X-Requested-With", "XMLHttpRequest");
			
			httpPost.getParams().setIntParameter("pic_id", 14);
			httpPost.getParams().setParameter("anu", "add_vote");
			
			HttpResponse response = client.execute(httpPost);
			System.out.println(EntityUtils.toString(response.getEntity()));			

		} catch (Exception e) { 
			e.printStackTrace();
		}
	}	

}
