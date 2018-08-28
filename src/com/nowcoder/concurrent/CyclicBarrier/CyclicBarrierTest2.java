package com.nowcoder.concurrent.CyclicBarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * created by chenrui18,2018/8/28 at 11:46
 */
public class CyclicBarrierTest2 {

    static CyclicBarrier c =  new CyclicBarrier(2, new A());

    public static void main(String[] args) {
        new Thread(() -> {
                try {
                    c.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            System.out.println(11);
        }).start();

        try {
            c.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(12);
    }

    static class A implements Runnable {

        @Override
        public void run() {
            System.out.println(13);
        }
    }
}
