package com.renren.xienan.exceptions;

import org.junit.Test;

/**
 * Created by Administrator on 2016/1/3.
 */
public class ExceptionTest {

    @Test
    public void finallyTest(){
        try {
            System.out.println("try");
            int i = 1/0;
        } catch (Exception e) {
            System.out.println("catch");
        } finally {
            System.out.println("finally");
        }
    }

    @Test
    public void catch1(){
        try {
            System.out.println("try");
            int i = 1/0;
        }catch (ArithmeticException e){
            System.out.println("catch arithmetic exception");
        }catch (Exception e) {
            System.out.println("catch exception");
        } finally {
            System.out.println("finally");
        }
    }

    @Test
         public void catch2(){
        try {
            int i = 1/0;
        }catch (Exception e) {
            System.out.println("catch exception");
            return;
        } finally {
            System.out.println("finally");
        }
    }

    @Test
    public void returnTest(){
        System.out.println(return1());
    }

    public int return1(){
        int i = 1;
        try {
            i = 2/0;
            return i;
        }catch (Exception e) {
            System.out.println("i in catch is " + i);
            i = 3;
            return i;
        } finally {
            System.out.println("i in finally is " + i);
            i = 4;
            return i;
        }
    }
}
