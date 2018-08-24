/**
 * 1031. 查验身份证(15)
时间限制 1000 ms 内存限制 32768 KB 代码长度限制 100 KB 判断程序 Standard (来自 小小)
题目描述
一个合法的身份证号码由17位地区、日期编号和顺序编号加1位校验码组成。校验码的计算规则如下：



首先对前17位数字加权求和，权重分配为：{7，9，10，5，8，4，2，1，6，3，7，9，10，5，8，4，2}；然后将计算的和对11取模得

到值Z；最后按照以下关系对应Z值与校验码M的值：



Z：0 1 2 3 4 5 6 7 8 9 10

M：1 0 X 9 8 7 6 5 4 3 2



现在给定一些身份证号码，请你验证校验码的有效性，并输出有问题的号码。

输入描述:
输入第一行给出正整数N（<= 100）是输入的身份证号码的个数。随后N行，每行给出1个18位身份证号码。


输出描述:
按照输入的顺序每行输出1个有问题的身份证号码。这里并不检验前17位是否合理，只检查前17位是否全为数字且最后1位校验码计算准确。如果所有号码都正常，

则输出“All passed”。

输入例子:
4

320124198808240056

12010X198901011234

110108196711301866

37070419881216001X

输出例子:
12010X198901011234

110108196711301866

37070419881216001X
 */
package com.nowcoder.zhenti;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CheckIDNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		List<String> list = new ArrayList<String>();
		List<String> listNew = new ArrayList<String>();
		List<String> listIll = new ArrayList<String>();
		for (int i = 0; i < num; i++) {
			list.add(sc.next());
		}
		//判断前17位中是否有字母
		for (String str : list) {
			if(str.length()!=18) {
				listIll.add(str);
				continue;
			}
			char[] arr = str.toCharArray();
			boolean flag = true;
			for (int i = 0; i < arr.length-1; i++) {
				if(arr[i]<'0' || arr[i]>'9') {
					listIll.add(str);
					flag = false;
					break;
				}
			}
			if(flag) listNew.add(str);
		}
		if(listIll.size()==num) {
			for (String str : listIll) {
				System.out.println(str);
			}
			return;
		}
		//判断最后一位是否合法
		int wei[] = new int[] {7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2};
		char mode[] = new char[] {'1' ,'0' ,'X' ,'9' ,'8' ,'7' ,'6' ,'5' ,'4', '3' ,'2'};
		for (String str : listNew) {
			char[] arr = str.toCharArray();
			int sum = 0;
			//求加权和
			for (int i = 0; i < arr.length - 1; i++) {
				sum += wei[i]*Integer.parseInt(String.valueOf(arr[i]));
			}
			int mod = sum%11;
			if(mode[mod] != arr[arr.length-1]) {
				listIll.add(str);
			}
		}
		if(listIll.size()==0) {
			System.out.println("All passed");
			return;
		}
		for (String string : listIll) {
			System.out.println(string);
		}
	}
}
