/**
 * 挖掘机技术哪家强(20)
时间限制 1000 ms 内存限制 32768 KB 代码长度限制 100 KB 判断程序 Standard (来自 小小)
题目描述
为了用事实说明挖掘机技术到底哪家强，PAT组织了一场挖掘机技能大赛。现请你根据比赛结果统计出技术最强的那个学校。

输入描述:
输入在第1行给出不超过105的正整数N，即参赛人数。随后N行，每行给出一位参赛者的信息和成绩，包括其所代表的学校的编号（从1开始

连续编号）、及其比赛成绩（百分制），中间以空格分隔。


输出描述:
在一行中给出总得分最高的学校的编号、及其总分，中间以空格分隔。题目保证答案唯一，没有并列。

输入例子:
6

3 65

2 80

1 100

2 70

3 40

3 0

输出例子:
2 150
 */
package com.nowcoder.zhenti;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Wajueji {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for (int i = 0; i < num; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(map.containsKey(a)) {
				map.put(a, b+map.get(a));
			}else {
				map.put(a, b);
			}
		}
//		System.out.println(map);
		int max = -1;
		int key = -1;
		// 遍历map
		for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
			if(entry.getValue()>max) {
				max = entry.getValue();
				key = entry.getKey();
			}
		}
		System.out.println(key+" "+map.get(key));
	}
}
