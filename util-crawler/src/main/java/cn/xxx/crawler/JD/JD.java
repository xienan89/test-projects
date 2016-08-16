package cn.xxx.crawler.JD;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.zip.GZIPInputStream;

import net.sf.json.JSONArray;

import org.apache.commons.lang.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.htmlparser.util.ParserException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class JD {
	private static final String GET_URL = "http://item.jd.com/644660.html";

	public static void getIDs() throws IOException {		
		DefaultHttpClient client = new DefaultHttpClient();		
		HttpGet httpPost = new HttpGet(GET_URL);		
		httpPost.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");	
		httpPost.addHeader("Referer", "http://item.jd.com/644620.html");
		httpPost.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.63 Safari/537.36");
		
		HttpResponse response = client.execute(httpPost);

		System.out.println("status code: " +  response.getStatusLine().getStatusCode());

        GZIPInputStream in = null;
        in = new GZIPInputStream(response.getEntity().getContent());       

        ByteArrayOutputStream out = new ByteArrayOutputStream();       

        byte[] buf = new byte[1024];
        int len;
        while((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }

        in.close();
        out.close();
		
        String result = out.toString("gbk");        
		
		Document docu = Jsoup.parse(result);
		Elements elements = docu.getElementsByAttributeValue("class", "dd");
		for (Element element : elements) {
			Elements itmes = element.getElementsByAttributeValue("class", "item");
			for (Element element2 : itmes) {	
				Elements as = element2.getElementsByTag("a");
				for (Element element3 : as) {
					System.out.println(element3.attr("href") + "|" + element3.attr("title"));
				}
			}			
		}
	}
	
	public static void getPicInfo(String title, String url, BufferedWriter writer) throws ClientProtocolException, IOException{
		DefaultHttpClient client = new DefaultHttpClient();		
		HttpGet httpPost = new HttpGet(url);		
		
		httpPost.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");	
		httpPost.addHeader("Referer", "http://item.jd.com/644620.html");
		httpPost.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.63 Safari/537.36");
		
		HttpResponse response = client.execute(httpPost);

        InputStream in = response.getEntity().getContent();
        Header[] heads = response.getAllHeaders();
        if (heads != null) {
			for (Header header : heads) {
				if (header.getName().equals("Content-Encoding") && header.getValue().equals("gzip")) {
					 in = new GZIPInputStream(response.getEntity().getContent());   
					 break;
				}
			}
		}           

        ByteArrayOutputStream out = new ByteArrayOutputStream();    
        byte[] buf = new byte[1024];
        int len;
        while((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }

        System.out.println("Closing the file and stream");
        in.close();
        out.close();
		
        String result = out.toString("gbk");        
		
		Document docu = Jsoup.parse(result);
		Elements elements = docu.getElementsByAttributeValue("class", "formwork_img");
		for (Element element : elements) {
			Elements imgs = element.getElementsByAttribute("data-lazyload");
			for (Element element2 : imgs) {					
				System.out.println(element2.attr("data-lazyload"));
				writer.append(element2.attr("data-lazyload") + "\t" + title);
				writer.newLine();
			}			
		}
	}
	
	public static void mgetMahle(String inFileName, String outFileName) throws IOException, InterruptedException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inFileName), "utf-8"));		
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFileName), "utf-8"));
				
		String s = null, title = null, url = null;
		while ((s = reader.readLine()) != null) {
			try {
				String[] ss = StringUtils.split(s, "|");
				url = ss[0];
				title = ss[1];
				
				getPicInfo(title, url, writer);
				Thread.sleep(100);
			} catch (Exception e) {
				writer.append(title + "|" + url + "|" + "error");
				writer.newLine();
			}
		}
		
		reader.close();
		writer.close();
	}	

	
	public static void mgetHangst(String inFileName, String outFileName) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inFileName), "utf-8"));		
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFileName), "utf-8"));
				
		String s = null, title = null, url = null;
		while ((s = reader.readLine()) != null) {
			try {
				String[] ss = StringUtils.split(s, "|");
				url = ss[0];
				title = ss[1];
				
				getHangstPicInfo(title, url, writer);
				Thread.sleep(100);
			} catch (Exception e) {
				writer.append(title + "|" + url + "|" + "error");
				writer.newLine();
			}
		}
		
		reader.close();
		writer.close();
	}
	
	private static void getHangstPicInfo(String title, String url,	BufferedWriter writer) throws ClientProtocolException, IOException {
		DefaultHttpClient client = new DefaultHttpClient();		
		HttpGet httpPost = new HttpGet(url);		
		
		httpPost.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");	
		httpPost.addHeader("Referer", "http://item.jd.com/1020459.html");
		httpPost.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.63 Safari/537.36");
		
		HttpResponse response = client.execute(httpPost);

        InputStream in = response.getEntity().getContent();
        Header[] heads = response.getAllHeaders();
        if (heads != null) {
			for (Header header : heads) {
				if (header.getName().equals("Content-Encoding") && header.getValue().equals("gzip")) {
					 in = new GZIPInputStream(response.getEntity().getContent());   
					 break;
				}
			}
		}           

        ByteArrayOutputStream out = new ByteArrayOutputStream();    
        byte[] buf = new byte[1024];
        int len;
        while((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }

        in.close();
        out.close();
		
        String result = out.toString("gbk"); 
        int start = result.indexOf("适用车型") + 64;
        int end = result.indexOf("产品展示") - 59;
        result = result.substring(start, end);
        
		Document docu = Jsoup.parse(result);
		
		Elements imgs = docu.getElementsByAttribute("data-lazyload");
		for (Element element2 : imgs) {
			System.out.println(element2.attr("data-lazyload"));
			writer.append(element2.attr("data-lazyload") + "\t" + title);
			writer.newLine();
		}
	}
	
	public static void getPrice(String  url, String title, BufferedWriter writer) throws ClientProtocolException, IOException{
		int start = url.indexOf("http://item.jd.com/") + "http://item.jd.com/".length();
		int ent = url.indexOf(".html");
		String jid = url.substring(start, ent);
		String getUrl = "http://p.3.cn/prices/get?type=1&area=1_72_2799&callback=cnp&skuid=J_" + jid;
		DefaultHttpClient client = new DefaultHttpClient();		
		HttpGet httpPost = new HttpGet(getUrl);		
		
		httpPost.addHeader("Accept", "*/*");
		httpPost.addHeader("Accept-Encoding", "gzip, deflate, sdch");	
		httpPost.addHeader("Accept-Language", "zh-CN,zh;q=0.8");	
		httpPost.addHeader("Cache-Control", "max-age=0");	
		httpPost.addHeader("Connection", "keep-alive");	
		httpPost.addHeader("Host", "p.3.cn");	
		httpPost.addHeader("Accept", "*/*");	
		httpPost.addHeader("Referer", "http://item.jd.com/1020459.html");
		httpPost.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.63 Safari/537.36");
		
		HttpResponse response = client.execute(httpPost);

        InputStream in = response.getEntity().getContent();
        Header[] heads = response.getAllHeaders();
        if (heads != null) {
			for (Header header : heads) {
				if (header.getName().equals("Content-Encoding") && header.getValue().equals("gzip")) {
					 in = new GZIPInputStream(response.getEntity().getContent());   
					 break;
				}
			}
		}           

        ByteArrayOutputStream out = new ByteArrayOutputStream();    
        byte[] buf = new byte[1024];
        int len;
        while((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }

        in.close();
        out.close();
		
        String result = out.toString("gbk"); 
        result = result.replaceAll("cnp\\(", "").replaceAll("\\);", "");
        System.out.println(result);
        JSONArray array = JSONArray.fromObject(result);
        int price = array.getJSONObject(0).optInt("p");

        System.out.println(title + "\t" + jid + "\t" + price);
		writer.append(title + "\t" + jid + "\t" + price);
		writer.newLine();
	}
	
	public static void getPrices(String inFileName, String outFileName) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inFileName), "utf-8"));		
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFileName), "utf-8"));
				
		String s = null, title = null, url = null;
		while ((s = reader.readLine()) != null) {
			try {
				String[] ss = StringUtils.split(s, "|");
				url = ss[0];
				title = ss[1];				

				getPrice(url, title, writer);
				Thread.sleep(100);
			} catch (Exception e) {
				writer.append(title + "|" + url + "|" + "error");
				writer.newLine();
				e.printStackTrace();
			}
		}
		
		reader.close();
		writer.close();
	}

	public static void main(String[] args) throws IOException, ParserException, InterruptedException {

		getIDs();
		//mgetMahle("d:\\jd\\mahle_jilv.txt", "d:\\jd\\mahle_jilv_pic.txt");
		//mgetMahle("d:\\jd\\mahle_kongqi.txt", "d:\\jd\\mahle_kongqi_pic.txt");
		//mgetHangst("d:\\jd\\hangst_jilv.txt", "d:\\jd\\hangst_jilv_pic.txt");
		//mgetHangst("d:\\jd\\hangst_kongqi.txt", "d:\\jd\\hangst_kongqi_pic.txt");
		
		/*getPrices("d:\\jd\\mahle_jilv.txt", "d:\\jd\\mahle_jilv_price.txt");
		getPrices("d:\\jd\\mahle_kongqi.txt", "d:\\jd\\mahle_kongqi_price.txt");
		getPrices("d:\\jd\\hangst_jilv.txt", "d:\\jd\\hangst_jilv_pirce.txt");
		getPrices("d:\\jd\\hangst_kongqi.txt", "d:\\jd\\hangst_kongqi_price.txt");*/
	}

}
