package org.cr.juc.example.CountDownLatch;

/**
 * Created by ChenRui on 18-3-11
 */
public class TestHarnessMain {
    public static void main(String[] args) {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("ִ������,�����߳�: "+Thread.currentThread().getName());
            }
        };

        int count =10;
        TestHarness testHarness = new TestHarness(count, task);
        long time = testHarness.timeTask();
        System.out.println("���� ������� ִ��"+count+"���߳� һ����ʱ: "+time);

    }
}
