package cn.xxx.crawler.sina;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import cn.xxx.crawler.sina.GetCarSubBrand.Car;
import cn.xxx.utils.MD5Util;

public class GetCarids {
	private static final String GET_URL = "http://app.baichebao.com/car/care?callback=jsonpCallback&sign=b80832c2930357050568db908181a4e8&source=sina&car_ids=";

	public static String getIDs(String targetCarId) throws IOException {		
		DefaultHttpClient client = new DefaultHttpClient();		
		HttpGet httpPost = new HttpGet(GET_URL + targetCarId + getSign(targetCarId));		
		httpPost.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");	
		httpPost.addHeader("Accept-Encoding", "gzip, deflate, sdch");	
		httpPost.addHeader("Accept-Language", "zh-CN,zh;q=0.8");	
		httpPost.addHeader("Cache-Control", "max-age=0");	
		httpPost.addHeader("Connection", "keep-alive");	
		httpPost.addHeader("Host", "app.baichebao.com");	
		//httpPost.addHeader("Referer", "http://item.jd.com/644620.html");
		httpPost.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.63 Safari/537.36");
		//httpPost.addHeader("Cookie", "UOR=blog.sina.com.cn,blog.sina.com.cn,; U_TRS1=0000007d.c7912c56.5497a9b3.c2d5ed6b; SINAGLOBAL=114.253.38.125_1419225522.840546; vjuids=-ba465842d.14a706ee6ba.0.fcf5bc4f; SGUID=1419225524274_45088178; SUB=_2AkMjyyaOf8NhqwJRmPkSzmLqbIV3zgjEiebDAH_sJxIyHmA57KFt67inLIrV7U3_XlO4v-VWJ3Sq; SUBP=0033WrSXqPxfM72-Ws9jqgMF55529P9D9WhkGBM2IrJoZwmlX6eOWLB3; lxlrtst=1428910795_o; lxlrttp=1428910795; SINADATAGUIDE=2; usrmweb3=usrmdinst_0; Apache=114.246.95.1_1428928870.454634; ULV=1428929391432:8:4:3:114.246.95.1_1428928870.454634:1428928871307; dpha=usrmdinst_1; U_TRS2=00000001.e1897ba.552bbbc9.0367b65e; PHPSESSID=h2lmif714pn876brnc3kgp8ea3; historyNum=; vjlast=1428914663.1428914683.10");
		
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
	
	private static String getSign(String targetCarId) {
		String s = "callback=jsonpCallbackcar_ids=" + targetCarId + "source=sinafaf1fc8d8fb091bd752562b2667aa0ab";
		return "&sign=" + MD5Util.md5(s);
	}
	
	public static void getSubsInfo() throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("d:\\sina_subid.txt"), "gbk"));		
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("d:\\sinaret1.txt"), "utf-8"));
		String s = null;
		while ((s=reader.readLine()) != null) {
				try {
					String[] ss = StringUtils.split(s, "|");
					/*String carId = GetCarSubBrand.getFirstCarIdFromSub(ss[2]);//先取到车型列表中的id
					System.out.println("first sbu brand id " + carId);
					String targetId = CarMapGet.getTargetCarId(carId);//车型列表中的id换成请求百车宝接口的id
					System.out.println("target id " + targetId);
					
					String ret = getIDs(targetId);
					System.out.println("ret:" + ret);
					System.out.println(ss[0] + "|" + ss[1] + "|" + ss[2] + "|" + ret);
					writer.append(ss[0] + "|" + ss[1] + "|" + ss[2] + "|" + ret);
					writer.newLine();*/
					List<Car> cars = GetCarSubBrand.getCarsFromSub(ss[2]);
					for (Car car : cars) {
						try {
							String targetId = CarMapGet.getTargetCarId(car.getCarId());//车型列表中的id换成请求百车宝接口的id
							System.out.println("target id " + targetId);
							
							String ret = getIDs(targetId);
							System.out.println("ret:" + ret);
							System.out.println(ss[0] + "|" + ss[1] + "|" + ss[2] + "|"  + car.getCname() + "|" + ret);
							writer.append(ss[0] + "|" + ss[1] + "|" + ss[2] + "|" + car.getCname() + "|" + ret);
							writer.newLine();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		
		reader.close();
		writer.close();
	}	

	
	public static void main(String[] args) {
		try {
			//getIDs("194");
			getSubsInfo();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
