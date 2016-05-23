package com.renren.xienan.methoddispatch;

import org.junit.Test;

/**
 * Created by xienan on 2015/12/30.
 */
public class MethodDispatchTest {

    @Test
    public void overload(){
        Human human = new Human();
        Human man = new Man();
        Man realMan = new Man();

        sayHello(human);
        sayHello(man);
        sayHello(realMan);
    }

    @Test
    public void dynamicDispatch(){
        Human man = new Man();
        Human human = new Human();
        Man realMan = new Man();

        human.sayHello();
        man.sayHello();
        realMan.sayHello();
    }

    @Test
    public void multiDispatch(){
        Fruit fruit = new Fruit();
        Fruit apple = new Apple();
        Apple realApple = new Apple();

        Human man = new Man();
        Human human = new Human();
        Man realMan = new Man();

        man.eat(fruit);
        man.eat(apple);
        man.eat(realApple);

        human.eat(fruit);
        human.eat(apple);
        human.eat(realApple);

        realMan.eat(fruit);
        realMan.eat(apple);
        realMan.eat(realApple);
    }

    public void sayHello(Human human){
        System.out.println("human say hello!");
    }
    /*public void sayHello(Man man){
        System.out.println("man say hello.");
    }*/

    private static class Human{
        public void sayHello(){
            System.out.println("say hello in human");
        }

        public void eat(Fruit fruit){
            System.out.println("human eat fruit.");
        }
        public void eat(Apple apple){
            System.out.println("human eat apple.");
        }
    }

    private static class Man extends Human{
        public void sayHello(){
            System.out.println("say hello in man");
        }

        public void eat(Fruit fruit) {
            System.out.println("man eat fruit.");
        }

        public void eat(Apple apple) {
            System.out.println("man eat apple.");
        }
    }

    private static class Fruit{}
    private static class Apple extends Fruit{}
}
