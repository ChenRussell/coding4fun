/**
 * D���Ƶ�A+B (20)
ʱ������ 1000 ms �ڴ����� 32768 KB ���볤������ 100 KB �жϳ��� Standard (���� СС)
��Ŀ����
���������Ǹ�10��������A��B(<=230-1)�����A+B��D (1 < D <= 10)��������

��������:
������һ�������θ���3������A��B��D��


�������:
���A+B��D��������

��������:
123 456 8

�������:
1103
 */
package org.cr.zhenti;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Djinzhi {

	public static int trans(int num, int d){
		List<Integer> list = new ArrayList<Integer>();
		while(true){
			list.add(num%d);
			num = num / d;
			if(num==0){
//				list.add(num%d);
				break;
			}
		}
		String str = "";
		for(int i=list.size()-1;i>=0;i--){
			str += String.valueOf(list.get(i));
		}
		System.out.println(str);
		return Integer.parseInt(str);
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		trans(a+b, c);

	}
}
