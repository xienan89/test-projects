package cn.ebaoyang.crawler.sina;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

import net.sf.json.JSONObject;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import cn.ebaoyang.utils.MD5Util;

public class CarMapGet {
	private static final String GET_URL = "http://app.baichebao.com/partner/car_map/get?callback=jsonpCallback&type=cars&source=sina&partner_id=";

	public static String getMap(String carId) throws IOException {		
		DefaultHttpClient client = new DefaultHttpClient();		
		HttpGet httpPost = new HttpGet(GET_URL + carId + getSign(carId));	
		System.out.println(GET_URL + carId + getSign(carId));
		httpPost.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");	
		httpPost.addHeader("Accept-Encoding", "gzip, deflate, sdch");	
		httpPost.addHeader("Accept-Language", "zh-CN,zh;q=0.8");	
		httpPost.addHeader("Cache-Control", "max-age=0");	
		httpPost.addHeader("Connection", "keep-alive");	
		httpPost.addHeader("Host", "app.baichebao.com");	
		//httpPost.addHeader("Referer", "http://data.auto.sina.com.cn/baoyang/subid_" + carIds + "/");
		httpPost.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.71 Safari/537.36");
		//httpPost.addHeader("Cookie", "UOR=blog.sina.com.cn,blog.sina.com.cn,; U_TRS1=0000007d.c7912c56.5497a9b3.c2d5ed6b; SINAGLOBAL=114.253.38.125_1419225522.840546; vjuids=-ba465842d.14a706ee6ba.0.fcf5bc4f; SGUID=1419225524274_45088178; SUB=_2AkMjyyaOf8NhqwJRmPkSzmLqbIV3zgjEiebDAH_sJxIyHmA57KFt67inLIrV7U3_XlO4v-VWJ3Sq; SUBP=0033WrSXqPxfM72-Ws9jqgMF55529P9D9WhkGBM2IrJoZwmlX6eOWLB3; lxlrtst=1428910795_o; lxlrttp=1428910795; SINADATAGUIDE=2; usrmweb3=usrmdinst_0; Apache=114.246.95.1_1428928870.454634; ULV=1428929391432:8:4:3:114.246.95.1_1428928870.454634:1428928871307; dpha=usrmdinst_1; U_TRS2=00000001.e1897ba.552bbbc9.0367b65e; PHPSESSID=h2lmif714pn876brnc3kgp8ea3; historyNum=; vjlast=1428914663.1428978251.11");
		
		HttpResponse response = client.execute(httpPost);

        //GZIPInputStream in = null;
        //in = new GZIPInputStream(response.getEntity().getContent()); 
		InputStream in = new DataInputStream(response.getEntity().getContent());

        ByteArrayOutputStream out = new ByteArrayOutputStream();       

        byte[] buf = new byte[1024];
        int len;
        while((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }

        in.close();
        out.close();
		
        String result = out.toString("utf-8");       
        System.out.println(result);
        return result;		
	}
	
	public static String getTargetCarId(String carId) throws IOException{
		String ret = getMap(carId);
		ret = ret.substring(18, ret.length()-2);
		JSONObject json = JSONObject.fromObject(ret);
		String targetId = json.optJSONArray("data").getJSONObject(0).optString("car_id");
		return targetId;
	}

	private static String getSign(String carId) {
		String s = "callback=jsonpCallbackpartner_id=" + carId + "source=sinatype=carsfaf1fc8d8fb091bd752562b2667aa0ab";
		return "&sign=" + MD5Util.md5(s);
	}

	public static void main(String[] args) throws IOException {
		//getMap(747 + "");
		getTargetCarId(17317+"");
	}

}
