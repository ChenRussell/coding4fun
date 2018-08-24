/**
 *题目：数串
 * 时间限制：1秒 空间限制：32768K 热度指数：23713
 算法知识视频讲解
题目描述
设有n个正整数，将他们连接成一排，组成一个最大的多位整数。
如:n=3时，3个整数13,312,343,连成的最大整数为34331213。
如:n=4时,4个整数7,13,4,246连接成的最大整数为7424613。
输入描述:
有多组测试样例，每组测试样例包含两行，第一行为一个整数N（N<=100），第二行包含N个数(每个数不超过1000，空格分开)。
输出描述:
每组数据输出一个表示最大的整数。
示例1
输入

2
12 123
4
7 13 4 246
输出

12312
7424613
 */
package com.nowcoder.zhenti;

import java.util.Scanner;

public class DataString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
			n = sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++){
				arr[i] = sc.nextInt();
			}
			int temp;
			// 选择排序
			for(int i=0;i<n;i++){
				int max = i;
				for(int j=i+1;j<n;j++){
					//连接起来再比较
					if((String.valueOf(arr[max])+(String.valueOf(arr[j]))).compareTo((String.valueOf(arr[j])+String.valueOf(arr[max])))<0){
						max = j;	//记录最大值的位置
					}
				}
				temp = arr[i];
				arr[i] = arr[max];
				arr[max] = temp;
			}
		String str = "";
		for(int i=0; i<n;i++){
			str += String.valueOf(arr[i]);
		}
		System.out.println(str);
	}
	
	public static boolean compare(int a, int b){
		if(a == b) return true;
		
		if(divide(a)>divide(b)){
			return true;
		}
		else if(divide(a) == divide(b)){
			return compare(fuck(a),fuck(b));
		}
		else{
			return false;
		}
	}
	
	public static int divide(int a){
		if(a/10 == 0){
			return a;
		}else{
			return divide(a/10);
		}
	}
	
	public static int fuck(int a){
		int a2=a;
		int s = 1;
		int count = 0;
		while(a/10!=0){
			a = a/10;
			count++;
		}
		while(count>0){
			s = s*10;
			count--;
		}
		return a2%s;
	}
}
