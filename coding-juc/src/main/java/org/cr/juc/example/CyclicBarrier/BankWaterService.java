package org.cr.juc.example.CyclicBarrier;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.*;

/**
 * created by chenrui18,2018/8/28 at 13:15
 */
public class BankWaterService implements Runnable {

    /**
     * 创建4个屏障，处理完之后执行当前类的run方法
     */
    private CyclicBarrier c = new CyclicBarrier(4, this);

    /**
     * 假设只有4个sheet，所以只启动4个线程
     */
    private Executor executor = Executors.newFixedThreadPool(4);

    /**
     * 保存每个sheet计算出的银流结果
     */
    private ConcurrentHashMap<String, Integer> sheetBankWaterCount = new ConcurrentHashMap<>();

    private void count() {
        for (int i = 0; i < 4; i++) {

            /**
             * 在Java8中，除了lambda表达式，流 以及其他的一些变化，Java引入了一个新的概念叫做
             * effectively final variable，
             * 这个变量的含义是允许在内部类或者lambda表达式使用一个非final的变量，
             * 则这个非final的变量就是effectively final variable。
             * 在Java8以前的版本中，在内部类或者匿名内部类中是不允许使用非final修饰的局部变量的。
             * 但是在Java8中，你可以在内部类或者匿名内部类中使用effectively final变量，
             * 例如一个在分配过值之后它的值在也没有改变过的变量
             */
             int count = i;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    // 计算当前sheet的银流数据，计算代码省略
                    sheetBankWaterCount.put(Thread.currentThread().getName(), 1);
                    // 银流计算完成，插入一个屏障
                    try {
                        c.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("execute " +count+ "th thread.");
                }
            });
        }
    }

    @Override
    public void run() {
        int result = 0;
        // 汇总每个sheet计算出的结果
        Set<Map.Entry<String, Integer>> entries = sheetBankWaterCount.entrySet();
        for (Map.Entry<String, Integer> sheet :
                entries) {
            result += sheet.getValue();
        }

        // 将结果输出
        sheetBankWaterCount.put("result", result);
        System.out.println(result);
    }

    public static void main(String[] args) {
        BankWaterService bankWaterService = new BankWaterService();
        bankWaterService.count();
    }
}
