/**
 * ����һϵ�����������밴Ҫ������ֽ��з��࣬���������5�����֣�



A1 = �ܱ�5����������������ż���ĺͣ�

A2 = ����5������1�����ְ�����˳����н�����ͣ�������n1-n2+n3-n4...��

A3 = ��5������2�����ֵĸ�����

A4 = ��5������3�����ֵ�ƽ��������ȷ��С�����1λ��

A5 = ��5������4��������������֡�

��������:
ÿ���������1������������ÿ�����������ȸ���һ��������1000��������N��������N��������1000�Ĵ�����������������ּ��Կո�ָ���


�������:
�Ը�����N��������������ĿҪ�����A1~A5����һ����˳����������ּ��Կո�ָ�������ĩ�����ж���ո�

������ĳһ�����ֲ����ڣ�������Ӧλ�������N����

��������:
13 1 2 3 4 5 6 7 8 9 10 20 16 18

�������:
30 11 2 9.7 9
 */
package org.cr.zhenti;

import java.text.DecimalFormat;
import java.util.Scanner;

public class NumClassfication {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		Integer arr[] = new Integer[num];
		//��ȡ��������
		for(int i = 0;i < num;i++){
			arr[i] = sc.nextInt();
		}
		int a1=0,a2=0,a3=0,a5=0;
		boolean b1=false,b2=false,b3=false,b4=false,b5=false;
		float a4=0;
		boolean flag = true;
		int count=0;
		int max=Integer.MIN_VALUE;
		DecimalFormat df = new DecimalFormat("0.0");
		for(int i=0;i<num;i++){
			//��A1
			if(arr[i]%5==0 && arr[i]%2==0){
				a1+=arr[i];
				b1=true;
			}
			//��A2
			if(arr[i]%5==1){
				b2=true;
				if(flag){
					a2 += arr[i];
					flag=false;
				}else{
					a2 -= arr[i];
					flag=true;
				}
			}
			//��A3
			if(arr[i]%5==2){
				b3=true;
				a3++;
			}
			//��A4
			if(arr[i]%5==3){
				b4=true;
				a4 += arr[i];
				count++;
				}
			//��A5
			if(arr[i]%5==4){
				b5=true;
				if(arr[i]>max){
					max = arr[i];
				}
			}
		}
		a4 = a4/count;
		String s1 = String.valueOf(a1);
		String s2 = String.valueOf(a2);
		String s3 = String.valueOf(a3);
		String s4 = df.format(a4);
		String s5 = String.valueOf(max);
		if(!b1) s1="N";
		if(!b2) s2="N";
		if(!b3) s3="N";
		if(!b4) s4="N";
		if(!b5) s5="N";
		System.out.println(s1+" "+s2+" "+s3+" "+s4+" "+s5);
	}
}
