package cn.ebaoyang.crawler.chebao.baoyang;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.GZIPInputStream;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.AllClientPNames;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpParams;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class BaoyangNode {
	private static Map<Integer, String> itemMap = new HashMap<Integer, String>();
	private static Map<String, Integer> nameIdMap = new HashMap<String, Integer>();
	static{
		itemMap.put(28, "发动机机油");
		itemMap.put(2, "刹车油");
		itemMap.put(3, "方向机油");
		itemMap.put(5, "变速箱油");
		itemMap.put(21, "空调滤清器");
		itemMap.put(26, "空气滤清器");
		itemMap.put(20, "燃油滤清器");
		itemMap.put(18, "机油滤清器");
		itemMap.put(24, "前刹车片");
		itemMap.put(25, "后刹车片");
		itemMap.put(46, "报警线");
		itemMap.put(45, "免维护蓄电池");
		itemMap.put(14, "有骨雨刮片");
		itemMap.put(15, "无骨雨刮片");	
		itemMap.put(44, "后雨刮片");
		itemMap.put(48, "镍合金火花塞");
		itemMap.put(49, "铱金火花塞");
		itemMap.put(50, "铂金火花塞");
		itemMap.put(51, "铱铂金火花塞");
		itemMap.put(55, "钇金火花塞");
		itemMap.put(56, "银合金火花塞");
		itemMap.put(58, "机油添加剂");
		itemMap.put(41, "防冻冷却液");
		itemMap.put(59, "变速箱添加剂");
		itemMap.put(61, "汽/柴油添加剂");
		itemMap.put(42, "美容用品");
		itemMap.put(80, "玻璃水");
		itemMap.put(60, "空调清洗添加剂");
		itemMap.put(54, "喇叭");
		for (Entry<Integer, String> entry : itemMap.entrySet()) {
			nameIdMap.put(entry.getValue(), entry.getKey());
		}
	}
	
	private static final String cookie_url = "http://www.chebao360.com/savemodel.php?brand=23&model=684&output=1418&isnews=NaN&year=2008&click_img=&product_km=0";	
	public static String getCookie() throws ClientProtocolException, IOException{
		DefaultHttpClient client = new DefaultHttpClient();		
		HttpGet httpPost = new HttpGet(cookie_url);		
		httpPost.addHeader("Accept", "text/html, */*; q=0.01");	
		httpPost.addHeader("Accept-Encoding", "gzip, deflate");	
		httpPost.addHeader("Accept-Language", "zh-CN,zh;q=0.8");	
		httpPost.addHeader("Connection", "keep-alive");	
		//httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");	
		httpPost.addHeader("Host", "www.chebao360.com");	
		//httpPost.addHeader("Origin", "http://www.chebao360.com");	
		httpPost.addHeader("Referer", "http://www.chebao360.com/product_special.html");
		httpPost.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.71 Safari/537.36");
		//String cookie = "; save_user_car_in_cookie_str=a%3A6%3A%7Bs%3A9%3A%223102_2012%22%3Bs%3A62%3A%223102%40%40104%23%23%E5%B7%B4%E5%8D%9A%E6%96%AF%23%231125%23%2340S%23%232012%40%40%E5%B7%B4%E5%8D%9A%E6%96%AF+40S+3.5+2012+%22%3Bs%3A9%3A%221419_2008%22%3Bs%3A72%3A%221419%40%4023%23%23%E5%AE%9D%E9%A9%AC%23%23685%23%23120i%28%E6%95%9E%E7%AF%B7%29%23%232008%40%40%E5%AE%9D%E9%A9%AC+120i%28%E6%95%9E%E7%AF%B7%29+2.0+2008+%22%3Bs%3A9%3A%221207_2005%22%3Bs%3A58%3A%221207%40%4058%23%23%E6%AF%94%E4%BA%9A%E8%BF%AA%23%23569%23%23F3%23%232005%40%40%E6%AF%94%E4%BA%9A%E8%BF%AA+F3+1.5+2005+%22%3Bs%3A9%3A%222701_2008%22%3Bs%3A58%3A%222701%40%4023%23%23%E5%AE%9D%E9%A9%AC%23%23744%23%23740Li%23%232008%40%40%E5%AE%9D%E9%A9%AC+740Li+4.0+2008+%22%3Bs%3A9%3A%223520_2012%22%3Bs%3A65%3A%223520%40%4021%23%23%E5%A5%A5%E8%BF%AA%23%23580%23%23A4L%23%232012%40%40%E5%A5%A5%E8%BF%AA+A4L+2.0+TFSI+2012+%E6%96%B0%E6%AC%BE%22%3Bs%3A9%3A%222900_2005%22%3Bs%3A56%3A%222900%40%4023%23%23%E5%AE%9D%E9%A9%AC%23%23681%23%23120i%23%232005%40%40%E5%AE%9D%E9%A9%AC+120i+2.0+2005+%22%3B%7D; cookie_car_addtime=1429700199;";
		httpPost.addHeader("Cookie", "BRIDGE_R1707180=http://www.baidu.com/s?wd=%E8%BD%A6%E4%BF%9D%E7%BD%91&rsv_spt=1&issp=1&f=8&rsv_bp=0&rsv_idx=2&ie=utf-8&tn=baiduhome_pg; _ga=GA1.2.846900434.1423030730; PHPSESSID=cv30c5sn7oqfajbm00i59knov7; LXB_REFER=www.baidu.com; BRIDGE_REFRESH=15000; baidu_qiao_v3_count_1707180=1; Hm_lvt_c52426cad20f662492dfc1577d7f5afb=1429695789; Hm_lpvt_c52426cad20f662492dfc1577d7f5afb=1429700202; VERSION=2,0,0,0; BRIDGE_INVITE_0=0; BRIDGE_NEED=1; BRIDGE_CLOCK=1429703586719");
		
		 HttpParams params = client.getParams();  
	     params.setParameter(AllClientPNames.HANDLE_REDIRECTS, false);
		HttpResponse response = client.execute(httpPost);
		
		Header[] headers = response.getAllHeaders();
		String cookie = "";
		for (Header header : headers) {
			if (header.getName().equals("Set-Cookie")) {
				cookie += ";" + header.getName() + "=" + header.getValue();
			}
		}		
      
        return cookie;
	}
	
	private static final String GET_URL = "http://www.chebao360.com/get_special_product.php";	
	public static String getHtml(String cookie, String subtypeid_str) throws IOException{
		DefaultHttpClient client = new DefaultHttpClient();		
		HttpPost httpPost = new HttpPost(GET_URL);	
		httpPost.addHeader("Accept", "text/html, */*; q=0.01");	
		httpPost.addHeader("Accept-Encoding", "gzip, deflate");	
		httpPost.addHeader("Accept-Language", "zh-CN,zh;q=0.8");	
		//httpPost.addHeader("Cache-Control", "max-age=0");	
		httpPost.addHeader("Connection", "keep-alive");	
		httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");	
		httpPost.addHeader("Host", "www.chebao360.com");	
		httpPost.addHeader("Origin", "http://www.chebao360.com");	
		httpPost.addHeader("Referer", "http://www.chebao360.com/product_special.html");
		httpPost.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.71 Safari/537.36");
		
		httpPost.addHeader("Cookie", "BRIDGE_R1707180=http://www.baidu.com/s?wd=%E8%BD%A6%E4%BF%9D%E7%BD%91&rsv_spt=1&issp=1&f=8&rsv_bp=0&rsv_idx=2&ie=utf-8&tn=baiduhome_pg; _ga=GA1.2.846900434.1423030730; PHPSESSID=cv30c5sn7oqfajbm00i59knov7; LXB_REFER=www.baidu.com; BRIDGE_REFRESH=15000; baidu_qiao_v3_count_1707180=1; Hm_lvt_c52426cad20f662492dfc1577d7f5afb=1429695789; Hm_lpvt_c52426cad20f662492dfc1577d7f5afb=1429700202; VERSION=2,0,0,0; BRIDGE_INVITE_0=0; BRIDGE_NEED=1; BRIDGE_CLOCK=1429703586719" + cookie);
		
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

		nameValuePairs.add(new BasicNameValuePair("oper", "reload_km"));
		//nameValuePairs.add(new BasicNameValuePair("subtypeid_str", "14,44"));
		nameValuePairs.add(new BasicNameValuePair("subtypeid_str", subtypeid_str));
		
		httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs,"UTF-8"));
		
		HttpResponse response = client.execute(httpPost);

        GZIPInputStream in = null;
        in = new GZIPInputStream(response.getEntity().getContent()); 
		//InputStream in = new DataInputStream(response.getEntity().getContent());

        ByteArrayOutputStream out = new ByteArrayOutputStream();       

        byte[] buf = new byte[1024];
        int len;
        while((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }

        in.close();
        out.close();
		
        String result = out.toString();       
        //System.out.println(result);
        return result;		
	}
	
	public static Map<Integer, String> getRetFromHtml(String html){
		Map<Integer, String> resultMap = new HashMap<Integer, String>();
		Document docu = Jsoup.parse(html);		
		if (docu != null) {
			Elements lis = docu.getElementsByTag("li");
			if (lis != null) {
				for (Element element : lis) {	
					Elements ps = element.getElementsByTag("p");
					if (ps != null) {
						String ret = "";
						Integer id = null;
						for (Element p : ps) {
							if (!p.hasAttr("class")) {
								ret += p.text() + ";";
							}else {
								String name = p.text();
								if (name != null) {
									for (Entry<String, Integer> entry : nameIdMap.entrySet()) {
										if (name.contains(entry.getKey())) {
											id = entry.getValue(); break;
										}
									}
								}
							}
						}
						if (id != null) {
							resultMap.put(id, ret);							
						}
					}		
				}
			}			
		}
		
		
		return resultMap;
	}

	public static void main(String[] args) throws IOException {
		//getHtml("");
		//System.out.println(getCookie());
		String cookie = getCookie();
		String html = getHtml(cookie, "5,14,44");
		Map<Integer, String> resultMap = getRetFromHtml(html);
		for (Entry<Integer, String> entry : resultMap.entrySet()) {
			System.out.println(entry.getKey()+ " "+ entry.getValue());
		}
	}

}
