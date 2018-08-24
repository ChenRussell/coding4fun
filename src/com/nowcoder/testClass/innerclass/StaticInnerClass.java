package com.nowcoder.testClass.innerclass;

/**
 * 静态内部类
 */
public class StaticInnerClass {
    int a = 10;
    static int b = 5;

    static class Inner {
        public Inner() {
//            System.out.println(a);    不能使用外部类的非static成员变量或方法
            System.out.println(b);
        }
    }

    public static void main(String[] args) {
        new StaticInnerClass.Inner();
    }
}
