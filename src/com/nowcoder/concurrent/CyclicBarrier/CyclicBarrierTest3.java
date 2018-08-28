package com.nowcoder.concurrent.CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * created by chenrui18,2018/8/28 at 13:51
 */
public class CyclicBarrierTest3 {

    static CyclicBarrier c = new CyclicBarrier(3);

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("execute thread");
            }
        });
        thread.start();
        thread.interrupt();

        try {
            c.await();
        } catch (Exception e) {
            System.out.println(c.isBroken());
            e.printStackTrace();
        }
        System.out.println("execute main thread");
    }
}
