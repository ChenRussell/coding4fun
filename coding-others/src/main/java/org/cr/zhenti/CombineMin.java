/**
 * �����С�� (20)
ʱ������ 1000 ms �ڴ����� 32768 KB ���볤������ 100 KB �жϳ��� Standard (���� СС)
��Ŀ����
��������0-9�����ɸ��������������˳��������Щ���֣�������ȫ��ʹ�á�Ŀ����ʹ�����õ�����������С��ע��0��������λ�������磺

��������0������1������5��һ��8�����ǵõ�����С��������10015558��



�ָ������֣����д��������ܹ���ɵ���С������

��������:
ÿ���������1������������ÿ������������һ���и���10���Ǹ�������˳���ʾ����ӵ������0������1����������9�ĸ�������������һ����

��ָ���10�����ֵ��ܸ���������50��������ӵ��1����0�����֡�


�������:
��һ��������ܹ���ɵ���С������

��������:
2 2 0 0 0 3 0 0 1 0

�������:
10015558
 */
package org.cr.zhenti;

import java.util.ArrayList;
import java.util.Scanner;

public class CombineMin {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		int i=0;
		while(true){
			int a = sc.nextInt();
			for(int k=1;k<=a;k++){
				list.add(i);
			}
			i++;
			if(i==10) break;
		}
//		System.out.println(list);
		if(list.get(0)==0){
			for(int j=1;j<list.size();j++){
				if(list.get(j)!=0){
					int temp = list.get(j);
					list.set(j, 0);
					list.set(0,temp);
					break;
				}
			}
		}
//		System.out.println(list.toString());
		String str = "";
		for (Integer in : list) {
			str += String.valueOf(in);
		}
		System.out.println(str);
	}
}
