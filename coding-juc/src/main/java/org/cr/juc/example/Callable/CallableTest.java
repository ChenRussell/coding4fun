package org.cr.juc.example.Callable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by ChenRui on 18-3-15
 *
 *  ��ʽ1��ͨ�����̵߳ķ�ʽ�����Լ�ʵ�֣����ȴ���һ��FutureTask�����ڴ���FutureTask�����ʱ��
 *  ��Ҫ����һ��ʵ����Callable�ӿڵĶ��󣬽����Ը�FutureTask��ΪThread�Ĳ���������Thread��start���������߳�ִ������
 *  ���ʹ��FutureTask��get������ȡ������ķ���ֵ�Ϳ����ˣ���ôΪʲôFutureTask���������ΪThread�Ĳ����أ�
 *  ԭ�������FutureTask��ʵ����RunnableFuture�ӿڣ�
 *  ��RunnableFuture�ӿ�ʵ����Runnable��Future�ӿڣ���ô��Ȼ������ΪThread�Ĳ����ˣ���������������ʵ�ַ�ʽ��
 * <p>
 * ���Կ���ȷʵ�õ���call�����ķ���ֵ�������ڵ���get������ʱ��ȴ��������̵߳�������
 * ��Ϊ������call�������������߳���ͣ��3�룬��ʱ��������������̵߳Ļ����������еĵ�����ʱ�䲻Ӧ����12:21:46�ģ�
 * Ӧ����12:21:43�������֤���������Ǹ����Ľ��ۣ�����ʹ��Runnable�ӿ��ǲ���������߳������ģ�����ʵ�����ϸ�����
 */
public class CallableTest {
    public static void main(String[] args) {
        //����ʵ����Callable�ӿڵĶ���
        MyCallable callable = new MyCallable();
        //��ʵ��Callable�ӿڵĶ�����Ϊ��������һ��FutureTask����
        FutureTask<String> task = new FutureTask<>(callable);
        //�����̴߳���ǰcallable����
        Thread thread = new Thread(task);
        //�����߳�
        System.out.println("��ʼִ�������ʱ��: " + getNowTime());
        thread.start();
        //��ȡ��call�����ķ���ֵ
        try {
            String result = task.get();
            System.out.println("�õ�����ֵ: " + result);
            System.out.println("����ִ��get��ʱ��: " + getNowTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getNowTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(new Date());
    }
}

class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(3000);
        return "call method result";
    }
}
