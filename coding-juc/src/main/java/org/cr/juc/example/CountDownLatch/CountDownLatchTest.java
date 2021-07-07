package org.cr.juc.example.CountDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * created by chenrui18,2018/8/28 at 9:56
 */
public class CountDownLatchTest {

    static CountDownLatch c = new CountDownLatch(3);

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                c.countDown();
                System.out.println(2);
                c.countDown();
            }
        }).start();
        c.await();
        System.out.println(3);
    }
}
