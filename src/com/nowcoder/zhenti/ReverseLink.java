/**
 * 反转链表 (25)
时间限制 1000 ms 内存限制 32768 KB 代码长度限制 100 KB 判断程序 Standard (来自 小小)
题目描述
给定一个常数K以及一个单链表L，请编写程序将L中每K个结点反转。例如：给定L为1→2→3→4→5→6，K为3，则输出应该为

3→2→1→6→5→4；如果K为4，则输出应该为4→3→2→1→5→6，即最后不到K个元素不反转。

输入描述:
每个输入包含1个测试用例。每个测试用例第1行给出第1个结点的地址、结点总个数正整数N(<= 105)、以及正整数K(<=N)，即要求反转的

子链结点的个数。结点的地址是5位非负整数，NULL地址用-1表示。



接下来有N行，每行格式为：



Address Data Next



其中Address是结点地址，Data是该结点保存的整数数据，Next是下一结点的地址。


输出描述:
对每个测试用例，顺序输出反转后的链表，其上每个结点占一行，格式与输入相同。

输入例子:
00100 6 4

00000 4 99999

00100 1 12309

68237 6 -1

33218 3 00000

99999 5 68237

12309 2 33218

输出例子:
00000 4 33218

33218 3 12309

12309 2 00100

00100 1 99999

99999 5 68237

68237 6 -1
 * 
 */
package com.nowcoder.zhenti;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ReverseLink {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String add = sc.next();		//nextLine()方法遇到空格不中断输入，所以需要使用next()方法
		int a = sc.nextInt();
		int b = sc.nextInt();
		String arr[][] = new String[a][3];
//		String arr2[][] = new String[a][3];
		for(int i=0;i<a;i++){
			arr[i][0] = sc.next();
			arr[i][1] = sc.next();
			arr[i][2] = sc.next();
		}
//		for (String[] strings : arr) {
//			System.out.println(strings[0]+" "+strings[1]+" "+strings[2]);
//		}
		int count = 0;
		while(true){
			for(int i=0;i<a;i++){
				if(arr[i][0].equals(add)){
					add = arr[i][2];
					String[] temp = arr[i];
					arr[i] = arr[count];
					arr[count++] = temp;
					break;
				}
			}
			if(add.equals("-1")) break;
		}
//		for (String[] strings : arr2) {
//			System.out.println(strings[0]+" "+strings[1]+" "+strings[2]);
//		}
		
		for(int i=0,j=b-1;i<b/2;i++,j--){
			String[] temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
//		System.out.println("------------------------------");
//		for (String[] strings : arr) {
//			System.out.println(strings[0]+" "+strings[1]+" "+strings[2]);
//		}
		for(int i=0;i<count;i++){
			System.out.println(arr[i][0]+" "+arr[i][1]+" "+arr[i][2]);
		}
		
		
		
		
//		Map<String,HashMap<Integer,String>> map = new HashMap<String,HashMap<Integer,String>>();
//		for(int i=0;i<a;i++){
//			String addr = sc.nextLine();
//			int data = sc.nextInt();
//			sc.nextLine();
//			String next = sc.nextLine();
//			map.put(addr, new HashMap<Integer,String>());
//		}
	}
}
