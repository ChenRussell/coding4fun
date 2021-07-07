package org.cr.juc.example.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * created by chenrui18,2018/8/27 at 16:57
 */
public class ThreadPoolExecutorTest {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService threadPool = Executors.newFixedThreadPool(1);
        threadPool.execute(() -> {
            while (true) {
                System.out.println("hello jd");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        while (true) {
            System.out.println("hello cr");
            Thread.sleep(1000);
        }
    }
}
