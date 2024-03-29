/**
 * 科学计数法 (20)
时间限制 1000 ms 内存限制 32768 KB 代码长度限制 100 KB 判断程序 Standard (来自 小小)
题目描述
科学计数法是科学家用来表示很大或很小的数字的一种方便的方法，其满足正则表达式[+-][1-9]"."[0-9]+E[+-][0-9]+，即数字的整数部分

只有1位，小数部分至少有1位，该数字及其指数部分的正负号即使对正数也必定明确给出。



现以科学计数法的格式给出实数A，请编写程序按普通数字表示法输出A，并保证所有有效位都被保留。

输入描述:
每个输入包含1个测试用例，即一个以科学计数法表示的实数A。该数字的存储长度不超过9999字节，且其指数的绝对值不超过9999。


输出描述:
对每个测试用例，在一行中按普通数字表示法输出A，并保证所有有效位都被保留，包括末尾的0。

输入例子:
+1.23400E-03

输出例子:
0.00123400
 */
package org.cr.zhenti;

import java.math.BigDecimal;
import java.util.Scanner;

public class ScienceCountMethodV2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		BigDecimal bigDecimal = sc.nextBigDecimal();
		System.out.println(bigDecimal.toPlainString());

	}

}
