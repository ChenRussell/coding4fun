package com.nowcoder.concurrent.CyclicBarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by ChenRui on 18-3-11
 */
public class Beer {
    public static void main(String[] args) {
        final int count = 5;
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(count, new Runnable() {
            @Override
            public void run() {
                System.out.println("drink beer! barrier开始执行了!!!");
            }
        });

        for (int i = 0; i < count; i++) {
            new Thread(new Worker(i, cyclicBarrier)).start();
        }
    }
}
