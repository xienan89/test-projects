package cn.ebaoyang.crawler.JD;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.lang.StringUtils;

public class DownPic {
	public static void downLoad(String fileName, String url) throws IOException{
		File file = new File(fileName);
		if (!file.getParentFile().exists()) {
			if (!file.getParentFile().mkdir()) {
				System.out.println("mkdir error! " + fileName);
			}
		}
		if (!file.exists()) {
			file.createNewFile();
		}	

		URL getUrl = new URL(url);
		HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
		connection.connect();
		
		BufferedInputStream in = new BufferedInputStream(connection.getInputStream());		

		// 生成图片
		BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file));
		byte[] buf = new byte[2048];
		int length = in.read(buf);
		while (length != -1) {
			out.write(buf, 0, length);
			length = in.read(buf);
		}
		in.close();
		out.close();
	}
	
	public static void downHangstPics(String inputFileName, String outputPath) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFileName)));
		String s = null;
		while ((s=reader.readLine())!=null) {
			String[] ss = StringUtils.split(s);
			downLoad(outputPath+ss[1]+".jpg", ss[0]);
		}
		reader.close();
	}
	
	public static void downMahlePics(String inputFileName, String outputPath) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFileName)));
		String s = null;
		int i = 1;
		while ((s=reader.readLine())!=null) {
			try {
				String[] ss = StringUtils.split(s);
				String path = ss[1];
				/*if (ss.length == 2) {
					continue;// 之前已经正确处理 ， 跑完后去掉 TODO
				}*/
				
				if (ss.length > 2) {
					for (int j = 2; j < ss.length; j++) {
						path += ss[j];
					}
				}
				if (!path.contains("/")) {
					continue;// 之前已经正确处理 ， 跑完后去掉 TODO
				}
				path = path.replaceAll("/", "_");
				downLoad(outputPath+path+"\\"+(i++)+".jpg", ss[0]);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		reader.close();
	}
	

	public static void main(String[] args) throws IOException {
		String outpath = "d://jd/hangst_kongqi_pics/";
		//downHangstPics("d://jd/hangst_kongqi_pic.txt", outpath);
		downMahlePics("d://jd/mahle_jilv_pic.txt", "d:\\jd\\mahle_jilv_pics\\");
		//downMahlePics("d://jd/mahle_kongqi_pic.txt", "d:\\jd\\mahle_kongqi_pics\\");
	}

}
