/**
 * D进制的A+B (20)
时间限制 1000 ms 内存限制 32768 KB 代码长度限制 100 KB 判断程序 Standard (来自 小小)
题目描述
输入两个非负10进制整数A和B(<=230-1)，输出A+B的D (1 < D <= 10)进制数。

输入描述:
输入在一行中依次给出3个整数A、B和D。


输出描述:
输出A+B的D进制数。

输入例子:
123 456 8

输出例子:
1103
 */
package com.nowcoder.zhenti;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Djinzhi {
	
	public static int trans(int num, int d){
		List<Integer> list = new ArrayList<Integer>();
		while(true){
			list.add(num%d);
			num = num / d;
			if(num==0){
//				list.add(num%d);
				break;
			} 
		}
		String str = "";
		for(int i=list.size()-1;i>=0;i--){
			str += String.valueOf(list.get(i));
		}
		System.out.println(str);
		return Integer.parseInt(str);
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		trans(a+b, c);
		
	}
}
