/**
 * ��ѧ������ (20)
ʱ������ 1000 ms �ڴ����� 32768 KB ���볤������ 100 KB �жϳ��� Standard (���� СС)
��Ŀ����
��ѧ�������ǿ�ѧ��������ʾ�ܴ���С�����ֵ�һ�ַ���ķ�����������������ʽ[+-][1-9]"."[0-9]+E[+-][0-9]+�������ֵ���������

ֻ��1λ��С������������1λ�������ּ���ָ�����ֵ������ż�ʹ������Ҳ�ض���ȷ������



���Կ�ѧ�������ĸ�ʽ����ʵ��A�����д������ͨ���ֱ�ʾ�����A������֤������Чλ����������

��������:
ÿ���������1��������������һ���Կ�ѧ��������ʾ��ʵ��A�������ֵĴ洢���Ȳ�����9999�ֽڣ�����ָ���ľ���ֵ������9999��


�������:
��ÿ��������������һ���а���ͨ���ֱ�ʾ�����A������֤������Чλ��������������ĩβ��0��

��������:
+1.23400E-03

�������:
0.00123400
 */
package org.cr.zhenti;

import java.util.Scanner;

public class ScienceCountMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] split = str.split("E");
		double a = Double.parseDouble(split[0]);
		int tail = Integer.parseInt(split[1]);
		double b = Math.pow(10, tail);
		double result = a*b;
		for(int i=0;i<tail;i++){

		}
		char[] array = split[0].toCharArray();
		int count=0;
		for(int i=array.length-1;i>=0;i--){
			if(array[i]=='0'){
				count++;
			}else{
				break;
			}
		}
		String res = String.valueOf(result);
		//������Ч����
		for(int i=0;i<count;i++){
			res += "0";
		}
		System.out.println(res);

	}

}
