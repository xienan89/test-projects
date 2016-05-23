package com.xienan.wsdl;

import javax.xml.ws.Endpoint;

/**
 * @author nan.xie
 * @date 2014-8-20 上午11:15:45
 */
public class WSDLGenerate {

	public static void main(String[] args) {
		 System.out.println("web service start");
         HelloWorldImpl implementor= new HelloWorldImpl();
         String address="http://localhost:8080/helloWorld";
         Endpoint.publish(address, implementor);
         System.out.println("web service started");
	}

}
