package com.nowcoder.testClass;

/**
 * Created by ChenRui on 2018/4/9
 * <p>
 * 所谓静态，就是在运行时，虚拟机已经认定此方法属于哪个类。
 * <p>
 * 专业术语有严格的含义,用语要准确."重写"只能适用于实例方法.
 * 不能用于静态方法.对于静态方法,只能隐藏(刚才的例子可以重写那只是形式上的 ，并不满足多态的特征，所以严格说不是重写)。
 * <p>
 * 静态方法的调用不需要实例化吧..  不实例化也就不能用多态了，也就没有所谓的父类引用指向子类实例.因为不能实例化
 * 也就没有机会去指向子类的实例。所以也就不存在多态了。
 */
class Base1 {
    static void a() {
        System.out.println("A");
    }

    void b() {
        System.out.println("B");
    }
}

public class TestStaticOverwrite extends Base1 {
    static void a() {
        System.out.println("C");
    }

    void b() {
        System.out.println("D");
    }

    public static void main(String args[]) {
        Base1 b = new Base1();
        Base1 c = new TestStaticOverwrite();
        b.a();
        b.b();
        c.a();  // 打印A，不是C， 谁申明的调用谁
        c.b();
    }
}