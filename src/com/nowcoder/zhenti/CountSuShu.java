/**
 * 数素数 (20)
时间限制 1000 ms 内存限制 32768 KB 代码长度限制 100 KB 判断程序 Standard (来自 小小)
题目描述
令Pi表示第i个素数。现任给两个正整数M <= N <= 10000，请输出PM到PN的所有素数。

输入描述:
输入在一行中给出M和N，其间以空格分隔。


输出描述:
输出从PM到PN的所有素数，每10个数字占1行，其间以空格分隔，但行末不得有多余空格。

输入例子:
5 27

输出例子:
11 13 17 19 23 29 31 37 41 43

47 53 59 61 67 71 73 79 83 89

97 101 103
 */
package com.nowcoder.zhenti;

import java.util.Scanner;

public class CountSuShu {

	public static boolean checkPrimeNum(int num){
		boolean flag = true;
		for(int i=2;i<=Math.sqrt(num);i++){
			if(num%i==0){
				flag=false;
				break;
			}
		}
		return flag;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a,b;
		a = sc.nextInt();
		b = sc.nextInt();
		int count=0;	
		int i=2;
		StringBuffer sb = new StringBuffer();
		int count2 = 0;
		while(true){
			if(checkPrimeNum(i)){
				count++;
				if(count>=a&&count<=b){
					count2++;
					sb.append(String.valueOf(i));
					if(count2%10==0){
						sb.append("\n");
					}else{
						sb.append(" ");
					}
				}
			}
			if(count>b) break;
			i++;
		}
		if(sb.charAt(sb.length()-1)==' ') sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
	}
}
