package com.nowcoder.jvm.chapter13;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by ChenRui on 18-3-23
 *
 * Atomic 变量自增运算测试
 */
public class AtomicTest {

    public static AtomicInteger race = new AtomicInteger(0);

    public static void increase() {
        race.incrementAndGet();
    }

    private static final int THREAD_COUNT = 20;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }

//        while (Thread.activeCount() > 1)
//            Thread.yield();

        System.out.println(race);     // 结果并不等于200000？？？？
    }
}
