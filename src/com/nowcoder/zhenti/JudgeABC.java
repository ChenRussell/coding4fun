package com.nowcoder.zhenti;
/**
 * 题目描述
给定区间[-2的31次方, 2的31次方]内的3个整数A、B和C，请判断A+B是否大于C。

输入描述:
输入第1行给出正整数T(<=10)，是测试用例的个数。随后给出T组测试用例，每组占一行，顺序给出A、B和C。整数间以空格分隔。


输出描述:
对每组测试用例，在一行中输出“Case #X: true”如果A+B>C，否则输出“Case #X: false”，其中X是测试用例的编号（从1开始）。

输入例子:
4

1 2 3

2 3 4

2147483647 0 2147483646

0 -2147483648 -2147483647

输出例子:
Case #1: false

Case #2: true

Case #3: true

Case #4: false
 * @author ChenRui
 *
 */

// 即可以输入一条输出一条，也可以都输入之后，在输出
import java.util.Scanner;
public class JudgeABC {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 0;	// num<=10
		String str = "";
		num = sc.nextInt();
		sc.nextLine();
		if(num<=10){
		String[] strs = new String[num];
		// 接受输入字符
		for(int i=0;i<num;i++){
			strs[i] = sc.nextLine();
//			sc.nextLine();           字符串之间不用接受回车键？
//			System.out.println(strs[i]);
//			String[] split = strs[i].split(" ");
//			int a = Integer.parseInt(split[0]);
//			int b = Integer.parseInt(split[1]);
//			int c = Integer.parseInt(split[2]);
//			long a,b,c;
//			a = Long.parseLong(split[0]);
//			b = Long.parseLong(split[1]);
//			c = Long.parseLong(split[2]);
//			boolean boo;
//			boo=(a + b > c);
//			System.out.println("Case #"+(i+1)+": "+boo);
		}
		
		
		//判断
		for(int i = 0; i < num; i++){
			String[] split = strs[i].split(" ");
			long a,b,c;
			a = Long.parseLong(split[0]);
			b = Long.parseLong(split[1]);
			c = Long.parseLong(split[2]);
			boolean boo;
			boo=(a + b > c);
			System.out.println("Case #"+(i+1)+": "+boo);
		}
		}
	}
}
