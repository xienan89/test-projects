/**
 * 
 */
package com.xienan.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author nan.xie
 * @date 2014-6-20 下午2:33:13
 */
public class SimpleDemo1 {


	public static void main(String[] args) throws IOException {
		byte[] message = new byte[]{3,5,'s'};
		
		FileInputStream fin = new FileInputStream("D://tree.txt");
		FileChannel fc = fin.getChannel();
		
		ByteBuffer byteBuffer =  ByteBuffer.allocate(1024);
		int size = fc.read(byteBuffer);
		System.out.println(size);
		System.out.println(new String(byteBuffer.array()));
		
		byteBuffer.flip();
		size =  fc.read(byteBuffer);
		//System.out.println(size);
		//System.out.println(byteBuffer.remaining());
		int position = byteBuffer.position();
		System.out.println(new String(byteBuffer.array(), 0, position));
		
		//byteBuffer.flip();
		
/*		for (int i = 0; i < message.length; i++) {
			byteBuffer.put(message[i]);
		}

		
		fc.write(byteBuffer);*/
		fin.close();
	}

}
