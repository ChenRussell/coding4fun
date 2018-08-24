package com.nowcoder.concurrent.artOfJavaConcurrency.chapter4;

import java.util.concurrent.TimeUnit;

/**
 * Created by ChenRui on 18-4-3
 */
public class Shutdown {

    public static void main(String[] args) throws InterruptedException {
        Runer one = new Runer();
        Thread countThread = new Thread(one, "CountThread");
        countThread.start();
        // 睡眠一秒，main线程对CountThread进行中断，使其能够感知中断而结束
        TimeUnit.SECONDS.sleep(1);
        countThread.interrupt();    // 中断标志位置为true, isInterrupted()会返回true

        Runer two = new Runer();
        countThread = new Thread(two, "CountThread");
        countThread.start();
        TimeUnit.SECONDS.sleep(1);
//        TimeUnit.sl
//        TimeUnit.SECONDS.sleep();
        two.cancel();
    }

    private static class Runer implements Runnable{

        private long i;
        private volatile boolean on = true;
        @Override
        public void run() {
            while (on && !Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println("Count i=" +i);
        }

        public void cancel() {
            on = false;
        }
    }
}
