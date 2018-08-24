package com.nowcoder.testClass;

import java.util.Date;

public class SuperTest extends Date{

	private void test() {
		System.out.println(super.getClass().getName());		// 返回报名+类名
		System.out.println(super.getClass().getSuperclass().getName());	// 得到父类的名称
	}
	
	public static void main(String[] args) {
		new SuperTest().test();
	}
}
