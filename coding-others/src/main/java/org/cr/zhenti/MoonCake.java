/**
 * �±� (25)
ʱ������ 1000 ms �ڴ����� 32768 KB ���볤������ 100 KB �жϳ��� Standard (���� СС)
��Ŀ����
�±����й���������ѽ�ʱ�Ե�һ�ִ�ͳʳƷ����ͬ��������಻ͬ��ζ���±����ָ������������±��Ŀ���������ۼۡ��Լ��г��������

���������������Ի�õ���������Ƕ��١�



ע�⣺����ʱ����ȡ��һ���ֿ�档���������������������ģ�����������3���±����������ֱ�Ϊ18��15��10��֣����ۼ۷ֱ�Ϊ75��

72��45��Ԫ������г������������ֻ��20��֣���ô��������������Ӧ��������ȫ��15��ֵ�2���±����Լ�5��ֵ�3���±������

 72 + 45/2 = 94.5����Ԫ����

��������:
ÿ���������1������������ÿ�����������ȸ���һ��������1000��������N��ʾ�±������������Լ�������500�������Ϊ��λ����������

D��ʾ�г���������������һ�и���N��������ʾÿ���±��Ŀ�����������Ϊ��λ�������һ�и���N��������ʾÿ���±������ۼۣ�����

ԪΪ��λ�������ּ��Կո�ָ���


�������:
��ÿ�������������һ�������������棬����ԪΪ��λ����ȷ��С�����2λ��

��������:
3 20

18 15 10

75 72 45

�������:
94.50
 */
package org.cr.zhenti;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MoonCake {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int category,demand;
		double result = 0;
		category = sc.nextInt();
		demand = sc.nextInt();
		List<Integer> list1 = new ArrayList<Integer>();//�洢ÿ���±��Ŀ����
		List<Integer> list2 = new ArrayList<Integer>();//�洢ÿ���±������ۼ�
		List<Double> list3 = new ArrayList<Double>();//�洢ÿ���±��ĵ���
		for(int i=0;i<category;i++){
			list1.add(sc.nextInt());
		}
		for(int i=0;i<category;i++){
			list2.add(sc.nextInt());
		}
		for(int i=0;i<list1.size();i++){
			list3.add((double)(list2.get(i))/list1.get(i));
		}
		System.out.println(list3);
		while(true){
			double max = -1;
			int index = -1;
			for(int i=0;i<list3.size();i++){
				if(list3.get(i)>max) {
					max = list3.get(i);
					index = i;
				}
			}
//			list3.remove(index);
			if(list1.get(index)>demand){
				result = result + list3.get(index)*demand;
				break;
			}else{
				result = result + list2.get(index);
				demand = demand - list1.get(index);
			}
			list1.remove(index);
			list2.remove(index);
			list3.remove(index);
			if(list1.size()==0){
				break;
			}
		}
		java.text.DecimalFormat   df   =new   java.text.DecimalFormat("#.00");  //������λС��
//		df.format(result);
		System.out.println(df.format(result));
	}
}
