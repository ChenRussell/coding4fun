/**
 * 个位数统计 (15)
时间限制 1000 ms 内存限制 32768 KB 代码长度限制 100 KB 判断程序 Standard (来自 小小)
题目描述
给定一个k位整数N = dk-1*10k-1 + ... + d1*101 + d0 (0<=di<=9, i=0,...,k-1, dk-1>0)，请编写程序统计每种不同的个位数字出现的次数。例如：给定N = 100311，则有2个0，3个1，和1个3。

输入描述:
每个输入包含1个测试用例，即一个不超过1000位的正整数N。


输出描述:
对N中每一种不同的个位数字，以D:M的格式在一行中输出该位数字D及其在N中出现的次数M。要求按D的升序输出。

输入例子:
100311

输出例子:
0:2

1:3

3:1
 */
package com.nowcoder.zhenti;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class SjngleNumCount {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String num = sc.nextLine();
		char[] array = num.toCharArray();
		Map<Character,Integer> map = new TreeMap<Character,Integer>();	//默认根据key排序，升序
		for (char c : array) {
			if(map.containsKey(c)){
				map.put(c, map.get(c)+1);
			}else{
				map.put(c, 1);
			}
		}
		System.out.println(map.entrySet());
		//遍历map
		Set<Character> keySet = map.keySet();
        Iterator<Character> iter = keySet.iterator();
        while (iter.hasNext()) {
            char key = (char) iter.next();
            System.out.println(key + ":" + map.get(key));
        }
	}
}
