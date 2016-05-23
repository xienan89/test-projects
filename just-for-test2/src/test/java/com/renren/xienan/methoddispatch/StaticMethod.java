package com.renren.xienan.methoddispatch;

import org.junit.Test;

/**
 * Created by xienan on 2015/12/30.
 */
public class StaticMethod {
    private static class Human{
        public static void sayHello(){
            System.out.println("human say hello.");
        }
    }

    private static class Man extends Human{
        public static void sayHello(){
            System.out.println("man say hello");
        }
        //public void sayHello(){}
    }

    @Test
    public void callMethod(){
        Human.sayHello();
        Man.sayHello();

        Human human = new Human();
        Human man = new Human();
        Man realMan = new Man();

        human.sayHello();
        man.sayHello();
        realMan.sayHello();
    }
}
