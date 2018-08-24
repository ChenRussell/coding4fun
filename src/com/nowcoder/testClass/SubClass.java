package com.nowcoder.testClass;

import org.junit.Test;

public class SubClass extends SuperClass {
	
	public void getSuperInfo() {
		System.out.println(this.a);
	}
	
	public static void printInfo() {
		System.out.println("this is a static function!");
	}

	public int a = 12;

//	@Test
	public void print() {
		// super代表父类对应的对象,所以用super访问在子类中无法直接使用的父类成员和方法
		System.out.println(super.a);
		System.out.println(this.a);
		System.out.println(a);	// 子类覆盖了父类的成员变量后,要想访问父类的该成员变量的值,则需要使用super关键字
	}
}
