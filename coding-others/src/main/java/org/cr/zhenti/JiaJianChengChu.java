/**
 * ��������������(20)
ʱ������ 1000 ms �ڴ����� 32768 KB ���볤������ 100 KB �жϳ��� Standard (���� СС)
��Ŀ����
����Ҫ���д���򣬼���2���������ĺ͡�������̡�

��������:
������һ���а��ա�a1/b1 a2/b2���ĸ�ʽ��������������ʽ�������������з��Ӻͷ�ĸȫ�����ͷ�Χ�ڵ�����������ֻ���ܳ����ڷ���ǰ����

ĸ��Ϊ0��


�������:
�ֱ���4���а��ա�������1 ����� ������2 = ������ĸ�ʽ˳�����2���������ĺ͡�������̡�ע�������ÿ�������������Ǹ���������

�����ʽ��k a/b��������k���������֣�a/b�����������֣���Ϊ��������������ţ���������ĸΪ0���������Inf������Ŀ��֤��ȷ�������

û�г������ͷ�Χ��������

��������:
5/3 0/6

�������:
1 2/3 + 0 = 1 2/3

1 2/3 - 0 = 1 2/3

1 2/3 * 0 = 0

1 2/3 / 0 = Inf
 */
package org.cr.zhenti;

import java.util.Scanner;

public class JiaJianChengChu {

	//���ַ���ת��
	public static String fuck(String str) {
		String[] sp = str.split("/");
		if(sp[0].equals("0")) return "0";
		if(sp[0].compareTo(sp[1])<0) return str;
		else if(sp[0].compareTo(sp[1])==0) return "1";
		else return Integer.parseInt(sp[0])/Integer.parseInt(sp[1])+" "+(Integer.parseInt(sp[0])-Integer.parseInt(sp[1]))+"/"+sp[1];
	}
	public static void main(String[] args) {
		System.out.println(fuck("5/3"));
		Scanner sc = new Scanner(System.in);
	}
}
