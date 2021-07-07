package org.cr.juc.example.CountDownLatch;

/**
 * created by chenrui18,2018/8/27 at 20:34
 */
public class JoinCountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {

        Thread parser1 = new Thread(() -> {
            System.out.println("fuck you");
        });

        Thread parser2 = new Thread(() -> {
            System.out.println("parser2 finish");
        });

        parser1.start();
        parser2.start();
//        Thread.sleep(1000);
        parser1.join();
        parser2.join();
        System.out.println("all parser finish");
    }
}
