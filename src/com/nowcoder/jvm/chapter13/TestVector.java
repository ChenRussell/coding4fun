package com.nowcoder.jvm.chapter13;

import java.util.Vector;

/**
 * Created by ChenRui on 18-3-23
 *
 * 对Vector线程安全的测试
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

            // 不要同时产生过多的线程, 否则会导致操作线程假死
            if (Thread.activeCount() > 20) break;
        }
    }
}
