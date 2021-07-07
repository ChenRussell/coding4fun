package org.cr.jvm.chapter13;

import java.util.Vector;

/**
 * Created by ChenRui on 18-3-23
 *
 * ��Vector�̰߳�ȫ�Ĳ���
 */
public class TestVector {

    private static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {
        while (true) {
            for (int i = 0; i < 10; i++) {
                vector.add(i);
            }

            Thread removeThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (vector) {
                        for (int i = 0; i < vector.size(); i++) {
                            vector.remove(i);
                        }
                    }
                }
            });

            Thread printThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (vector) {

                        for (int i = 0; i < vector.size(); i++) {
                            System.out.println(vector.get(i));
                        }
                    }
                }
            });

            removeThread.start();
            printThread.start();

            // ��Ҫͬʱ����������߳�, ����ᵼ�²����̼߳���
            if (Thread.activeCount() > 20) break;
        }
    }
}
