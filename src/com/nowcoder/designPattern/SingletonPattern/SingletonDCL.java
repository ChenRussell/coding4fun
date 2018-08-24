package com.nowcoder.designPattern.SingletonPattern;

/**
 * created by chenrui18,2018/8/16 at 14:28
 */
public class SingletonDCL {

    private volatile static SingletonDCL singleton;

    private SingletonDCL() {
    }

    public static SingletonDCL getSingleton() {
        if (singleton == null){
            synchronized (SingletonDCL.class){
                if (singleton == null) {
                    singleton = new SingletonDCL();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        SingletonDCL singleton1 = SingletonDCL.getSingleton();
        SingletonDCL singleton2 = SingletonDCL.getSingleton();
        SingletonDCL singleton3 = new SingletonDCL();
        System.out.println(singleton1 == singleton2);
        System.out.println(singleton1 == singleton3);
        System.out.println(singleton1);
    }
}

class AnotherClass {
    public static void main(String[] args) {
        System.out.println(SingletonDCL.getSingleton());
    }
}
