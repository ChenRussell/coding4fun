/**
 * 链接：https://www.nowcoder.com/questionTerminal/5e7d025e91ab468f909cb93d431b89c3
来源：牛客网

[编程题]有几个PAT（25）
热度指数：4081时间限制：1秒空间限制：32768K
 算法知识视频讲解
字符串APPAPT中包含了两个单词“PAT”，其中第一个PAT是第2位(P),第4位(A),第6位(T)；第二个PAT是第3位(P),第4位(A),第6位(T)。

现给定字符串，问一共可以形成多少个PAT？ 
输入描述:

输入只有一行，包含一个字符串，长度不超过105，只包含P、A、T三种字母。


输出描述:

在一行中输出给定字符串中包含多少个PAT。由于结果可能比较大，只输出对1000000007取余数的结果。
示例1
输入

APPAPT
输出

2
 */
package com.nowcoder.zhenti;

import java.util.Scanner;

public class CountPAT {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		char[] arr = str.toCharArray();
		
		int p = 0, pa=0, pat=0;
		for (char c : arr) {
			if(c == 'P') {
				p++;
			}else if(c == 'A'){
				pa += p;
			}else if(c == 'T') {
				pat += pa;
				pat = pat % 1000000007;
			}
		}
		
		System.out.println("p: "+p);
		System.out.println("pa: "+pa);
		System.out.println("pat: "+pat);
	}
}
