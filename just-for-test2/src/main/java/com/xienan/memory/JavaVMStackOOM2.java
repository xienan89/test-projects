package com.xienan.memory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * VM Args：-Xss1K （这时候不妨设小些）
 * @author nan.xie
 * @date 2014-9-19 上午11:27:39
 */
public class JavaVMStackOOM2 {

	private void dontStop() {
		Log log = LogFactory.getLog(JavaVMStackOOM2.class);
		int a = 1;
		int b= 2;
		int c = 3;
		int d = 4;
		log.debug(a + b + c + d);
		dontStop();
	}

   public void stackLeakByThread() {         
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				dontStop();
			}
		});
		thread.start();
      
   }

	public static void main(String[] args) {
		JavaVMStackOOM2 javaVMStackOOM2 = new JavaVMStackOOM2();
		javaVMStackOOM2.stackLeakByThread();

	}
}
