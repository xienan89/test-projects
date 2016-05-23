/**
 * 
 */
package com.xienan;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author nan.xie
 * @date 2014-5-27 上午9:27:46
 */
public class Mytest {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException, ParseException,
			InterruptedException, SecurityException, NoSuchFieldException {

		/*if (Object.class.isAssignableFrom(ArrayList.class)) {
			System.out.println("yes-----------------------------");
		}	*/
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(12, "12");
		map.put(23, "23");
		System.out.println(map.get(23));
	}
	
	private static class Model{
		List<Set<String>> listlist;
		List<Integer> listint;
		public List<Set<String>> getListlist() {
			return listlist;
		}
		public void setListlist(List<Set<String>> listlist) {
			this.listlist = listlist;
		}			
	}
	
	//private static void intf(int i){System.out.println("im int i " + i);}
	private static void intf(Integer i){System.out.println("im integer i " + i);}
}
