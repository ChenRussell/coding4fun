/**
 * ��������(25)
ʱ������ 1000 ms �ڴ����� 32768 KB ���볤������ 100 KB �жϳ��� Standard (���� СС)
��Ŀ����
����һ�����������У���������p������������е����ֵ��M����Сֵ��m�����M <= m * p���������������������С�



���ڸ�������p��һЩ���������������ѡ�񾡿��ܶ��������һ���������С�

��������:
�����һ�и�������������N��p������N��<= 105����������������ĸ�����p��<= 109���Ǹ����Ĳ������ڶ��и���N����������ÿ����

������109��


�������:
��һ�������������ѡ����ٸ����������������һ���������С�

��������:
10 8

2 3 20 4 5 1 6 7 8 9

�������:
8
 */
package org.cr.zhenti;

import java.util.Arrays;
import java.util.Scanner;

public class PerfectArrayListV2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		// ctr+shift+o ��ݼ������,������ȥ�����õİ�Ӵ
		int num = sc.nextInt();
		int p = sc.nextInt();
		int[] arr = new int[num];
		for (int i = 0; i < num; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int maxLen = 0;

		//˼·��arr[i]��arr[j]֮��ľ���maxLenֻ�����ӣ��������
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + maxLen; j < arr.length; j++) {
				if(arr[i]*p < arr[j]) break;
				maxLen ++;
			}
		}
		System.out.println(maxLen);
	}
}
