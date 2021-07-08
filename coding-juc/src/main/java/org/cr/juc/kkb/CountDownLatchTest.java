package org.cr.juc.kkb;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author chenrui.a@mininglamp.com
 * @project coding-for-offer
 * @date 2021/07/08
 */
public class CountDownLatchTest {
    private static CountDownLatch startSignal = new CountDownLatch(1);
    //������ʾ����Ա��Ҫά������6���˶�Ա
    private static CountDownLatch endSignal = new CountDownLatch(6);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        for (int i = 0; i < 6; i++) {
            executorService.execute(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " �˶�Ա�ȴ�����Ա���ڣ�����");
                    startSignal.await();
                    System.out.println(Thread.currentThread().getName() + "����ȫ�����");
                    endSignal.countDown();
                    System.out.println(Thread.currentThread().getName() + "  �����յ�");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        System.out.println("����Ա���ڿ�ʼ��������");
        startSignal.countDown();
        endSignal.await();
        System.out.println("�����˶�Ա�����յ㣬����������");
        executorService.shutdown();
    }
}