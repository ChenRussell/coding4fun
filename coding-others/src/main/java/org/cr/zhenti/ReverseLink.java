/**
 * ��ת���� (25)
ʱ������ 1000 ms �ڴ����� 32768 KB ���볤������ 100 KB �жϳ��� Standard (���� СС)
��Ŀ����
����һ������K�Լ�һ��������L�����д����L��ÿK����㷴ת�����磺����LΪ1��2��3��4��5��6��KΪ3�������Ӧ��Ϊ

3��2��1��6��5��4�����KΪ4�������Ӧ��Ϊ4��3��2��1��5��6������󲻵�K��Ԫ�ز���ת��

��������:
ÿ���������1������������ÿ������������1�и�����1�����ĵ�ַ������ܸ���������N(<= 105)���Լ�������K(<=N)����Ҫ��ת��

�������ĸ��������ĵ�ַ��5λ�Ǹ�������NULL��ַ��-1��ʾ��



��������N�У�ÿ�и�ʽΪ��



Address Data Next



����Address�ǽ���ַ��Data�Ǹý�㱣����������ݣ�Next����һ���ĵ�ַ��


�������:
��ÿ������������˳�������ת�����������ÿ�����ռһ�У���ʽ��������ͬ��

��������:
00100 6 4

00000 4 99999

00100 1 12309

68237 6 -1

33218 3 00000

99999 5 68237

12309 2 33218

�������:
00000 4 33218

33218 3 12309

12309 2 00100

00100 1 99999

99999 5 68237

68237 6 -1
 *
 */
package org.cr.zhenti;

import java.util.Scanner;

public class ReverseLink {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String add = sc.next();		//nextLine()���������ո��ж����룬������Ҫʹ��next()����
		int a = sc.nextInt();
		int b = sc.nextInt();
		String arr[][] = new String[a][3];
//		String arr2[][] = new String[a][3];
		for(int i=0;i<a;i++){
			arr[i][0] = sc.next();
			arr[i][1] = sc.next();
			arr[i][2] = sc.next();
		}
//		for (String[] strings : arr) {
//			System.out.println(strings[0]+" "+strings[1]+" "+strings[2]);
//		}
		int count = 0;
		while(true){
			for(int i=0;i<a;i++){
				if(arr[i][0].equals(add)){
					add = arr[i][2];
					String[] temp = arr[i];
					arr[i] = arr[count];
					arr[count++] = temp;
					break;
				}
			}
			if(add.equals("-1")) break;
		}
//		for (String[] strings : arr2) {
//			System.out.println(strings[0]+" "+strings[1]+" "+strings[2]);
//		}

		for(int i=0,j=b-1;i<b/2;i++,j--){
			String[] temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
//		System.out.println("------------------------------");
//		for (String[] strings : arr) {
//			System.out.println(strings[0]+" "+strings[1]+" "+strings[2]);
//		}
		for(int i=0;i<count;i++){
			System.out.println(arr[i][0]+" "+arr[i][1]+" "+arr[i][2]);
		}




//		Map<String,HashMap<Integer,String>> map = new HashMap<String,HashMap<Integer,String>>();
//		for(int i=0;i<a;i++){
//			String addr = sc.nextLine();
//			int data = sc.nextInt();
//			sc.nextLine();
//			String next = sc.nextLine();
//			map.put(addr, new HashMap<Integer,String>());
//		}
	}
}
