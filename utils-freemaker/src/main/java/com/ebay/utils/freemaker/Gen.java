package com.ebay.utils.freemaker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Gen {
	public static final String SPTJ = "#";
	public static final String packageName = "com.ebaoyang";
	public static final String modelName = "examTemplate";
	public static final String tableName = "eby_exam_template";
	public static final String[] fields_arr = new String[] {
			"category_id",
			"question_level",
			"count",
			"score"
	};

	public static void main(String[] args) throws IOException {
		String ModelName = Character.toUpperCase(modelName.charAt(0)) + modelName.substring(1);// 棣栧瓧姣嶅ぇ鍐�
		List<Bean> fieds = new ArrayList<Bean>();
		for (int i = 0; i < fields_arr.length; i++) {
			fieds.add(new Bean(fields_arr[i], field_solve(fields_arr[i])));
		}
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("packageName", packageName);
		root.put("ModelName", ModelName);
		root.put("modelName", modelName);
		root.put("fieds", fieds);
		root.put("tableName", tableName);
		root.put("SPTJ", SPTJ);

		String res;
		res = FreeMarkertUtil.getTemplate("template.ftl", "utf-8", root);
		System.out.println(res);

		res = FreeMarkertUtil.getTemplate("dao.ftl", "utf-8", root);
		System.out.println(res);
		
		res = FreeMarkertUtil.getTemplate("service.ftl", "utf-8", root);
		System.out.println(res);

		res = FreeMarkertUtil.getTemplate("model.ftl", "utf-8", root);
		System.out.println(res);
	}

	public static String field_solve(String string) {
		StringBuilder sb = new StringBuilder();
		boolean change = false;
		for (int i = 0; i < string.length(); i++) {
			char ch = string.charAt(i);
			if (ch == '_') {
				change = true;
				continue;
			}
			if (change) {
				sb.append(Character.toUpperCase(ch));
				change = false;
			} else {
				sb.append(ch);
			}
		}
		return sb.toString();
	}
}
