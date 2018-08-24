package com.nowcoder.jvm.chapter7;

/**
 * 多个线程同时去初始化一个类,那么只会有一个线程去执行这个类的<clinit>()方法,其他线程都需要阻塞等待
 * 直到活动线程执行<clinit>()方法完毕
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
				DeadLoopClass dlc = new DeadLoopClass();	// static代码块在运行的时候就会运行,而不是在这里初始化
				System.out.println(Thread.currentThread() + "run over");
			}
		};
		Thread thread1 = new Thread(script);
		Thread thread2 = new Thread(script);
		thread1.start();
		thread2.start();
	}
}
