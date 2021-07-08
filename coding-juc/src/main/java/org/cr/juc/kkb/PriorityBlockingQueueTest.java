package org.cr.juc.kkb;

/**
 * @author chenrui.a@mininglamp.com
 * @project coding-for-offer
 * @date 2021/07/08
 */
import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        PriorityBlockingQueue<PriorityElement> queue = new PriorityBlockingQueue<>();
        for (int i = 0; i < 5; i++) {
            Random random=new Random();
            PriorityElement ele = new PriorityElement(random.nextInt(10));
            queue.put(ele);
        }
        while(!queue.isEmpty()){
            System.out.println(queue.take());
        }
    }

    static class PriorityElement implements Comparable<PriorityElement> {
        private int priority;//�������ȼ�
        PriorityElement(int priority) {
            //��ʼ�����ȼ�
            this.priority = priority;
        }
        @Override
        public int compareTo(PriorityElement o) {
            //�������ȼ���С��������
            return priority >= o.getPriority() ? 1 : -1;
        }
        public int getPriority() {
            return priority;
        }
        public void setPriority(int priority) {
            this.priority = priority;
        }
        @Override
        public String toString() {
            return "PriorityElement [priority=" + priority + "]";
        }
    }
}
