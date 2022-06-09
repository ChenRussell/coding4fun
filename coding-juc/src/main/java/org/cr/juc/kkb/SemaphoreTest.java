package org.cr.juc.kkb;

/**
 * @author russ
 * @project coding-for-offer
 * @date 2021/07/08
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

//����һ����ʵ��print queue������Ϊ PrintQueue��
class PrintQueue {

    // ����һ������ΪSemaphore������Ϊsemaphore��
    private final Semaphore semaphore;

    // ʵ����Ĺ��캯������ʼ�ܱ���print quere�ķ��ʵ�semaphore�����ֵ��
    public PrintQueue() {
        semaphore = new Semaphore(1);
    }

    //ʵ��Implement the printJob()�������˷�������ģ���ӡ�ĵ���������document������Ϊ������
    public void printJob(Object document) {
//���ⷽ���ڣ����ȣ���������acquire()�������demaphore������������׳� InterruptedException�쳣��ʹ�ñ��������������쳣�Ĵ��롣
        try {
            semaphore.acquire();

//Ȼ��ʵ��������ȴ�һ��ʱ���ģ���ӡ�ĵ����С�
            long duration = (long) (Math.random() * 10);

            System.out.printf("%s: PrintQueue: Printing a Job during %d seconds\n", Thread.currentThread().getName(), duration);

            Thread.sleep(duration);

//����ͷ�semaphoreͨ������semaphore��relaser()������
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

}

//����һ����ΪJob���ಢһ��ʵ��Runnable �ӿڡ������ʵ�ְ��ĵ����͵���ӡ��������
class Job implements Runnable {
    //����һ������ΪPrintQueue����ΪprintQueue��
    private PrintQueue printQueue;

    //ʵ����Ĺ��캯������ʼ����������PrintQueue����
    public Job(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    //ʵ�ַ���run()��
    @Override
    public void run() {
        //���ȣ� �˷���д��Ϣ���ٿ�̨���������Ѿ���ʼִ���ˡ�
        System.out.printf("%s: Going to print a job\n", Thread.currentThread().getName());
        // Ȼ�󣬵���PrintQueue �����printJob()������
        printQueue.printJob(new Object());
        //��� �˷���д��Ϣ���ٿ�̨�������Ѿ����������ˡ�
        System.out.printf("%s: The document has been printed\n", Thread.currentThread().getName());

    }
}

public class SemaphoreTest {

    public static void main(String args[]) {

        // ����PrintQueue������ΪprintQueue��
        PrintQueue printQueue = new PrintQueue();
        //����10��threads��ÿ���̻߳�ִ��һ�������ĵ���print queue��Job����
        Thread thread[] = new Thread[10];

        for (int i = 0; i < 10; i++) {
            thread[i] = new Thread(new Job(printQueue), "Thread" + i);
        }

        for (int i = 0; i < 10; i++) {
            thread[i].start();
        }

    }
}
