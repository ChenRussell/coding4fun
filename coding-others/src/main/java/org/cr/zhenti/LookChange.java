/**
 * �ڻ����ִ�����Ǯ��20��
ʱ������ 1000 ms �ڴ����� 32768 KB ���볤������ 100 KB �жϳ��� Standard (���� СС)
��Ŀ����
������ǹ����������ԣ����֪��ħ�����������Լ��Ļ���ϵͳ ���� ���纣����߹����ģ���ʮ�߸�������(Sickle)��һ����¡(Galleon)����

ʮ�Ÿ�����(Knut)��һ�����ɣ������ס������ڣ���������Ӧ���ļ�ǮP����ʵ����ǮA�����������дһ��������������Ӧ�ñ��ҵ���Ǯ��

��������:
������1���зֱ����P��A����ʽΪ��Galleon.Sickle.Knut���������1���ո�ָ�������Galleon��[0, 107]]�����ڵ�������Sickle��[0,

17)�����ڵ�������Knut��[0, 29)�����ڵ�������


�������:
��һ������������ͬ���ĸ�ʽ�������Ӧ�ñ��ҵ���Ǯ�������û����Ǯ����ô�����Ӧ���Ǹ�����

��������:
10.16.27 14.1.28

�������:
3.2.1
 */
package org.cr.zhenti;

import java.util.Scanner;

public class LookChange {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();

		String[] spl1 = str1.split("\\.");	// ����Ϊ������ʽ
		String[] spl2 = str2.split("\\.");
//		System.out.println(spl1[0] +" "+ spl1[1]+" "+spl1[2]);
//		System.out.println(spl2[0] +" "+ spl2[1]+" "+spl2[2]);
		int g1 = Integer.parseInt(spl1[0]);
		int s1 = Integer.parseInt(spl1[1]);
		int k1 = Integer.parseInt(spl1[2]);

		int g2 = Integer.parseInt(spl2[0]);
		int s2 = Integer.parseInt(spl2[1]);
		int k2 = Integer.parseInt(spl2[2]);

		int total1 = g1*17*29 + s1*29 + k1;
		int total2 = g2*17*29 + s2*29 + k2;
		int change = total2 - total1;
		if(change<0) {
			change = -change;
			System.out.print("-");
		}
		int g = change / 493;
		int k = change % 29;
		int s = change / 29 % 17;
		System.out.println(g+"."+s+"."+k);

	}
}
