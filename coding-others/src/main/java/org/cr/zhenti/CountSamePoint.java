/**
 * ͳ��ͬ�ɼ�ѧ��(20)
ʱ������ 1000 ms �ڴ����� 32768 KB ���볤������ 100 KB �жϳ��� Standard (���� СС)
��Ŀ����
����Ҫ�����N��ѧ���ĳɼ��������ĳһ����������ѧ�����������

��������:
�����ڵ�1�и���������105��������N����ѧ�������������1�и���N��ѧ���İٷ��������ɼ����м��Կո�ָ������1�и���Ҫ��ѯ�ķ�

������K��������N�����������������K���������м��Կո�ָ���


�������:
��һ���а���ѯ˳������÷ֵ���ָ��������ѧ���������м��Կո�ָ�������ĩ�����ж���ո�

��������:
10

60 75 90 55 75 99 82 90 75 50

3 75 90 88

�������:
3 2 0
 */
package org.cr.zhenti;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountSamePoint {
	public static void main(String[] args) {
		int n, k;
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		List<Integer> countlist = new ArrayList<Integer>();

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			list1.add(sc.nextInt());
		}
		k = sc.nextInt();
		for (int i = 0; i < k; i++) {
			list2.add(sc.nextInt());
			countlist.add(0);
		}
//		System.out.println(n);
//		System.out.println(list1);
//		System.out.println(k);
//		System.out.println(list2);
		int index = 0;
		for (Integer in2 : list2) {
			for (Integer in1 : list1) {
				if(in1.equals(in2)) {
					countlist.set(index, countlist.get(index)+1);
				}
			}
			index++;
		}
//		System.out.println(countlist);
		String outstr = "";
		for (Integer integer : countlist) {
			outstr += String.valueOf(integer)+" ";
		}
		outstr = outstr.substring(0, outstr.length()-1);
		System.out.println(outstr);
	}
}
