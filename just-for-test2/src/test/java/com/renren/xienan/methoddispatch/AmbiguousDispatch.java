package com.renren.xienan.methoddispatch;

import org.junit.Test;

/**
 * Created by xienan on 2015/12/30.
 */
public class AmbiguousDispatch {

    private interface Eater{}
    private interface Drinker{}

    //同时继承子类和实现接口是一样的，也会报错
    private class Human implements Eater,Drinker{}
    public void serve(Eater eater){}
    public void serve(Drinker drinker){}

    @Test
    public void ambiguous(){
        Human human = new Human();
        //serve(human);
    }
}
