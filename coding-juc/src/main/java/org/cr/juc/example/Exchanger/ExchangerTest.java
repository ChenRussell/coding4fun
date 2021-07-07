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
                    String A = "������ˮA"; // A¼��������ˮ����
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
                    String B = "������ˮB"; // B¼��������ˮ����
                    String A = exgr.exchange(B);
                    System.out.println("A��B�����Ƿ�һ��:"+A.equals(B) + ", A¼����ǣ�"
                    + A + ", B¼����ǣ�" + B);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        threadPool.shutdown();
    }
}
