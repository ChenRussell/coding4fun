/**
 * 在霍格沃茨找零钱（20）
时间限制 1000 ms 内存限制 32768 KB 代码长度限制 100 KB 判断程序 Standard (来自 小小)
题目描述
如果你是哈利·波特迷，你会知道魔法世界有它自己的货币系统 —— 就如海格告诉哈利的：“十七个银西可(Sickle)兑一个加隆(Galleon)，二

十九个纳特(Knut)兑一个西可，很容易。”现在，给定哈利应付的价钱P和他实付的钱A，你的任务是写一个程序来计算他应该被找的零钱。

输入描述:
输入在1行中分别给出P和A，格式为“Galleon.Sickle.Knut”，其间用1个空格分隔。这里Galleon是[0, 107]]区间内的整数，Sickle是[0, 

17)区间内的整数，Knut是[0, 29)区间内的整数。


输出描述:
在一行中用与输入同样的格式输出哈利应该被找的零钱。如果他没带够钱，那么输出的应该是负数。

输入例子:
10.16.27 14.1.28

输出例子:
3.2.1
 */
package com.nowcoder.zhenti;

import java.util.Scanner;

public class LookChange {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		
		String[] spl1 = str1.split("\\.");	// 参数为正则表达式
		String[] spl2 = str2.split("\\.");
//		System.out.println(spl1[0] +" "+ spl1[1]+" "+spl1[2]);
//		System.out.println(spl2[0] +" "+ spl2[1]+" "+spl2[2]);
		int g1 = Integer.parseInt(spl1[0]);
		int s1 = Integer.parseInt(spl1[1]);
		int k1 = Integer.parseInt(spl1[2]);
		
		int g2 = Integer.parseInt(spl2[0]);
		int s2 = Integer.parseInt(spl2[1]);
		int k2 = Integer.parseInt(spl2[2]);
		
		int total1 = g1*17*29 + s1*29 + k1;
		int total2 = g2*17*29 + s2*29 + k2;
		int change = total2 - total1;
		if(change<0) {
			change = -change;
			System.out.print("-");
		}
		int g = change / 493;
		int k = change % 29;
		int s = change / 29 % 17;
		System.out.println(g+"."+s+"."+k);
		
	}
}
