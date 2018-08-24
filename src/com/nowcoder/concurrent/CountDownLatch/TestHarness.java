package com.nowcoder.concurrent.CountDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by ChenRui on 18-3-11
 *
 * 在计时测试中使用CountDownLatch来启动和停止线程（闭锁）
 */
public class TestHarness {

    int nThreads;
    Runnable task;

    public TestHarness(int nThreads, Runnable task) {
        this.nThreads = nThreads;
        this.task = task;
    }

    public long timeTask() {
        // 起始门
        final CountDownLatch startGate = new CountDownLatch(1);
        // 结束门
        final CountDownLatch endGate = new CountDownLatch(nThreads);

        for (int i = 0; i < nThreads; i++) {
            Thread thread = new Thread(){
                @Override
                public void run() {
                    // 每个线程在启动门上等待，确保所有线程都就绪后才开始
                    try {
                        startGate.await();  // 等待计数器达到0
                        try {
                            task.run();
                        }finally {
                            // 每个线程结束后,调用countDown递减计数器,表示一个事件发生
                            System.out.println("countDown执行了一次");
                            endGate.countDown();
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            thread.start();
        }
        long start = System.nanoTime();
        // 启动门发生
        startGate.countDown();
        try {
            // 等待结束门的线程都结束
            endGate.await();
            System.out.println("完成之后放行...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.nanoTime();
        return end-start;
    }
}