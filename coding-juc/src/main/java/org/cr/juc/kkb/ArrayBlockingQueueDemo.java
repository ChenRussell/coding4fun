package org.cr.juc.kkb;

/**
 * @author russ
 * @project coding-for-offer
 * @date 2021/07/08
 */

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ArrayBlockingQueueDemo {
    public static void main(String[] args) {

        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(3, true);
        Producer producer = new Producer(blockingQueue);
        Consumer consumer = new Consumer(blockingQueue);

        new Thread(producer).start();

        new Thread(consumer).start();


    }

}

class Producer implements Runnable {

    private BlockingQueue<Integer> blockingQueue;
    private static int element = 0;

    public Producer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }


    public void run() {
        try {
            while (element < 20) {
                System.out.println("����Ԫ�أ�" + element);
                blockingQueue.put(element++);
            }
        } catch (Exception e) {
            System.out.println("�������ڵȴ����пռ��ʱ�����쳣��");
            e.printStackTrace();
        }
        System.out.println("��������ֹ���������̣�");
    }
}

class Consumer implements Runnable {

    private BlockingQueue<Integer> blockingQueue;

    public Consumer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }


    public void run() {
        try {
            while (true) {
                System.out.println("����Ԫ�أ�" + blockingQueue.take());
            }
        } catch (Exception e) {
            System.out.println("�������ڵȴ��²�Ʒ��ʱ�����쳣��");
            e.printStackTrace();
        }
        System.out.println("��������ֹ�����ѹ��̣�");
    }
}
