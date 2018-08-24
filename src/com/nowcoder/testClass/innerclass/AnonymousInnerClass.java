package com.nowcoder.testClass.innerclass;

/**
 * 匿名内部类
 */
public class AnonymousInnerClass {

    public void test(){
        int afinal = 23;

        for (int i = 0; i < 6; i++) {

            Runnable runnable = new Runnable() {     // 匿名内部类
                @Override
                public void run() {
                    System.out.println("this is a anonymous class!" + afinal);   // 没定义成final类型不报错?????
                }
            };
        }
    }

    public static void main(String[] args) {
        int afinal = 23;

        /**
         * 这里所说的“匿名内部类”主要是指在其外部类的成员方法内定义的同时完成实例化的类，若其访问该成员方法中的局部变量，
         * 局部变量必须要被final修饰。原因是编译器实现上的困难：内部类对象的生命周期很有可能会超过局部变量的生命周期。
         *
         * 解决方法：匿名内部类对象可以访问同一个方法中被定义为final类型的局部变量。定义为final后，
         * 编译器会把匿名内部类对象要访问的所有final类型局部变量，都拷贝一份作为该对象的成员变量。
         * 这样，即使栈中局部变量已经死亡，
         * 匿名内部类对象照样可以拿到该局部变量的值，因为它自己拷贝了一份，
         * 且与原局部变量的值始终保持一致（final类型不可变）
         * COPY LOCAL VARIABLE
         */
        for (int i = 0; i < 6; i++) {

            Runnable runnable = new Runnable() {     // 匿名内部类
                @Override
                public void run() {
                    System.out.println("this is a anonymous class!" + afinal);   // 没定义成final类型不报错?????
                }
            };
        }

//        runnable.run();
//        new Thread(() -> System.out.println("this is another anonymous class!")).start();
    }
}
