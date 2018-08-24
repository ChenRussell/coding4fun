package com.nowcoder.jvm.chapter7;
/**
 * 非法向前引用变量
 * @author chenrui
 *
 */
public class Test {

	static {
		i = 0;	// 可以赋值
//		System.out.println(i);	// 但是不能访问
	}
	
	static int i = 1;
}
