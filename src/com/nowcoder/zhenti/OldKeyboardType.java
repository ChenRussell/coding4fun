/**
 * 旧键盘打字(20)
时间限制 1000 ms 内存限制 32768 KB 代码长度限制 100 KB 判断程序 Standard (来自 小小)
题目描述
旧键盘上坏了几个键，于是在敲一段文字的时候，对应的字符就不会出现。现在给出应该输入的一段文字、以及坏掉的那些键，打出的结果文

字会是怎样？

输入描述:
输入在2行中分别给出坏掉的那些键、以及应该输入的文字。其中对应英文字母的坏键以大写给出；每段文字是不超过10^5个字符的串。可用的

字符包括字母[a-z, A-Z]、数字0-9、以及下划线“_”（代表空格）、“,”、“.”、“-”、“+”（代表上档键）。题目保证第2行输入的文字串非空。



注意：如果上档键坏掉了，那么大写的英文字母无法被打出。


输出描述:
在一行中输出能够被打出的结果文字。如果没有一个字符能被打出，则输出空行。

输入例子:
7+IE.

7_This_is_a_test.

输出例子:
_hs_s_a_tst
 */
package com.nowcoder.zhenti;

import java.util.Scanner;

public class OldKeyboardType {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();	// nextLine()会被空回车字符影响
		String str2 = sc.next();
//		System.out.println(str1+" "+str2);
		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();
		for (char c : arr1) {
			if(c!='+') {
				if(c=='.') {
					str2.replaceAll("\\.", "");// 对‘.’ 转义 ，(valid ones are  \b  \t  \n  \f  \r  \"  \'  \\ )
					continue;
				}
				if(str2.contains(String.valueOf(c))||str2.contains(String.valueOf(c).toLowerCase())) {
					str2 = str2.replaceAll(String.valueOf(c), "");
					str2 = str2.replaceAll(String.valueOf(c).toLowerCase(), "");
				}
			}
			else {
				for (char c1 : arr2) {
					if(c1>='A' && c1<='Z') {
						str2 = str2.replaceAll(String.valueOf(c1), "");
					}
				}
			}
		}
		System.out.println(str2);
	}
}
