package com.nowcoder.designPattern.SingletonPattern;

/**
 * created by chenrui18,2018/8/16 at 14:38
 */
public class SingletonStaticClass {

    private SingletonStaticClass singleton;

    private SingletonStaticClass() {
    }

    static class InnerSingleton {
        public static final SingletonStaticClass SINGLETON_INSTANCE = new SingletonStaticClass();
    }

    public SingletonStaticClass getSingleton(){
        return InnerSingleton.SINGLETON_INSTANCE;
    }
}
