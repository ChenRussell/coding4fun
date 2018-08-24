/**
 * 完美数列(25)
时间限制 1000 ms 内存限制 32768 KB 代码长度限制 100 KB 判断程序 Standard (来自 小小)
题目描述
给定一个正整数数列，和正整数p，设这个数列中的最大值是M，最小值是m，如果M <= m * p，则称这个数列是完美数列。



现在给定参数p和一些正整数，请你从中选择尽可能多的数构成一个完美数列。

输入描述:
输入第一行给出两个正整数N和p，其中N（<= 105）是输入的正整数的个数，p（<= 109）是给定的参数。第二行给出N个正整数，每个数

不超过109。


输出描述:
在一行中输出最多可以选择多少个数可以用它们组成一个完美数列。

输入例子:
10 8

2 3 20 4 5 1 6 7 8 9

输出例子:
8
 */
package com.nowcoder.zhenti;

import java.util.Arrays;
import java.util.Scanner;

public class PerfectArrayListV2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		// ctr+shift+o 快捷键导入包,还可以去掉无用的包哟
		int num = sc.nextInt();
		int p = sc.nextInt();
		int[] arr = new int[num];
		for (int i = 0; i < num; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int maxLen = 0;
		
		//思路是arr[i]与arr[j]之间的距离maxLen只会增加，不会减少
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + maxLen; j < arr.length; j++) {
				if(arr[i]*p < arr[j]) break;
				maxLen ++;
			}
		}
		System.out.println(maxLen);
	}
}
