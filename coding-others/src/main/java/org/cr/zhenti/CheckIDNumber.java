/**
 * 1031. �������֤(15)
ʱ������ 1000 ms �ڴ����� 32768 KB ���볤������ 100 KB �жϳ��� Standard (���� СС)
��Ŀ����
һ���Ϸ������֤������17λ���������ڱ�ź�˳���ż�1λУ������ɡ�У����ļ���������£�



���ȶ�ǰ17λ���ּ�Ȩ��ͣ�Ȩ�ط���Ϊ��{7��9��10��5��8��4��2��1��6��3��7��9��10��5��8��4��2}��Ȼ�󽫼���ĺͶ�11ȡģ��

��ֵZ����������¹�ϵ��ӦZֵ��У����M��ֵ��



Z��0 1 2 3 4 5 6 7 8 9 10

M��1 0 X 9 8 7 6 5 4 3 2



���ڸ���һЩ���֤���룬������֤У�������Ч�ԣ������������ĺ��롣

��������:
�����һ�и���������N��<= 100������������֤����ĸ��������N�У�ÿ�и���1��18λ���֤���롣


�������:
���������˳��ÿ�����1������������֤���롣���ﲢ������ǰ17λ�Ƿ����ֻ���ǰ17λ�Ƿ�ȫΪ���������1λУ�������׼ȷ��������к��붼������

�������All passed����

��������:
4

320124198808240056

12010X198901011234

110108196711301866

37070419881216001X

�������:
12010X198901011234

110108196711301866

37070419881216001X
 */
package org.cr.zhenti;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CheckIDNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		List<String> list = new ArrayList<String>();
		List<String> listNew = new ArrayList<String>();
		List<String> listIll = new ArrayList<String>();
		for (int i = 0; i < num; i++) {
			list.add(sc.next());
		}
		//�ж�ǰ17λ���Ƿ�����ĸ
		for (String str : list) {
			if(str.length()!=18) {
				listIll.add(str);
				continue;
			}
			char[] arr = str.toCharArray();
			boolean flag = true;
			for (int i = 0; i < arr.length-1; i++) {
				if(arr[i]<'0' || arr[i]>'9') {
					listIll.add(str);
					flag = false;
					break;
				}
			}
			if(flag) listNew.add(str);
		}
		if(listIll.size()==num) {
			for (String str : listIll) {
				System.out.println(str);
			}
			return;
		}
		//�ж����һλ�Ƿ�Ϸ�
		int wei[] = new int[] {7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2};
		char mode[] = new char[] {'1' ,'0' ,'X' ,'9' ,'8' ,'7' ,'6' ,'5' ,'4', '3' ,'2'};
		for (String str : listNew) {
			char[] arr = str.toCharArray();
			int sum = 0;
			//���Ȩ��
			for (int i = 0; i < arr.length - 1; i++) {
				sum += wei[i]*Integer.parseInt(String.valueOf(arr[i]));
			}
			int mod = sum%11;
			if(mode[mod] != arr[arr.length-1]) {
				listIll.add(str);
			}
		}
		if(listIll.size()==0) {
			System.out.println("All passed");
			return;
		}
		for (String string : listIll) {
			System.out.println(string);
		}
	}
}
