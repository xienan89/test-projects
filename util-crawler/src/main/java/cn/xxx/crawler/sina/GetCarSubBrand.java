package cn.xxx.crawler.sina;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class GetCarSubBrand {

	private static final String GET_URL = "http://data.auto.sina.com.cn/car/api/get_subbrand_info.php?oe=utf-8&format=json&callbk=jQuery17207493656370788813_1428987970794&product=1&_=1428987970866&subbrand_id=";

	public static String getIDs(String carIds) throws IOException {		
		DefaultHttpClient client = new DefaultHttpClient();		
		HttpGet httpPost = new HttpGet(GET_URL + carIds);		
		httpPost.addHeader("Accept", "text/javascript, application/javascript, application/ecmascript, application/x-ecmascript, */*; q=0.01");	
		httpPost.addHeader("Accept-Encoding", "gzip, deflate, sdch");	
		httpPost.addHeader("Accept-Language", "zh-CN,zh;q=0.8");	
		httpPost.addHeader("Cache-Control", "max-age=0");	
		httpPost.addHeader("Connection", "keep-alive");	
		httpPost.addHeader("Host", "data.auto.sina.com.cn");	
		httpPost.addHeader("Referer", "http://data.auto.sina.com.cn/baoyang/subid_" + carIds + "/");
		httpPost.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.63 Safari/537.36");
		httpPost.addHeader("Cookie", "UOR=blog.sina.com.cn,blog.sina.com.cn,; U_TRS1=0000007d.c7912c56.5497a9b3.c2d5ed6b; SINAGLOBAL=114.253.38.125_1419225522.840546; vjuids=-ba465842d.14a706ee6ba.0.fcf5bc4f; SGUID=1419225524274_45088178; SUB=_2AkMjyyaOf8NhqwJRmPkSzmLqbIV3zgjEiebDAH_sJxIyHmA57KFt67inLIrV7U3_XlO4v-VWJ3Sq; SUBP=0033WrSXqPxfM72-Ws9jqgMF55529P9D9WhkGBM2IrJoZwmlX6eOWLB3; lxlrtst=1428910795_o; lxlrttp=1428910795; SINADATAGUIDE=2; usrmweb3=usrmdinst_0; Apache=114.246.95.1_1428928870.454634; ULV=1428929391432:8:4:3:114.246.95.1_1428928870.454634:1428928871307; dpha=usrmdinst_1; U_TRS2=00000001.e1897ba.552bbbc9.0367b65e; PHPSESSID=h2lmif714pn876brnc3kgp8ea3; historyNum=; vjlast=1428914663.1428978251.11");
		
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
		
		/*Document docu = Jsoup.parse(result);
		Elements elements = docu.getElementsByAttributeValue("class", "dd");
		for (Element element : elements) {
			Elements itmes = element.getElementsByAttributeValue("class", "item");
			for (Element element2 : itmes) {	
				Elements as = element2.getElementsByTag("a");
				for (Element element3 : as) {
					System.out.println(element3.attr("href") + "|" + element3.attr("title"));
				}
			}			
		}*/
	}
	
	public static String getFirstCarIdFromSub(String subId) throws IOException{
		String ret = getIDs(subId);
		ret = ret.substring(41, ret.length()-1);
		JSONObject json = JSONObject.fromObject(ret);
		String carid = json.optJSONArray("car_list").getJSONObject(0).optString("car_id");
		return carid;
	}
	
	public static List<Car> getCarsFromSub(String subId) throws IOException{
		String ret = getIDs(subId);
		ret = ret.substring(41, ret.length()-1);
		JSONObject json = JSONObject.fromObject(ret);
		
		List<Car> carIds = new ArrayList<Car>();
		JSONArray array = json.optJSONArray("car_list");
		for (int i = 0; i < array.size(); i++) {
			String carId = array.getJSONObject(i).optString("car_id");
			String cname = array.getJSONObject(i).optString("cname");
			Car car = new Car();
			car.setCarId(carId);
			car.setCname(cname);
			carIds.add(car);
		}
		return carIds;
	}
	
	public static void main(String[] args) throws IOException {
		//getIDs("");
		getFirstCarIdFromSub("" + 88);
	}

	static class Car{
		String carId;
		String cname;
		public String getCarId() {
			return carId;
		}
		public void setCarId(String carId) {
			this.carId = carId;
		}
		public String getCname() {
			return cname;
		}
		public void setCname(String cname) {
			this.cname = cname;
		}
	}
}
