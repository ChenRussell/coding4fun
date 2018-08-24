package com.nowcoder.testClass;

public class MyThread extends Thread {
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Thread.");
	}
	
	public static void main(String[] args) {
		MyThread t = new MyThread();
		MyThread s = new MyThread();
		t.start();
		System.out.println("one.");
		s.start();
		System.out.println("two.");
	}

}
