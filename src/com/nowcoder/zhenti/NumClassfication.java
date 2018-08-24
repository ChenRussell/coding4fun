/**
 * 给定一系列正整数，请按要求对数字进行分类，并输出以下5个数字：



A1 = 能被5整除的数字中所有偶数的和；

A2 = 将被5除后余1的数字按给出顺序进行交错求和，即计算n1-n2+n3-n4...；

A3 = 被5除后余2的数字的个数；

A4 = 被5除后余3的数字的平均数，精确到小数点后1位；

A5 = 被5除后余4的数字中最大数字。

输入描述:
每个输入包含1个测试用例。每个测试用例先给出一个不超过1000的正整数N，随后给出N个不超过1000的待分类的正整数。数字间以空格分隔。


输出描述:
对给定的N个正整数，按题目要求计算A1~A5并在一行中顺序输出。数字间以空格分隔，但行末不得有多余空格。

若其中某一类数字不存在，则在相应位置输出“N”。

输入例子:
13 1 2 3 4 5 6 7 8 9 10 20 16 18

输出例子:
30 11 2 9.7 9
 */
package com.nowcoder.zhenti;

import java.text.DecimalFormat;
import java.util.Scanner;

public class NumClassfication {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		Integer arr[] = new Integer[num];
		//获取输入数据
		for(int i = 0;i < num;i++){
			arr[i] = sc.nextInt();
		}
		int a1=0,a2=0,a3=0,a5=0;
		boolean b1=false,b2=false,b3=false,b4=false,b5=false;
		float a4=0;
		boolean flag = true;
		int count=0;
		int max=Integer.MIN_VALUE;
		DecimalFormat df = new DecimalFormat("0.0");
		for(int i=0;i<num;i++){
			//求A1
			if(arr[i]%5==0 && arr[i]%2==0){
				a1+=arr[i];
				b1=true;
			}
			//求A2
			if(arr[i]%5==1){
				b2=true;
				if(flag){
					a2 += arr[i];
					flag=false;
				}else{
					a2 -= arr[i];
					flag=true;
				}
			}
			//求A3
			if(arr[i]%5==2){
				b3=true;
				a3++;
			}
			//求A4
			if(arr[i]%5==3){
				b4=true;
				a4 += arr[i];
				count++;
				}
			//求A5
			if(arr[i]%5==4){
				b5=true;
				if(arr[i]>max){
					max = arr[i];
				}
			}
		}
		a4 = a4/count;
		String s1 = String.valueOf(a1);
		String s2 = String.valueOf(a2);
		String s3 = String.valueOf(a3);
		String s4 = df.format(a4);
		String s5 = String.valueOf(max);
		if(!b1) s1="N";
		if(!b2) s2="N";
		if(!b3) s3="N";
		if(!b4) s4="N";
		if(!b5) s5="N";
		System.out.println(s1+" "+s2+" "+s3+" "+s4+" "+s5);
	}
}
