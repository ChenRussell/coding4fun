/**
 * ��������(25)
ʱ������ 1000 ms �ڴ����� 32768 KB ���볤������ 100 KB �жϳ��� Standard (���� СС)
��Ŀ����
����һ�����������У���������p������������е����ֵ��M����Сֵ��m�����M <= m * p���������������������С�



���ڸ�������p��һЩ���������������ѡ�񾡿��ܶ��������һ���������С�

��������:
�����һ�и�������������N��p������N��<= 105����������������ĸ�����p��<= 109���Ǹ����Ĳ������ڶ��и���N����������ÿ����

������109��


�������:
��һ�������������ѡ����ٸ����������������һ���������С�

��������:
10 8

2 3 20 4 5 1 6 7 8 9

�������:
8
 */
package org.cr.zhenti;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PerfectArrayList {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		// ctr+shift+o ��ݼ������
		int num = sc.nextInt();
		int p = sc.nextInt();
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < num; i++) {
			list.add(sc.nextInt());
		}
		Collections.sort(list);
		while(true) {
//			System.out.println(list);
			if(list.get(list.size()-1)<=list.get(0)*p) break;
			Integer temp = list.get(list.size()-1);
			list.remove(list.size()-1);
			int a = list.get(0)*p - list.get(list.size()-1);
			if(list.get(list.size()-1)<=list.get(0)*p) break;
			else list.add(temp);
			Integer temp0 = list.get(0);
			list.remove(0);
			int b = list.get(0)*p - list.get(list.size()-1);
			if(list.get(list.size()-1)<=list.get(0)*p) break;
			else list.add(temp0);
			Collections.sort(list);
			if(a<b) list.remove(temp0);
			else list.remove(temp);
		}
		System.out.println(list.size());
	}
}
