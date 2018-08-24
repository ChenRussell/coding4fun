package com.nowcoder.testClass;

import java.io.Serializable;

public interface InterfaceSuperClass {
	
	static int a=2;
	
	public int interface1(int a, int b);

	public void commonFunction();

	/**
	 * jdk1.8中提供了静态方法和default方法,但是这种方法必须有实现
	 */
	default void fuck(){}

	static void you(){}
}
