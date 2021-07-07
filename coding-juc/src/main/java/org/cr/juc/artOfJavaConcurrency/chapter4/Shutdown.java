package org.cr.juc.artOfJavaConcurrency.chapter4;

import java.util.concurrent.TimeUnit;

/**
 * Created by ChenRui on 18-4-3
 */
public class Shutdown {

    public static void main(String[] args) throws InterruptedException {
        Runer one = new Runer();
        Thread countThread = new Thread(one, "CountThread");
        countThread.start();
        // ˯��һ�룬main�̶߳�CountThread�����жϣ�ʹ���ܹ���֪�ж϶�����
        TimeUnit.SECONDS.sleep(1);
        countThread.interrupt();    // �жϱ�־λ��Ϊtrue, isInterrupted()�᷵��true

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
