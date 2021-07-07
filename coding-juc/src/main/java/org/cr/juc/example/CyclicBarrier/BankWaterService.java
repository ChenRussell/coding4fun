package org.cr.juc.example.CyclicBarrier;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.*;

/**
 * created by chenrui18,2018/8/28 at 13:15
 */
public class BankWaterService implements Runnable {

    /**
     * ����4�����ϣ�������֮��ִ�е�ǰ���run����
     */
    private CyclicBarrier c = new CyclicBarrier(4, this);

    /**
     * ����ֻ��4��sheet������ֻ����4���߳�
     */
    private Executor executor = Executors.newFixedThreadPool(4);

    /**
     * ����ÿ��sheet��������������
     */
    private ConcurrentHashMap<String, Integer> sheetBankWaterCount = new ConcurrentHashMap<>();

    private void count() {
        for (int i = 0; i < 4; i++) {

            /**
             * ��Java8�У�����lambda���ʽ���� �Լ�������һЩ�仯��Java������һ���µĸ������
             * effectively final variable��
             * ��������ĺ������������ڲ������lambda���ʽʹ��һ����final�ı�����
             * �������final�ı�������effectively final variable��
             * ��Java8��ǰ�İ汾�У����ڲ�����������ڲ������ǲ�����ʹ�÷�final���εľֲ������ġ�
             * ������Java8�У���������ڲ�����������ڲ�����ʹ��effectively final������
             * ����һ���ڷ����ֵ֮������ֵ��Ҳû�иı���ı���
             */
             int count = i;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    // ���㵱ǰsheet���������ݣ��������ʡ��
                    sheetBankWaterCount.put(Thread.currentThread().getName(), 1);
                    // ����������ɣ�����һ������
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
        // ����ÿ��sheet������Ľ��
        Set<Map.Entry<String, Integer>> entries = sheetBankWaterCount.entrySet();
        for (Map.Entry<String, Integer> sheet :
                entries) {
            result += sheet.getValue();
        }

        // ��������
        sheetBankWaterCount.put("result", result);
        System.out.println(result);
    }

    public static void main(String[] args) {
        BankWaterService bankWaterService = new BankWaterService();
        bankWaterService.count();
    }
}
