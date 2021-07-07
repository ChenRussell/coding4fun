/**
 * 1019. ���ֺڶ� (20)
ʱ������ 1000 ms �ڴ����� 32768 KB ���볤������ 100 KB �жϳ��� Standard (���� СС)
��Ŀ����
������һ����λ���ֲ���ȫ��ͬ��4λ����������������Ȱ�4�����ְ��ǵ��������ٰ��ǵݼ�����Ȼ���õ�1�����ּ���2�����֣����õ�
 һ���µ����֡�һֱ�ظ������������Ǻܿ��ͣ���С����ֺڶ���֮�Ƶ�6174��������������Ҳ��Kaprekar������

 ���磬���Ǵ�6767��ʼ�����õ�

 7766 - 6677 = 1089
 9810 - 0189 = 9621
 9621 - 1269 = 8352
 8532 - 2358 = 6174
 7641 - 1467 = 6174
 ... ...

 �ָ�������4λ�����������д������ʾ����ڶ��Ĺ��̡�

��������:
�������һ��(0, 10000)�����ڵ�������N��


�������:
���N��4λ����ȫ��ȣ�����һ���������N - N = 0000�������򽫼����ÿһ����һ���������ֱ��6174��Ϊ����֣������ʽ������,ÿ���м�û�п��С�ע��ÿ�����ְ�4λ����
 ʽ�����

��������:
6767

�������:
7766 - 6677 = 1089
 9810 - 0189 = 9621
 9621 - 1269 = 8352
 8532 - 2358 = 6174
 *
 */
package org.cr.zhenti;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class NumberBackHole {

	public static int increase(int num){
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<4;i++){
			list.add(num%10);
			num = num/10;
		}
		Collections.sort(list);   //��������
		int result=0;
		for (Integer n : list) {
			result = result*10 + n;
		}
		return result;
	}

	public static int decrease(int num){
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<4;i++){
			list.add(num%10);
			num = num/10;
		}
		Collections.sort(list, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2-o1;
			}

		});;   //�ݼ�����
		int result=0;
		for (Integer n : list) {
			result = result*10 + n;
		}
		return result;
	}

	//ת��Ϊ�ַ���
	public static String str(int num){
		String str = String.valueOf(num);
		if(str.length()==1){
			str="000"+str;
		}
		else if(str.length()==2){
			str="00"+str;
		}
		else if(str.length()==3){
			str="0"+str;
		}
		return str;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		int num1 = increase(number);
		int num2 = decrease(number);
//		System.out.println(num1+","+num2);
		while(true){
			if(num2==num1){
				System.out.println(str(num2)+" - "+str(num1)+" = "+"0000");
				break;
			}
			if(num2-num1!=6174){
				System.out.println(str(num2)+" - "+str(num1)+" = "+(num2-num1));
			}else{
				System.out.println(str(num2)+" - "+str(num1)+" = "+(num2-num1));
				break;
			}
			int t = num1;
			num1 = increase(num2-num1);
			num2 = decrease(num2-t);
		}
	}

}
