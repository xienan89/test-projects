package com.xienan.signal;
import sun.misc.Signal;
import sun.misc.SignalHandler;
/**
 * @author nan.xie
 * @date 2014-8-18 上午11:52:29
 */
public class CatchKillSignal implements SignalHandler{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Signal.handle(new Signal("USR2"), new CatchKillSignal());		
		for (;;) {
			try {
				Thread.sleep(3000);
				System.out.println("im running...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void handle(Signal sig) {
		System.out.println("catch a singal: " + sig.getName() + " num:" + sig.getNumber());
		
	}

}
