/**
 * ��������20��
ʱ������ 1000 ms �ڴ����� 32768 KB ���볤������ 100 KB �жϳ��� Standard (���� СС)
��Ŀ����
С������Щ������һ���Լ�ϲ�����鴮�������ӵ�̯���кܶമ������ɫ���鴮�����ǲ��ϰ��κ�һ����ɢ����������С��Ҫ���æ�ж�һ

�£�ĳ���������Ƿ������ȫ���Լ���Ҫ�����ӣ�����ǣ���ô�������ж��ٶ�������ӣ�������ǣ���ô������ȱ�˶������ӡ�



Ϊ���������������[0-9]��[a-z]��[A-Z]��Χ�ڵ��ַ�����ʾ��ɫ�����磬YrR8RrY��С���������鴮����ôppRYYGrrYBR2258��������Ϊ������

ȫ������Ҫ�����ӣ�������8�Ų���Ҫ�����ӣ�ppRYYGrrYB225��������Ϊû�к�ɫ���ӣ���������һ�ź�ɫ�����ӡ�

��������:
ÿ���������1������������ÿ�����������ֱ���2�����Ⱥ����̯�����鴮��С���������鴮��������������1000�����ӡ�


�������:
�������������һ���������Yes���Լ��ж��ٶ�������ӣ����������������һ���������No���Լ�ȱ�˶������ӡ������1���ո�ָ���

��������:
ppRYYGrrYBR2258

YrR8RrY

�������:
Yes 8
 */
package org.cr.zhenti;

import java.util.Scanner;

public class BuyOrNot {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		char[] arr = str2.toCharArray();
		int count = 0;
		boolean flag = true;

		for (char c : arr) {
			if(str1.contains(String.valueOf(c))) {
				str1 = str1.replaceFirst(String.valueOf(c), "");
				count++;
			}else {
				flag = false;
			}
		}
		if(flag) {
			System.out.println("Yes "+(str1.length()-str2.length()));
		}else {
			System.out.println("No "+(str2.length()-count));
		}
	}
}