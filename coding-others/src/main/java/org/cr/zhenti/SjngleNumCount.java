/**
 * ��λ��ͳ�� (15)
ʱ������ 1000 ms �ڴ����� 32768 KB ���볤������ 100 KB �жϳ��� Standard (���� СС)
��Ŀ����
����һ��kλ����N = dk-1*10k-1 + ... + d1*101 + d0 (0<=di<=9, i=0,...,k-1, dk-1>0)�����д����ͳ��ÿ�ֲ�ͬ�ĸ�λ���ֳ��ֵĴ��������磺����N = 100311������2��0��3��1����1��3��

��������:
ÿ���������1��������������һ��������1000λ��������N��


�������:
��N��ÿһ�ֲ�ͬ�ĸ�λ���֣���D:M�ĸ�ʽ��һ���������λ����D������N�г��ֵĴ���M��Ҫ��D�����������

��������:
100311

�������:
0:2

1:3

3:1
 */
package org.cr.zhenti;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class SjngleNumCount {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String num = sc.nextLine();
		char[] array = num.toCharArray();
		Map<Character,Integer> map = new TreeMap<Character,Integer>();	//Ĭ�ϸ���key��������
		for (char c : array) {
			if(map.containsKey(c)){
				map.put(c, map.get(c)+1);
			}else{
				map.put(c, 1);
			}
		}
		System.out.println(map.entrySet());
		//����map
		Set<Character> keySet = map.keySet();
        Iterator<Character> iter = keySet.iterator();
        while (iter.hasNext()) {
            char key = (char) iter.next();
            System.out.println(key + ":" + map.get(key));
        }
	}
}
