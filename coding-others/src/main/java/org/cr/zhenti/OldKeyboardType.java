/**
 * �ɼ��̴���(20)
ʱ������ 1000 ms �ڴ����� 32768 KB ���볤������ 100 KB �жϳ��� Standard (���� СС)
��Ŀ����
�ɼ����ϻ��˼���������������һ�����ֵ�ʱ�򣬶�Ӧ���ַ��Ͳ�����֡����ڸ���Ӧ�������һ�����֡��Լ���������Щ��������Ľ����

�ֻ���������

��������:
������2���зֱ������������Щ�����Լ�Ӧ����������֡����ж�ӦӢ����ĸ�Ļ����Դ�д������ÿ�������ǲ�����10^5���ַ��Ĵ������õ�

�ַ�������ĸ[a-z, A-Z]������0-9���Լ��»��ߡ�_��������ո񣩡���,������.������-������+���������ϵ���������Ŀ��֤��2����������ִ��ǿա�



ע�⣺����ϵ��������ˣ���ô��д��Ӣ����ĸ�޷��������


�������:
��һ��������ܹ�������Ľ�����֡����û��һ���ַ��ܱ��������������С�

��������:
7+IE.

7_This_is_a_test.

�������:
_hs_s_a_tst
 */
package org.cr.zhenti;

import java.util.Scanner;

public class OldKeyboardType {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();	// nextLine()�ᱻ�ջس��ַ�Ӱ��
		String str2 = sc.next();
//		System.out.println(str1+" "+str2);
		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();
		for (char c : arr1) {
			if(c!='+') {
				if(c=='.') {
					str2.replaceAll("\\.", "");// �ԡ�.�� ת�� ��(valid ones are  \b  \t  \n  \f  \r  \"  \'  \\ )
					continue;
				}
				if(str2.contains(String.valueOf(c))||str2.contains(String.valueOf(c).toLowerCase())) {
					str2 = str2.replaceAll(String.valueOf(c), "");
					str2 = str2.replaceAll(String.valueOf(c).toLowerCase(), "");
				}
			}
			else {
				for (char c1 : arr2) {
					if(c1>='A' && c1<='Z') {
						str2 = str2.replaceAll(String.valueOf(c1), "");
					}
				}
			}
		}
		System.out.println(str2);
	}
}
