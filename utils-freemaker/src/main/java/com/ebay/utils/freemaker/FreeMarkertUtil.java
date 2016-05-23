package com.ebay.utils.freemaker;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

import org.apache.commons.io.output.ByteArrayOutputStream;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * freemarker 妯℃澘宸ュ叿
 * 
 * @author Ying-er
 * @time 2010-2-6涓嬪崍04:07:27
 * @version 1.0
 */
public class FreeMarkertUtil {

	/**
	 * 杩斿洖妯℃澘鍐呭
	 * 
	 * @param templateName
	 *            妯℃澘鏂囦欢鍚嶇О
	 * @param templateEncoding
	 *            妯℃澘鏂囦欢鐨勭紪鐮佹柟寮�
	 * @param root
	 *            鏁版嵁妯″瀷鏍瑰璞�濡傛灉妯℃澘涓病鏈夊�鍦╩ap涓紝鍒欐姏鍑哄紓甯�
	 */
	public static String getTemplate(String templateName,
			String templateEncoding, Map<?, ?> root) {
		try {
			/**
			 * 鍒涘缓Configuration瀵硅薄
			 */
			Configuration config = new Configuration();
			/**
			 * 鎸囧畾妯℃澘璺緞
			 */
			File file = new File("D:\\workspace\\ebay-utils-freemaker");
			/**
			 * 璁剧疆瑕佽В鏋愮殑妯℃澘鎵�湪鐨勭洰褰曪紝骞跺姞杞芥ā鏉挎枃浠�
			 */
			config.setDirectoryForTemplateLoading(file);
			/**
			 * 璁剧疆鍖呰鍣紝骞跺皢瀵硅薄鍖呰涓烘暟鎹ā鍨�
			 */
			config.setObjectWrapper(new DefaultObjectWrapper());

			/**
			 * 鑾峰彇妯℃澘,骞惰缃紪鐮佹柟寮忥紝杩欎釜缂栫爜蹇呴』瑕佷笌椤甸潰涓殑缂栫爜鏍煎紡涓�嚧
			 */
			Template template = config.getTemplate(templateName,
					templateEncoding);
			/**
			 * 鍚堝苟鏁版嵁妯″瀷涓庢ā鏉�
			 */
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			Writer out = new OutputStreamWriter(bout);
			template.process(root, out);
			out.flush();
			out.close();

			return bout.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
		return null;
	}
}
