package org.cr.juc.artOfJavaConcurrency.chapter4;

import java.util.concurrent.TimeUnit;

/**
 * Created by ChenRui on 18-4-3
 */
public class Join {

    public static void main(String[] args) throws InterruptedException {
        Thread previous = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            // ÿһ���߳�ӵ��ǰһ���̵߳����ã���Ҫ�ȴ�һ���߳���ֹ�����ܴӵȴ��з���
            Thread thread = new Thread(new Domino(previous), String.valueOf(i));
            thread.start();
            previous = thread;
        }

        TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread().getName()+" terminate.");
    }

    private static class Domino implements Runnable {
        private Thread thread;
        public Domino(Thread previous) {
            this.thread = previous;
        }

        @Override
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" terminate.");
        }
    }
}
