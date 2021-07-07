package org.cr.juc.example.CountDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by ChenRui on 18-3-11
 *
 * �ڼ�ʱ������ʹ��CountDownLatch��������ֹͣ�̣߳�������
 */
public class TestHarness {

    int nThreads;
    Runnable task;

    public TestHarness(int nThreads, Runnable task) {
        this.nThreads = nThreads;
        this.task = task;
    }

    public long timeTask() {
        // ��ʼ��
        final CountDownLatch startGate = new CountDownLatch(1);
        // ������
        final CountDownLatch endGate = new CountDownLatch(nThreads);

        for (int i = 0; i < nThreads; i++) {
            Thread thread = new Thread(){
                @Override
                public void run() {
                    // ÿ���߳����������ϵȴ���ȷ�������̶߳�������ſ�ʼ
                    try {
                        startGate.await();  // �ȴ��������ﵽ0
                        try {
                            task.run();
                        }finally {
                            // ÿ���߳̽�����,����countDown�ݼ�������,��ʾһ���¼�����
                            System.out.println("countDownִ����һ��");
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
        // �����ŷ���
        startGate.countDown();
        try {
            // �ȴ������ŵ��̶߳�����
            endGate.await();
            System.out.println("���֮�����...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.nanoTime();
        return end-start;
    }
}
