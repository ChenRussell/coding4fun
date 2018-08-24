/**
 * 统计同成绩学生(20)
时间限制 1000 ms 内存限制 32768 KB 代码长度限制 100 KB 判断程序 Standard (来自 小小)
题目描述
本题要求读入N名学生的成绩，将获得某一给定分数的学生人数输出。

输入描述:
输入在第1行给出不超过105的正整数N，即学生总人数。随后1行给出N名学生的百分制整数成绩，中间以空格分隔。最后1行给出要查询的分

数个数K（不超过N的正整数），随后是K个分数，中间以空格分隔。


输出描述:
在一行中按查询顺序给出得分等于指定分数的学生人数，中间以空格分隔，但行末不得有多余空格。

输入例子:
10

60 75 90 55 75 99 82 90 75 50

3 75 90 88

输出例子:
3 2 0
 */
package com.nowcoder.zhenti;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountSamePoint {
	public static void main(String[] args) {
		int n, k;
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		List<Integer> countlist = new ArrayList<Integer>();
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			list1.add(sc.nextInt());
		}
		k = sc.nextInt();
		for (int i = 0; i < k; i++) {
			list2.add(sc.nextInt());
			countlist.add(0);
		}
//		System.out.println(n);
//		System.out.println(list1);
//		System.out.println(k);
//		System.out.println(list2);
		int index = 0;
		for (Integer in2 : list2) {
			for (Integer in1 : list1) {
				if(in1.equals(in2)) {
					countlist.set(index, countlist.get(index)+1);
				}
			}
			index++;
		}
//		System.out.println(countlist);
		String outstr = "";
		for (Integer integer : countlist) {
			outstr += String.valueOf(integer)+" ";
		}
		outstr = outstr.substring(0, outstr.length()-1);
		System.out.println(outstr);
	}
}
