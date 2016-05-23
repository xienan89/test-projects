package cn.ebaoyang.crawler.sina;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class PareseChexiJson {
	public static void parse() throws IOException{
		FileInputStream fis = new FileInputStream("d:\\sina.txt");
		InputStreamReader isr = new InputStreamReader(fis, "gbk");
		BufferedReader reader = new BufferedReader(isr);
		
		StringBuilder sb = new StringBuilder(10000);
		String s = null;
		while ((s = reader.readLine()) != null) {			
			sb.append(s);
		}
		reader.close();
		String ret = sb.toString();
		JSONObject json = JSONObject.fromObject(ret);
		JSONObject tree = json.optJSONObject("result").optJSONObject("data").optJSONObject("tree");	
		for (char c = 'A'; c <= 'Z'; c++) {
			JSONObject charJson = tree.optJSONObject(new String(new char[]{c}));
			if (charJson != null) {
				List<JSONObject> charBrands = new ArrayList<JSONObject>(charJson.values());
				for (JSONObject jsonObject : charBrands) {
					//System.out.println(jsonObject.optString("cname"));//字母下面的品牌 ：奥迪（下面包含具体的品牌）
					List<JSONObject> brandList = new ArrayList<JSONObject>(jsonObject.optJSONObject("brand_list").values());
					for (JSONObject brand : brandList) {
						String brandString = brand.optString("cname");//具体的品牌：一汽奥迪
						JSONArray subList = brand.optJSONArray("sub_list");
						for (int i = 0; i < subList.size(); i++) {
							JSONObject sub = subList.getJSONObject(i);
							System.out.println(brandString + "|" + sub.optString("cname") + "|" + sub.optString("subid"));
						}						
					}					
				}
				
			}			
		}
	}
	
	public static void main(String[] args) throws IOException {
		parse();
	}

}
