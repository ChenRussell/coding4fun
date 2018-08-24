package com.nowcoder.jvm.chapter7;
/**
 * 非主动使用类字段演示三
 * @author chenrui
 *
 */
public class NotInitialization3 {
	
	public static void main(String[] args) {
		System.out.println(ConstClass.HELLOWORLD);
	}
}
