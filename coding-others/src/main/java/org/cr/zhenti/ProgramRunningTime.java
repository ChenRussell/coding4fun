/**
 * ��������ʱ��(15)
ʱ������ 1000 ms �ڴ����� 32768 KB ���볤������ 100 KB �жϳ��� Standard (���� СС)
��Ŀ����
Ҫ���һ��C���Գ��������ʱ�䣬���õķ����ǵ���ͷ�ļ�time.h�������ṩ��clock()���������Բ�׽�ӳ���ʼ���е�clock()������ʱ��

�ķѵ�ʱ�䡣���ʱ�䵥λ��clock tick������ʱ�Ӵ�㡱��ͬʱ����һ������CLK_TCK�������˻���ʱ��ÿ�����ߵ�ʱ�Ӵ����������Ϊ�˻�

��һ������f������ʱ�䣬����ֻҪ�ڵ���f֮ǰ�ȵ���clock()�����һ��ʱ�Ӵ����C1����fִ����ɺ��ٵ���clock()�������һ��ʱ�Ӵ��

��C2�����λ�õ�ʱ�Ӵ����֮��(C2-C1)����f���������ĵ�ʱ�Ӵ�������ٳ��Գ���CLK_TCK���͵õ�������Ϊ��λ������ʱ�䡣



���ﲻ���򵥼��賣��CLK_TCKΪ100���ָ������⺯��ǰ�����λ�õ�ʱ�Ӵ����������������⺯�����е�ʱ�䡣

��������:
������һ����˳�����2������C1��C1��ע�����λ�õ�ʱ�Ӵ�����϶�����ͬ����C1 < C2������ȡֵ��[0, 107]


�������:
��һ����������⺯�����е�ʱ�䡣����ʱ����밴�ա�hh:mm:ss������2λ�ġ�ʱ:��:�롱����ʽ���������1���ʱ���������뵽�롣

��������:
123 4577973

�������:
12:42:59
 */
package org.cr.zhenti;

import java.util.Scanner;

public class ProgramRunningTime {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		long a1 = Math.round(a/100.0);
		long b1 = Math.round(b/100.0);
//		System.out.println(a1+" "+b1);
		long c = Math.round((b-a)/100);
		long c1 = c;
		if(c<60) c1 = 0;
		while(true){
			if(c<60){
				break;
			}
			c = c%60;
			c1 = c1/60;
		}
		long c2 =c1;
		if(c1<60) c2 = 0;
		while(true){
			if(c1<60) break;
			c1 = c1 % 60;
			c2 = c2 / 60;
		}
//		System.out.println(c);
//		System.out.println(c1);
		String str = String.valueOf(c);
		String str1 = String.valueOf(c1);
		String str2 = String.valueOf(c2);
		if(str.length()<2) str = "0"+str;
		if(str1.length()<2) str1 = "0"+str1;
		if(str2.length()<2) str2 = "0"+str2;
		System.out.println(str2+":"+str1+":"+str);
	}
}
