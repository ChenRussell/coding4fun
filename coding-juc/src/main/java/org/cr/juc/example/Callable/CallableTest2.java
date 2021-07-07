package org.cr.juc.example.Callable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by ChenRui on 18-3-15
 */
public class CallableTest2 {
    public static void main(String[] args) {
        //����ʵ����Callable�ӿڵĶ���
        MyCallable callable = new MyCallable();
        //�������ڴ���������̳߳�
        ThreadPoolExecutor threadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        //��������ӵ��̳߳��в��һ�÷��ص�FutureTask����
        System.out.println("�ύ�����ʱ��: "+getNowTime());
        FutureTask<String> task = (FutureTask<String>) threadPool.submit(callable);
        //��ȡ��call�����ķ���ֵ
        try {
            String result = task.get();
            System.out.println("�õ�����ֵ: "+result);
            System.out.println("����ִ��get��ʱ��: "+getNowTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getNowTime()
    {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(new Date());
    }
}
class MyCallable2 implements Callable<String>
{
    @Override
    public String call() throws Exception {
        Thread.sleep(3000);
        return "call method result";
    }
}
