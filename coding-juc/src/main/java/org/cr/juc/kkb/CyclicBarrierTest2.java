package org.cr.juc.kkb;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author russ
 * @project coding-for-offer
 * @date 2021/07/08
 */
public class CyclicBarrierTest2 {
    public static void main(String[] args) throws InterruptedException {

        int N = 6;  // �˶�Ա��
        CyclicBarrier cb = new CyclicBarrier(N, new Runnable() {
            @Override
            public void run() {
                System.out.println("�����˶�Ա��׼����ϣ�����ǹ���ܣ�");
            }
        });

        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            Thread t = new Thread(new PrepareWork(cb), "�˶�Ա[" + i + "]");
            list.add(t);
            t.start();
            if (i == 3) {
                t.interrupt();  // �˶�Ա[3]���жϱ�־λ
            }
        }

        Thread.sleep(2000);
        System.out.println("Barrier�Ƿ��𻵣�" + cb.isBroken());
    }


    private static class PrepareWork implements Runnable {
        private CyclicBarrier cb;

        PrepareWork(CyclicBarrier cb) {
            this.cb = cb;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + ": ׼�����");
                cb.await();
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + ": ���ж�");
            } catch (BrokenBarrierException e) {
                System.out.println(Thread.currentThread().getName() + ": �׳�BrokenBarrierException");
            }
        }
    }
}
