package cn.xxx.crawler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.lang.StringUtils;
import org.htmlparser.util.ParserException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Kalading {
	private static final String GET_URL = "http://www.kalading.com/reservation_service/series_options_html/";
	private static final String MODLE_OPTIONS_URL = "http://www.kalading.com/reservation_service/model_options_html/";
	private static final String PRICE_URL = "http://www.kalading.com/reservation_service/shopping_detail?utf8=%E2%9C%93&car_id=";

	public static void brand() {
		String brands = "<option value=531f1efd098e71b3f8000c30>大众(�?��)</option><option value=531f1edf098e71b3f8000649>大众(上海)</option><option value=531f1ed7098e71b3f8000408>别克(上海通用)</option><option value=531f1fdc098e71b3f800355f>雪佛�?上海通用)</option><option value=531f1fcc098e71b3f800306c>现代(北京)</option><option value=531f1f75098e71b3f800211e>日产(东风)</option><option value=531f1f0a098e71b3f8000eac>奥迪(进口)</option><option value=531f1f26098e71b3f80013f3>奥迪(�?��)</option><option value=53b743969a94e47c2e00519e>保时�?进口) </option><option value=531f1f63098e71b3f8001e29>宝骏(上汽通用五菱)</option><option value=531f1f5a098e71b3f8001cab>宝马(华晨)</option><option value=531f1f30098e71b3f800156b>宝马(进口)</option><option value=53cf72d49a94e4f20a001066>北汽</option><option value=531f1fb6098e71b3f8002b03>奔驰(北京)</option><option value=531f1fbc098e71b3f8002bbf>奔驰(福建)</option><option value=531f1f83098e71b3f8002466>奔驰(进口)</option><option value=531f1f78098e71b3f80021f1>本田(东风)</option><option value=531f1f79098e71b3f8002235>本田(广汽本田)</option><option value=531f1f77098e71b3f80021a4>本田(进口)</option><option value=531f1f7f098e71b3f80023b9>标致(东风)</option><option value=531f1f7b098e71b3f80022a3>标致(进口)</option><option value=531f1fc0098e71b3f8002d1a>比亚�?/option><option value=531f1fdb098e71b3f8003546>长安汽车</option><option value=531f1fdb098e71b3f8003522>长城汽车</option><option value=537eeb6b9a94e45eee0007a8>长丰汽车</option><option value=531f1f77098e71b3f80021a0>昌河</option><option value=531f1fda098e71b3f80034c8>道奇(进口)</option><option value=531f1f08098e71b3f8000e0a>大宇雪佛�?进口)</option><option value=531f1ee7098e71b3f80007f1>大众(进口)</option><option value=531f1ec9098e71b3f80000b7>东风汽车</option><option value=53df432b9a94e433790000bc>东风裕隆</option><option value=531f1ec9098e71b3f80000ae>东南汽车</option><option value=531f1fd2098e71b3f8003235>菲亚�?进口)</option><option value=531f1fd2098e71b3f800325f>菲亚�?南京)</option><option value=531f1ed2098e71b3f8000256>丰田(广汽丰田)</option><option value=531f1ecc098e71b3f8000128>丰田(进口)</option><option value=531f1ecc098e71b3f800016d>丰田(�?��)</option><option value=531f1fcf098e71b3f8003141>福特(长安)</option><option value=531f1fcd098e71b3f80030c7>福特(进口)</option><option value=536b60809a94e40e890000bf>广汽</option><option value=531f1ede098e71b3f8000621>哈飞</option><option value=531f1fca098e71b3f8002fb1>海马</option><option value=533e3cea9a94e48e0e000043>华泰现代</option><option value=531f1fc3098e71b3f8002d7b>江淮汽车</option><option value=53db2cd49a94e4c5cf000e06>江铃</option><option value=531f1edc098e71b3f8000575>吉利(中国)</option><option value=5347916d9a94e4ee160004fc>金杯</option><option value=531f1fd0098e71b3f8003193>精灵(进口)</option><option value=531f1edd098e71b3f8000593>吉普(进口)</option><option value=54265201a508a896dc0012f3>吉普(北京)</option><option value=531f1ed6098e71b3f80003fe>凯迪拉克(进口)</option><option value=531f1ed6098e71b3f8000403>凯迪拉克(上海通用)</option><option value=531f1ed5098e71b3f800037d>克莱斯勒(进口)</option><option value=531f1feb098e71b3f80037f2>雷克萨斯(进口)</option><option value=531f1fec098e71b3f8003834>雷诺(进口)</option><option value=531f1fdb098e71b3f8003505>铃木(长安)</option><option value=531f1fda098e71b3f80034fc>铃木(昌河)</option><option value=531f1fda098e71b3f80034d6>铃木(进口)</option><option value=531f1fd6098e71b3f800339f>路虎(进口)</option><option value=531f1fd0098e71b3f80031c1>罗孚(进口)</option><option value=531f1ffc098e71b3f8003b0e>马自�?长安)</option><option value=531f1ffc098e71b3f8003aef>马自�?海南)</option><option value=531f1ff1098e71b3f80039a3>马自�?进口)</option><option value=531f1ffa098e71b3f8003ab6>马自�?�?��)</option><option value=531f1ede098e71b3f80005e4>名爵(上汽)</option><option value=531f1fd9098e71b3f8003492>迷你(进口)</option><option value=531f1fbc098e71b3f8002bcf>欧宝(进口)</option><option value=531f1f09098e71b3f8000e44>奇瑞</option><option value=531f1fd5098e71b3f8003342>起亚(东风)</option><option value=531f1fd4098e71b3f80032f3>起亚(进口)</option><option value=531f1f74098e71b3f80020f4>日产(进口)</option><option value=531f1fd1098e71b3f8003206>荣威(上汽)</option><option value=531f1fd3098e71b3f8003272>萨博(进口)</option><option value=531f1ec7098e71b3f8000013>三菱(东南)</option><option value=531f1ec8098e71b3f8000020>三菱(进口)</option><option value=531f1edb098e71b3f8000517>双龙(进口)</option><option value=531f1f65098e71b3f8001ec8>斯巴�?进口)</option><option value=531f1f70098e71b3f800203e>斯柯�?上海大众)</option><option value=546765f3a508a88983000863>特斯�?/option><option value=53c08f879a94e4968c00043e>天津�?��</option><option value=531f1fc4098e71b3f8002d9c>沃尔�?长安福特)</option><option value=531f1fc4098e71b3f8002dc5>沃尔�?进口)</option><option value=531f1ed2098e71b3f8000290>五菱(上汽通用)</option><option value=531f1edf098e71b3f8000632>夏利</option><option value=531f1fca098e71b3f8002fc8>现代(进口)</option><option value=531f1fd4098e71b3f80032df>西雅�?进口)</option><option value=531f1fdc098e71b3f8003552>雪佛�?进口)</option><option value=531f1fe5098e71b3f8003719>雪铁�?东风)</option><option value=531f1fde098e71b3f80035f3>雪铁�?进口)</option><option value=531f1fd1098e71b3f80031f7>英菲尼迪(进口)</option><option value=531f1ec7098e71b3f8000001>�?��轿车</option><option value=5423b45fa508a8eaf80021f4>东风小康</option><option value=531f1ec9098e71b3f80000bb>中华(华晨)</option><option value=542e3081a508a87f5a002b8a>众泰</option>";
		int vstart = 0;
		while (true) {
			vstart = brands.indexOf('=', vstart) + 1;
			if (vstart == 0) {
				break;
			}
			int vend = brands.indexOf('>', vstart);

			int bstart = vend + 1;
			int bend = brands.indexOf('<', bstart);

			System.out.println(brands.substring(vstart, vend) + "\t"
					+ brands.substring(bstart, bend));
		}

	}

	public static void chexing() throws IOException {
		FileInputStream fis = new FileInputStream("d:\\brands.txt");
		InputStreamReader isr = new InputStreamReader(fis, "utf-8");
		BufferedReader reader = new BufferedReader(isr);
		
		String s = null;
		while ((s = reader.readLine()) != null) {
			String[] ss = StringUtils.split(s);
			//System.out.println(ss[1]);

			String getURL = GET_URL + ss[0] + ".text";

			URL getUrl = new URL(getURL);

			HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();

			connection.connect();

			BufferedReader netreader = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));

			String lines = "", line;

			while ((line = netreader.readLine()) != null) {
				lines += line;
			}

			System.out.println(ss[0] + "::" + ss[1] + "::" + lines);
			// 鏂紑杩炴帴
			connection.disconnect();
		}

		reader.close();
	}
	
	public static void modelRelease() throws IOException{
		FileInputStream fis = new FileInputStream("d:\\carmodel.txt");
		InputStreamReader isr = new InputStreamReader(fis, "utf-8");
		BufferedReader reader = new BufferedReader(isr);
		
		String s = null;
		while ((s = reader.readLine()) != null) {
			String[] ss = StringUtils.split(s, "::");	
			if (ss.length < 3) {
				System.out.println(ss[0] + "\t" + ss[1] );
				continue;
			}
			
			String styles = ss[2];
			
			int vstart = 0;
			while (true) {
				vstart = styles.indexOf('=', vstart) + 1;
				if (vstart == 0) {
					break;
				}
				int vend = styles.indexOf('>', vstart);

				int bstart = vend + 1;
				int bend = styles.indexOf('<', bstart);
				
				System.out.println(ss[0] + "\t" + ss[1] + "\t" + styles.substring(vstart, vend) + "\t" + styles.substring(bstart, bend));
			}
		}
		
		reader.close();
	}
	
	public static void styleQuery() throws MalformedURLException, IOException{
		FileInputStream fis = new FileInputStream("d:\\model.txt");
		InputStreamReader isr = new InputStreamReader(fis, "utf-8");
		BufferedReader reader = new BufferedReader(isr);
		
		String s = null;
		while ((s = reader.readLine()) != null) {
			String[] ss = StringUtils.split(s);
			if (ss.length < 4) {
				String temp = "";
				for (int i = 0; i < ss.length; i++) {
					temp += (ss[i] + "::");					
				}
				System.out.println(temp);
				continue;
			}

			String getURL = MODLE_OPTIONS_URL + ss[2] + ".text";

			URL getUrl = new URL(getURL);

			HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();

			connection.connect();

			BufferedReader netreader = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));

			String lines = "", line;

			while ((line = netreader.readLine()) != null) {
				lines += line;
			}

			System.out.println(ss[0] + "::" + ss[1] + "::" + ss[2] + "::" + ss[3] + "::" + lines);
			// 鏂紑杩炴帴
			connection.disconnect();
		}

		reader.close();
	}
	
	public static void styleRelease() throws IOException{
		FileInputStream fis = new FileInputStream("d:\\styleNoHandle.txt");
		InputStreamReader isr = new InputStreamReader(fis, "utf-8");
		BufferedReader reader = new BufferedReader(isr);
		
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("d:\\style_new.txt"), "utf-8"));
		
		String s = null;
		while ((s = reader.readLine()) != null) {
			String[] ss = StringUtils.split(s, "::");
			if (ss.length < 5) {
				String temp = "";
				for (int i = 0; i < ss.length; i++) {
					temp += (ss[i] + ":\t");					
				}
				System.out.println(temp);
				writer.append(temp);
				writer.newLine();
				continue;
			}
			
            String styles = ss[4];
			
			int vstart = 0;
			while (true) {
				vstart = styles.indexOf('=', vstart) + 1;
				if (vstart == 0) {
					break;
				}
				int vend = styles.indexOf('>', vstart);

				int bstart = vend + 1;
				int bend = styles.indexOf('<', bstart);
				
				System.out.println(ss[0] + ":\t" + ss[1] + ":\t" + ss[2] + ":\t" + ss[3] + ":\t" + styles.substring(vstart, vend) + ":\t" + styles.substring(bstart, bend));
				writer.append(ss[0] + ":\t" + ss[1] + ":\t" + ss[2] + ":\t" + ss[3] + ":\t" + styles.substring(vstart, vend) + ":\t" + styles.substring(bstart, bend));
				writer.newLine();
			}
		}
		writer.flush();
		writer.close();
		reader.close();
	}

	public static void test() throws IOException{
		String getURL = PRICE_URL;

		URL getUrl = new URL(getURL);

		HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();

		connection.connect();

		BufferedReader netreader = new BufferedReader(new InputStreamReader(
				connection.getInputStream()));

		String lines = "", line;

		while ((line = netreader.readLine()) != null) {
			lines += line;
		}

		System.out.println( lines);
		// 鏂紑杩炴帴
		connection.disconnect();
	}
	
	public static void price() throws  ParserException, IOException{
		String[] items = new String[]{"jiyou", "jilv", "kongqi", "kongtiao"};		

		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("d:\\style_new.txt"), "utf-8"));		
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("d:\\products_name"), "utf-8"));
		
		String brand, number, spec, price, quantity, name;
		
		String s = null;
		while ((s = reader.readLine()) != null) {
			String[] ss = StringUtils.split(s, ":\t");
			if (ss.length < 6) {				
				continue;
			}
			
			String carId = ss[4];			
			try {
				Document doc = Jsoup.connect(PRICE_URL + carId  + "&commit=%E6%9F%A5%E8%AF%A2").get();
				Elements elements = doc.getElementsByAttributeValue("role", "menu");
				for (int i = 0; i < elements.size(); i++) {
					Element element = elements.get(i);
					Elements as = element.getElementsByAttribute("data-brand");
					for (Element a : as) {
						brand = a.attr("data-brand");
						number = a.attr("data-number");
						spec = a.attr("data-spec");
						price = a.attr("data-price");
						quantity = a.attr("data-quantity");
						name = a.text();
						System.out.println(items[i] + "::" + brand + "::" + number + "::" + price + "::" + quantity + "::" + spec);
						writer.append(carId + "::" + items[i] + "::" + brand + "::" + number + "::" + price + "::" + quantity + "::" + name + "::" + spec);
						writer.newLine();
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}				
		reader.close();
		writer.flush();
		writer.close();
	}
	
	public static void main(String[] args) throws 
			IOException, ParserException {

		//chexing();
		//styleRelease();
		//styleQuery();
		//test();
		//styleRelease();
		price();
	}

}
