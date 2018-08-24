/**
 * 1019. 数字黑洞 (20)
时间限制 1000 ms 内存限制 32768 KB 代码长度限制 100 KB 判断程序 Standard (来自 小小)
题目描述
给定任一个各位数字不完全相同的4位正整数，如果我们先把4个数字按非递增排序，再按非递减排序，然后用第1个数字减第2个数字，将得到
 一个新的数字。一直重复这样做，我们很快会停在有“数字黑洞”之称的6174，这个神奇的数字也叫Kaprekar常数。
 
 例如，我们从6767开始，将得到
 
 7766 - 6677 = 1089
 9810 - 0189 = 9621
 9621 - 1269 = 8352
 8532 - 2358 = 6174
 7641 - 1467 = 6174
 ... ...
 
 现给定任意4位正整数，请编写程序演示到达黑洞的过程。

输入描述:
输入给出一个(0, 10000)区间内的正整数N。


输出描述:
如果N的4位数字全相等，则在一行内输出“N - N = 0000”；否则将计算的每一步在一行内输出，直到6174作为差出现，输出格式见样例,每行中间没有空行。注意每个数字按4位数格
 式输出。

输入例子:
6767

输出例子:
7766 - 6677 = 1089
 9810 - 0189 = 9621
 9621 - 1269 = 8352
 8532 - 2358 = 6174
 * 
 */
package com.nowcoder.zhenti;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class NumberBackHole {

	public static int increase(int num){
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<4;i++){
			list.add(num%10);
			num = num/10;
		}
		Collections.sort(list);   //递增排序
		int result=0;
		for (Integer n : list) {
			result = result*10 + n;
		}
		return result;
	}
	
	public static int decrease(int num){
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<4;i++){
			list.add(num%10);
			num = num/10;
		}
		Collections.sort(list, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2-o1;
			}
			
		});;   //递减排序
		int result=0;
		for (Integer n : list) {
			result = result*10 + n;
		}
		return result;
	}
	
	//转化为字符串
	public static String str(int num){
		String str = String.valueOf(num);
		if(str.length()==1){
			str="000"+str;
		}
		else if(str.length()==2){
			str="00"+str;
		}
		else if(str.length()==3){
			str="0"+str;
		}
		return str;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		int num1 = increase(number);
		int num2 = decrease(number);
//		System.out.println(num1+","+num2);
		while(true){
			if(num2==num1){
				System.out.println(str(num2)+" - "+str(num1)+" = "+"0000");
				break;
			}
			if(num2-num1!=6174){
				System.out.println(str(num2)+" - "+str(num1)+" = "+(num2-num1));
			}else{
				System.out.println(str(num2)+" - "+str(num1)+" = "+(num2-num1));
				break;
			}
			int t = num1;
			num1 = increase(num2-num1);
			num2 = decrease(num2-t);
		}
	}

}
