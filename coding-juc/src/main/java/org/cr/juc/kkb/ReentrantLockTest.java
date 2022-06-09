package org.cr.juc.kkb;

/**
 * @author russ
 * @project coding-for-offer
 * @date 2021/07/07
 */
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class ReentrantLockTest {
    private static Lock fairLock = new ReentrantLockMine(true);
    private static Lock unfairLock = new ReentrantLockMine(false);

    @Test
    public void unfair() throws InterruptedException {
        testLock("unfair lock", unfairLock);
    }

    @Test
    public void fair() throws InterruptedException {
        testLock("fair lock", fairLock);
    }

    private void testLock(String type, Lock lock) throws InterruptedException {
        System.out.println(type);
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Job(lock)) {
                public String toString() {
                    return getName();
                }
            };
            thread.setName("" + i);
            thread.start();
        }
        Thread.sleep(11000);
    }

    private static class Job implements Runnable {
        private Lock lock;

        public Job(Lock lock) {
            this.lock = lock;
        }

        public void run() {
            for (int i = 0; i < 2; i++) {
                lock.lock();
                try {
                    Thread.sleep(1000);
                    System.out.println("��ȡ���ĵ�ǰ�߳�[" + Thread.currentThread().getName() + "], ͬ�������е��߳�" + ((ReentrantLockMine) lock).getQueuedThreads() + "");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    private static class ReentrantLockMine extends ReentrantLock {  //����ʵ��ReentrantLock����Ϊ����дgetQueuedThreads������������������Ĺ۲�
        public ReentrantLockMine(boolean fair) {
            super(fair);
        }

        @Override
        protected Collection<Thread> getQueuedThreads() {   //��ȡͬ�������е��߳�
            List<Thread> arrayList = new ArrayList<Thread>(super.getQueuedThreads());
            Collections.reverse(arrayList);
            return arrayList;
        }
    }
}
