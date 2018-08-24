package com.nowcoder.concurrent.CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by ChenRui on 18-3-11
 */
public class Worker implements Runnable {

    final int id;
    final CyclicBarrier barrier;

    public Worker(int id, CyclicBarrier barrier) {
        this.id = id;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        System.out.println(this.id + " start to run!");
        try {
            this.barrier.await();
            System.out.println(this.id + " barrier 执行完成了!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
