/**
 * 
 */
package com.xienan.nio;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author nan.xie
 * @date 2014-7-7 下午3:55:45
 */
public class Client {

	public static void main(String[] args) throws UnknownHostException,
	
			IOException {
		// 建立到服务端的链接
		SocketAddress address = new InetSocketAddress("127.0.0.1", 51641);
		SocketChannel client = SocketChannel.open(address);
		// 创建静态的缓冲区
		ByteBuffer buffer = ByteBuffer.allocate(255);
		
		buffer.clear();
		buffer.put("Im client!\r\n".getBytes());
		buffer.flip();
		client.write(buffer);

		buffer.clear();
		// 读取数据,到buffer中
		client.read(buffer);
		// 将position重新置为0
		buffer.flip();
		// 输出缓冲区的数据

		String ret = new String(buffer.array());
		System.out.println(ret);

		client.close();

		System.out.println("done");
	}

}
