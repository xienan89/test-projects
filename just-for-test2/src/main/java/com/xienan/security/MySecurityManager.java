package com.xienan.security;
import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.IOException;  
  
public class MySecurityManager extends SecurityManager {  
  
  
    @Override  
    public void checkRead(String file) {  
        if (file.endsWith("Security.txt"))  
            throw new SecurityException("这个你是没有权限读滴...");  
    }  
  
    /** 
     * 
     * @param args 
     * @return void 
     */  
    public static void main(String[] args) {  
        //设置安全管理器  
        System.setSecurityManager(new MySecurityManager());  
        try {  
//            new FileOutputStream("Security.txt");  
            FileInputStream fis = new FileInputStream("Security.txt");  
            System.out.println(fis.read());  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
  
}  