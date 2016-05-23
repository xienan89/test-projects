package com.xienan.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args锛�XX:PermSize=10M -XX:MaxPermSize=10M
 * @author zzm
 */
public class RuntimeConstantPoolOOM {

	public static void main(String[] args) {
		// 浣跨敤List淇濇寔鐫�父閲忔睜寮曠敤锛岄伩鍏岶ull GC鍥炴敹甯搁噺姹犺涓�		
		List<String> list = new ArrayList<String>();
		// 10MB鐨凱ermSize鍦╥nteger鑼冨洿鍐呰冻澶熶骇鐢烵OM浜�		
		int i = 0; 
		while (true) {
			list.add(String.valueOf(i++).intern());
		}
	}
}

