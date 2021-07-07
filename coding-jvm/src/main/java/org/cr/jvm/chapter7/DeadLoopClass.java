package org.cr.jvm.chapter7;

/**
 * ����߳�ͬʱȥ��ʼ��һ����,��ôֻ����һ���߳�ȥִ��������<clinit>()����,�����̶߳���Ҫ�����ȴ�
 * ֱ����߳�ִ��<clinit>()�������
 *
 * @author chenrui
 *
 */
public class DeadLoopClass {

	static {
		if (true) {
			System.out.println(Thread.currentThread() + "init DeadLoopClass");
			while (true) {
			}
		}
	}


	public static void main(String[] args) {

		Runnable script = new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println(Thread.currentThread() + "start");
				DeadLoopClass dlc = new DeadLoopClass();	// static����������е�ʱ��ͻ�����,�������������ʼ��
				System.out.println(Thread.currentThread() + "run over");
			}
		};
		Thread thread1 = new Thread(script);
		Thread thread2 = new Thread(script);
		thread1.start();
		thread2.start();
	}
}
