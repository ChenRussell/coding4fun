package org.cr.juc.kkb;

/**
 * @author russ
 * @project coding-for-offer
 * @date 2021/07/08
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

//创建一个会实现print queue的类名为 PrintQueue。
class PrintQueue {

    // 声明一个对象为Semaphore，称它为semaphore。
    private final Semaphore semaphore;

    // 实现类的构造函数并初始能保护print quere的访问的semaphore对象的值。
    public PrintQueue() {
        semaphore = new Semaphore(1);
    }

    //实现Implement the printJob()方法，此方法可以模拟打印文档，并接收document对象作为参数。
    public void printJob(Object document) {
//在这方法内，首先，你必须调用acquire()方法获得demaphore。这个方法会抛出 InterruptedException异常，使用必须包含处理这个异常的代码。
        try {
            semaphore.acquire();

//然后，实现能随机等待一段时间的模拟打印文档的行。
            long duration = (long) (Math.random() * 10);

            System.out.printf("%s: PrintQueue: Printing a Job during %d seconds\n", Thread.currentThread().getName(), duration);

            Thread.sleep(duration);

//最后，释放semaphore通过调用semaphore的relaser()方法。
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

}

//创建一个名为Job的类并一定实现Runnable 接口。这个类实现把文档传送到打印机的任务。
class Job implements Runnable {
    //声明一个对象为PrintQueue，名为printQueue。
    private PrintQueue printQueue;

    //实现类的构造函数，初始化这个类里的PrintQueue对象。
    public Job(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    //实现方法run()。
    @Override
    public void run() {
        //首先， 此方法写信息到操控台表明任务已经开始执行了。
        System.out.printf("%s: Going to print a job\n", Thread.currentThread().getName());
        // 然后，调用PrintQueue 对象的printJob()方法。
        printQueue.printJob(new Object());
        //最后， 此方法写信息到操控台表明它已经结束运行了。
        System.out.printf("%s: The document has been printed\n", Thread.currentThread().getName());

    }
}

public class SemaphoreTest {

    public static void main(String args[]) {

        // 创建PrintQueue对象名为printQueue。
        PrintQueue printQueue = new PrintQueue();
        //创建10个threads。每个线程会执行一个发送文档到print queue的Job对象。
        Thread thread[] = new Thread[10];

        for (int i = 0; i < 10; i++) {
            thread[i] = new Thread(new Job(printQueue), "Thread" + i);
        }

        for (int i = 0; i < 10; i++) {
            thread[i].start();
        }

    }
}
