package org.cr.juc.example.ThreadPool;

import java.util.concurrent.*;

/**
 * created by chenrui18,2018/8/27 at 18:17
 */
public class CallableTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService t = Executors.newFixedThreadPool(1);
        Future<Object> future = t.submit(() -> {
            int count = 100;
            while (count-- > 0) {
                System.out.println("fuck you");
                Thread.sleep(100);
            }
            return "fuck";
        });

        System.out.println(future.get());   // ���߳�ִ����֮��Ż᷵�أ�����һֱ����

        while (true) {
            System.out.println("hello world");
            Thread.sleep(1000);
        }
    }
}
