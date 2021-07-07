package org.cr.juc.example.Exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * created by chenrui18,2018/8/28 at 14:46
 */
public class ExchangerTest {

    private static final Exchanger<String> exgr = new Exchanger<>();

    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String A = "银行流水A"; // A录入银行流水数据
                    exgr.exchange(A);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String B = "银行流水B"; // B录入银行流水数据
                    String A = exgr.exchange(B);
                    System.out.println("A和B数据是否一致:"+A.equals(B) + ", A录入的是："
                    + A + ", B录入的是：" + B);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        threadPool.shutdown();
    }
}
