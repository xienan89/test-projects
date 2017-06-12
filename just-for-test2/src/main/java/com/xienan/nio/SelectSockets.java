package com.xienan.nio;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class SelectSockets {
	public static int PORT_NUMBER = 51641;

	public static void main(String[] argv) throws Exception {
		new SelectSockets().go(argv);
	}

	public void go(String[] argv) throws Exception {
		int port = PORT_NUMBER;
		System.out.println("Listening on port " + port);

		// Allocate an unbound server socket channel
		ServerSocketChannel serverChannel = ServerSocketChannel.open();
		ServerSocket serverSocket = serverChannel.socket();
		serverSocket.bind(new InetSocketAddress(port));
		
		// Create a new Selector for use below
		Selector selector = Selector.open();

		// Set nonblocking mode for the listening socket
		serverChannel.configureBlocking(false);

		// Register the ServerSocketChannel with the Selector
		serverChannel.register(selector, SelectionKey.OP_ACCEPT);
		while (true) {
			// This may block for a long time. Upon returning, the
			// selected set contains keys of the ready channels.
			int n = selector.select();
			if (n == 0) {
				continue; // nothing to do
			}
			// Get an iterator over the set of selected keys
			Iterator<SelectionKey> it = selector.selectedKeys().iterator();
			// Look at each key in the selected set
			while (it.hasNext()) {
				SelectionKey key = it.next();
				// Is a new connection coming in?
				System.out.println("valid: " + key.isValid() + ", interestOps: " + key.interestOps());
				if (key.isAcceptable()) {
					ServerSocketChannel server = (ServerSocketChannel) key
							.channel();
					SocketChannel channel = server.accept();
					registerChannel(selector, channel, SelectionKey.OP_READ);

					sayHello(channel);
				}
				// Is there data to read on this channel?
				if (key.isReadable()) {
					readDataFromSocket(key);
				}

				// Remove key from selected set; it's been handled
				it.remove();
			}
		}
	}

	// ----------------------------------------------------------

	/**
	 * Register the given channel with the given selector for the given
	 * operations of interes t
	 */
	protected void registerChannel(Selector selector,
			SelectableChannel channel, int ops) throws Exception {
		if (channel == null) {
			return; // could happen
		}

		// Set the new channel nonblocking
		channel.configureBlocking(false);

		// Register it with the selector
		channel.register(selector, ops);
	}

	// ----------------------------------------------------------
	// Use the same byte buffer for all channels. CompareWithDifferentClassLoader single thread is
	// servicing all the channels, so no danger of concurrent acccess.
	private ByteBuffer buffer = ByteBuffer.allocate(1024);

	/**
	 * Sample data handler method for a channel with data ready to read.
	 */
	protected void readDataFromSocket(SelectionKey key) throws Exception {
		SocketChannel socketChannel = (SocketChannel) key.channel();
		int count;
		buffer.clear(); // Empty buffer
		// Loop while data is available; channel is nonblocki ng
		while ((count = socketChannel.read(buffer)) > 0) {
			buffer.flip(); // Make buffer readable
			if (buffer.hasArray()) {
				System.out.println(new String(buffer.array()));
			}else {
				System.out.println("buffer no array!");
			}

			// Send the data; don't assume it goes all at once
			while (buffer.hasRemaining()) {
				socketChannel.write(buffer);				
			}
			// you'd do something more useful than this.
			buffer.clear(); // Empty buffer
		}
		if (count < 0) {
			// Close channel on EOF, invalidates the key
			socketChannel.close();
		}
        //继续读,  channel在读取失败关闭时会报错
        registerChannel(key.selector(), key.channel(), SelectionKey.OP_READ);
		//System.out.println(new String(buffer.array()));
	} // ----------------------------------------------------------

	/**
	 * Spew a greeting to the incoming client connection.
	 * The newly connected SocketChannel to say hello to.
	 */
	private void sayHello(SocketChannel channel) throws Exception {
		buffer.clear();
		buffer.put("Im server!\r\n".getBytes());
		buffer.flip();
		channel.write(buffer);
	}
}
