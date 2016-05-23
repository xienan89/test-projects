package com.xienan;
public class ThreadA {    
	public static void main(String[] args) throws InterruptedException{        
		ThreadB b = new ThreadB();        
		//b.start();
		//Thread.sleep(1000);
		synchronized(b){            
			try{                
				System.out.println("Waiting for b to complete..." + System.currentTimeMillis());
				b.wait();
				System.out.println("Waiting over..." + System.currentTimeMillis());
			}catch(InterruptedException e){        
				e.printStackTrace();          
			}            
			System.out.println("Total is: " + b.total);    
		}  
	}
} 
class ThreadB extends Thread{    
	int total;    
	@Override    
	public void run(){        
		synchronized(this){ 
			System.out.println("Thread B begin");
			for(int i=0; i<=100 ; i++){                
			total += i;            
			} 
			System.out.println("Thread B notify");
			notify();        
		}    
	}
}
