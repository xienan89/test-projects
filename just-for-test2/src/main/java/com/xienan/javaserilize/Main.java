package com.xienan.javaserilize;

import java.io.*;

/**
 * @author nan.xie
 * @date 2014-6-24 下午5:57:00
 */
public class Main {
	private static String infilename = "D://object";
	private static String outfile = "D://object";

	/**
	 * @param args
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		writeObject();
		Serilizabled object = (Serilizabled) getModelFromBytes(new byte[0]);
		
		System.out.println(object.getNoserizable().name);
		System.out.println(object.getNoserizable().map.get(123));
	}
	
	public static Object getModelFromBytes(byte[] bytes) throws IOException, ClassNotFoundException{
		FileInputStream fileInputStream = new FileInputStream(infilename);
		
		//ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
		ObjectInputStream ois = new ObjectInputStream(fileInputStream);
		
		Object object = ois.readObject();
		return object;
	}
	
	public static void writeObject() throws IOException{
		Serilizabled serilizabled = new Serilizabled();
		serilizabled.setNoserizable(new Noserizable());
		
		FileOutputStream fileOutputStream = new FileOutputStream(outfile);
		//ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
		
		oos.writeObject(serilizabled);		

		oos.close();
		fileOutputStream.close();
		//bos.close();
		
		/*BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outfile)));
		
		bWriter.append(new String(bos.toByteArray(), "utf-8"));
		bWriter.flush();
		
		bWriter.close();*/
		
		//return bos.toByteArray();
	}

}
