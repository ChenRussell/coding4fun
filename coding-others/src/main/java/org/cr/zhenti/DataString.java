/**
 *��Ŀ������
 * ʱ�����ƣ�1�� �ռ����ƣ�32768K �ȶ�ָ����23713
 �㷨֪ʶ��Ƶ����
��Ŀ����
����n�������������������ӳ�һ�ţ����һ�����Ķ�λ������
��:n=3ʱ��3������13,312,343,���ɵ��������Ϊ34331213��
��:n=4ʱ,4������7,13,4,246���ӳɵ��������Ϊ7424613��
��������:
�ж������������ÿ����������������У���һ��Ϊһ������N��N<=100�����ڶ��а���N����(ÿ����������1000���ո�ֿ�)��
�������:
ÿ���������һ����ʾ����������
ʾ��1
����

2
12 123
4
7 13 4 246
���

12312
7424613
 */
package org.cr.zhenti;

import java.util.Scanner;

public class DataString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
			n = sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++){
				arr[i] = sc.nextInt();
			}
			int temp;
			// ѡ������
			for(int i=0;i<n;i++){
				int max = i;
				for(int j=i+1;j<n;j++){
					//���������ٱȽ�
					if((String.valueOf(arr[max])+(String.valueOf(arr[j]))).compareTo((String.valueOf(arr[j])+String.valueOf(arr[max])))<0){
						max = j;	//��¼���ֵ��λ��
					}
				}
				temp = arr[i];
				arr[i] = arr[max];
				arr[max] = temp;
			}
		String str = "";
		for(int i=0; i<n;i++){
			str += String.valueOf(arr[i]);
		}
		System.out.println(str);
	}

	public static boolean compare(int a, int b){
		if(a == b) return true;

		if(divide(a)>divide(b)){
			return true;
		}
		else if(divide(a) == divide(b)){
			return compare(fuck(a),fuck(b));
		}
		else{
			return false;
		}
	}

	public static int divide(int a){
		if(a/10 == 0){
			return a;
		}else{
			return divide(a/10);
		}
	}

	public static int fuck(int a){
		int a2=a;
		int s = 1;
		int count = 0;
		while(a/10!=0){
			a = a/10;
			count++;
		}
		while(count>0){
			s = s*10;
			count--;
		}
		return a2%s;
	}
}
