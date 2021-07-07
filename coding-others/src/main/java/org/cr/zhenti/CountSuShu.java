/**
 * ������ (20)
ʱ������ 1000 ms �ڴ����� 32768 KB ���볤������ 100 KB �жϳ��� Standard (���� СС)
��Ŀ����
��Pi��ʾ��i�����������θ�����������M <= N <= 10000�������PM��PN������������

��������:
������һ���и���M��N������Կո�ָ���


�������:
�����PM��PN������������ÿ10������ռ1�У�����Կո�ָ�������ĩ�����ж���ո�

��������:
5 27

�������:
11 13 17 19 23 29 31 37 41 43

47 53 59 61 67 71 73 79 83 89

97 101 103
 */
package org.cr.zhenti;

import java.util.Scanner;

public class CountSuShu {

	public static boolean checkPrimeNum(int num){
		boolean flag = true;
		for(int i=2;i<=Math.sqrt(num);i++){
			if(num%i==0){
				flag=false;
				break;
			}
		}
		return flag;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a,b;
		a = sc.nextInt();
		b = sc.nextInt();
		int count=0;
		int i=2;
		StringBuffer sb = new StringBuffer();
		int count2 = 0;
		while(true){
			if(checkPrimeNum(i)){
				count++;
				if(count>=a&&count<=b){
					count2++;
					sb.append(String.valueOf(i));
					if(count2%10==0){
						sb.append("\n");
					}else{
						sb.append(" ");
					}
				}
			}
			if(count>b) break;
			i++;
		}
		if(sb.charAt(sb.length()-1)==' ') sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
	}
}
