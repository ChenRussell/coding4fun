/**
 * �ھ�������ļ�ǿ(20)
ʱ������ 1000 ms �ڴ����� 32768 KB ���볤������ 100 KB �жϳ��� Standard (���� СС)
��Ŀ����
Ϊ������ʵ˵���ھ�����������ļ�ǿ��PAT��֯��һ���ھ�����ܴ�������������ݱ������ͳ�Ƴ�������ǿ���Ǹ�ѧУ��

��������:
�����ڵ�1�и���������105��������N�����������������N�У�ÿ�и���һλ�����ߵ���Ϣ�ͳɼ����������������ѧУ�ı�ţ���1��ʼ

������ţ�����������ɼ����ٷ��ƣ����м��Կո�ָ���


�������:
��һ���и����ܵ÷���ߵ�ѧУ�ı�š������ܷ֣��м��Կո�ָ�����Ŀ��֤��Ψһ��û�в��С�

��������:
6

3 65

2 80

1 100

2 70

3 40

3 0

�������:
2 150
 */
package org.cr.zhenti;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Wajueji {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for (int i = 0; i < num; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(map.containsKey(a)) {
				map.put(a, b+map.get(a));
			}else {
				map.put(a, b);
			}
		}
//		System.out.println(map);
		int max = -1;
		int key = -1;
		// ����map
		for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
			if(entry.getValue()>max) {
				max = entry.getValue();
				key = entry.getKey();
			}
		}
		System.out.println(key+" "+map.get(key));
	}
}
