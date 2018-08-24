package com.nowcoder.concurrent.artOfJavaConcurrency.chapter4;

import java.util.concurrent.TimeUnit;

/**
 * Created by ChenRui on 18-4-2
 */
public class Interrupted {

    public static void main(String[] args) throws InterruptedException {
//        Thread sleepThread = new Thread(new SleepRunner(), "SleepThread");
//        sleepThread.setDaemon(true);

        Thread busyThread = new Thread(new BusyRunner(), "BusyThread");
//        busyThread.setDaemon(true);
//        sleepThread.start();
        busyThread.start();
        TimeUnit.SECONDS.sleep(5);
//        sleepThread.interrupt();
        busyThread.interrupt();

//        System.out.println("SleepThread interrupted is " + sleepThread.isInterrupted());
        System.out.println("BusyThread interrupted is " + busyThread.isInterrupted());
        // ·ÀÖ¹sleepThreadºÍbusyThreadÁ¢¼´ÍË³ö
//        Thread.sleep(2000);
    }

    private static class SleepRunner implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class BusyRunner implements Runnable {
        @Override
        public void run() {
            int i =1;
            while (i>0) {
                System.out.println("keep printing!"+i);
                i++;
            }
        }
    }
}
