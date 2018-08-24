package com.nowcoder.jvm.chapter7;

/**
 * 非主动使用类字段演示
 * @author chenrui
 *
 */
public class NotInitialization {
	
	public static void main(String[] args) {
		System.out.println(SubClass.value);
	}
}
