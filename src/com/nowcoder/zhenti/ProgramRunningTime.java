/**
 * 程序运行时间(15)
时间限制 1000 ms 内存限制 32768 KB 代码长度限制 100 KB 判断程序 Standard (来自 小小)
题目描述
要获得一个C语言程序的运行时间，常用的方法是调用头文件time.h，其中提供了clock()函数，可以捕捉从程序开始运行到clock()被调用时所

耗费的时间。这个时间单位是clock tick，即“时钟打点”。同时还有一个常数CLK_TCK，给出了机器时钟每秒所走的时钟打点数。于是为了获

得一个函数f的运行时间，我们只要在调用f之前先调用clock()，获得一个时钟打点数C1；在f执行完成后再调用clock()，获得另一个时钟打点

数C2；两次获得的时钟打点数之差(C2-C1)就是f运行所消耗的时钟打点数，再除以常数CLK_TCK，就得到了以秒为单位的运行时间。



这里不妨简单假设常数CLK_TCK为100。现给定被测函数前后两次获得的时钟打点数，请你给出被测函数运行的时间。

输入描述:
输入在一行中顺序给出2个整数C1和C1。注意两次获得的时钟打点数肯定不相同，即C1 < C2，并且取值在[0, 107]


输出描述:
在一行中输出被测函数运行的时间。运行时间必须按照“hh:mm:ss”（即2位的“时:分:秒”）格式输出；不足1秒的时间四舍五入到秒。

输入例子:
123 4577973

输出例子:
12:42:59
 */
package com.nowcoder.zhenti;

import java.util.Scanner;

public class ProgramRunningTime {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		long a1 = Math.round(a/100.0);
		long b1 = Math.round(b/100.0);
//		System.out.println(a1+" "+b1);
		long c = Math.round((b-a)/100);
		long c1 = c;
		if(c<60) c1 = 0;
		while(true){
			if(c<60){
				break;
			}
			c = c%60;
			c1 = c1/60;
		}
		long c2 =c1;
		if(c1<60) c2 = 0;
		while(true){
			if(c1<60) break;
			c1 = c1 % 60;
			c2 = c2 / 60;
		}
//		System.out.println(c);
//		System.out.println(c1);
		String str = String.valueOf(c);
		String str1 = String.valueOf(c1);
		String str2 = String.valueOf(c2);
		if(str.length()<2) str = "0"+str;
		if(str1.length()<2) str1 = "0"+str1;
		if(str2.length()<2) str2 = "0"+str2;
		System.out.println(str2+":"+str1+":"+str);
	}
}
