package com.xienan.kalading;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PriceQuery {
	private static int i = 0;
	
	public static void getPrice(String carId, String parts, String items, BufferedWriter writer){
		String uri = "http://www.kalading.com/get_price";
		try {
			
			DefaultHttpClient client = new DefaultHttpClient();
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

			nameValuePairs.add(new BasicNameValuePair("parts", "[{\"brand\":\"鍢夊疄澶歕\",\"number\":\"纾佹姢 SN 5W-40\"},{\"brand\":\"鏇肩墝\",\"number\":\"5246c787098e710928000153\"},{\"brand\":\"姹夋牸鏂壒\",\"number\":\"5280cb9c098e71d85e000544\"},{\"brand\":\"鍗℃媺涓乗\",\"number\":\"539d58729a94e4d7bb000026\"}]"));
			nameValuePairs.add(new BasicNameValuePair("items", "[{\"brand\":\"鍢夊疄澶歕\",\"number\":\"纾佹姢 SN 5W-40\",\"price\":\"317.0\",\"item_name\":\"鏈烘补\"},{\"brand\":\"鏇肩墝\",\"number\":\"5246c787098e710928000153\",\"price\":\"28.0\",\"item_name\":\"鏈烘护\"},{\"brand\":\"姹夋牸鏂壒\",\"number\":\"5280cb9c098e71d85e000544\",\"price\":\"60.0\",\"item_name\":\"绌烘皵婊ゆ竻鍣╘\"},{\"brand\":\"鍗℃媺涓乗\",\"number\":\"539d58729a94e4d7bb000026\",\"price\":\"79.0\",\"item_name\":\"绌鸿皟婊ゆ竻鍣╘\"},{\"price\":\"150.0\",\"item_name\":\"鏈嶅姟璐筡\"}]"));
			nameValuePairs.add(new BasicNameValuePair("car_id", "531f1fec098e71b3f8003839"));
			
			HttpPost httpPost = new HttpPost(uri);
			
			httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs,"UTF-8"));
			
			httpPost.addHeader("Accept", "*/*");
			httpPost.addHeader("Accept-Encoding", "gzip,deflate");
			httpPost.addHeader("Accept-Language", "zh-CN,zh;q=0.8");
			httpPost.addHeader("Connection", "zh-CN,zh;q=0.8");
			//httpPost.addHeader("Content-Length", "9");//鏉╂瑤閲滅�妤侇唽娴兼俺鍤滈崝銊啎缂冿拷
			httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
			httpPost.addHeader("Cookie", "CNZZDATA1252972288=1662917683-1418286434-%7C1418286434; _kalading_base_session=VlNvTUVNbXI5Uk5hN1JYb3VmMjVLMnRXWGpQWGtUWDBIMmxkam9hNVZiNTFwRnV5dWRjdjA4UmRMUjAvZUpzdm1zU25kRkFuUXJTeDBjZ2pHbGYzR1ZNVXNhYVpqbEFIWnBOZ2NSSHI5MndDbkNJY25xeVdqaTI5cE5yOWJSZzVxc1VNNXp2TE91Z0pwOWxTSmhiNGRuSGRzM0oydjZEMmVrSGtmZnRKU2hSdU0yRFB0am5qekdVMnZ6NkF4djVZbEJBcjA2YkUya1hHdVQ4a1FsQ2JKV3VVU1AxR0t5b290b3BKcUN3akhyY1N1TlBLMDRvbDdSRkp5UWEyNkxaZkJCZDRHTjlKTGJEY09iU3lEcmZyRm9oUjZockhNUG9hNE9OZFNrbFpQTEtDWkxTdlRuT244ak9ZZjlyZzBMRzktLXdjT1FSK0VsUzl4cGc3dEhLQTJjZmc9PQ%3D%3D--8edc752eb6833726462f04ee7d035d78903654ef");
			httpPost.addHeader("Origin", "http://www.kalading.com");
			httpPost.addHeader("Referer", "http://www.kalading.com/reservation_service/shopping_detail?utf8=%E2%9C%93&car_id=531f1fec098e71b3f8003839&commit=%E6%9F%A5%E8%AF%A2");
			httpPost.addHeader("Host", "www.kalading.com");
			httpPost.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.63 Safari/537.36");
			httpPost.addHeader("X-Requested-With", "XMLHttpRequest");
			httpPost.addHeader("X-CSRF-Token", "pr3cXLuKjXtu7rpkwMVfYSFzML41Qez+xvRnuXTs3Io=");
			
			HttpResponse response = client.execute(httpPost);
			//System.out.println(EntityUtils.toString(response.getEntity()));			
			writer.append(carId + "::" + parts + "::" + items + "::" + EntityUtils.toString(response.getEntity()));
			writer.newLine();
			System.out.println(i++);
		} catch (Exception e) { 
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("d:\\products_new"), "utf-8"));		
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("d:\\prices"), "utf-8"));
				
		String s = null, carId = "5417bb6fa508a81ea10003a0";
		List<Params> jiyouList = new ArrayList<Params>();
		List<Params> jilvlList = new ArrayList<Params>();
		List<Params> kongqiList = new ArrayList<Params>();
		List<Params> kongtiaoList = new ArrayList<Params>();
		while ((s = reader.readLine()) != null) {
			String[] ss = StringUtils.split(s, "::");
			if (ss.length < 6) {				
				continue;
			}
			
			if (!carId.equals(ss[0])) {
				queryPriceForCar(carId, jiyouList, jilvlList, kongqiList, kongtiaoList, writer);
				carId = ss[0];
				jilvlList.clear();
				jiyouList.clear();
				kongqiList.clear();
				kongtiaoList.clear();
			}else {
				if (ss[1].equals("jiyou")) {
					jiyouList.add(new Params(ss[2], ss[3], ss[4], "机油"));
				}else if (ss[1].equals("jilv")) {
					jilvlList.add(new Params(ss[2], ss[3], ss[4], "机滤"));
				}else if (ss[1].equals("kongqi")) {
					kongqiList.add(new Params(ss[2], ss[3], ss[4], "空气过滤器"));
				}else if (ss[1].equals("kongtiao")) {
					kongtiaoList.add(new Params(ss[2], ss[3], ss[4], "空调过滤器"));
				}
			}			

		}				
		reader.close();
		writer.flush();
		writer.close();
	}
	
	private static void queryPriceForCar(String carId, List<Params> jiyouList, List<Params> jilvlList, List<Params> kongqiList, List<Params> kongtiaoList, BufferedWriter writer) {
		for (Params jiyou : jiyouList) {
			for (Params jilv : jilvlList) {
				for (Params kongqi : kongqiList) {
					for (Params kongtiao : kongtiaoList) {
						try {
							JSONArray partsArray =  new JSONArray();
							JSONObject jiyouJsonObject = new JSONObject();
							jiyouJsonObject.put("brand", jiyou.getBrand());
							jiyouJsonObject.put("number", jiyou.getNumber());
							
							JSONObject jilvJsonObject = new JSONObject();
							jilvJsonObject.put("brand", jilv.getBrand());
							jilvJsonObject.put("number", jilv.getNumber());
							
							JSONObject kongqiJsonObject = new JSONObject();
							kongqiJsonObject.put("brand", kongqi.getBrand());
							kongqiJsonObject.put("number", kongqi.getNumber());
							
							JSONObject kongtiaoJsonObject = new JSONObject();
							kongtiaoJsonObject.put("brand", kongtiao.getBrand());
							kongtiaoJsonObject.put("number", kongtiao.getNumber());
							
							partsArray.add(jiyouJsonObject);
							partsArray.add(jilvJsonObject);
							partsArray.add(kongqiJsonObject);
							partsArray.add(kongtiaoJsonObject);
							
							JSONArray itemsaArray = new JSONArray();
							itemsaArray.add(JSONObject.fromObject(jiyou));
							itemsaArray.add(JSONObject.fromObject(jilv));
							itemsaArray.add(JSONObject.fromObject(kongqi));
							itemsaArray.add(JSONObject.fromObject(kongtiao));
							
							getPrice(carId, partsArray.toString(), itemsaArray.toString(), writer);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}
		
	}

	
}
