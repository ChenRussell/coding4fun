package com.nowcoder.concurrent.ThreadPool;

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

        System.out.println(future.get());   // 子线程执行完之后才会返回，否则将一直阻塞

        while (true) {
            System.out.println("hello world");
            Thread.sleep(1000);
        }
    }
}
