package org.cr.zhenti;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class DataStringv2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

			while (in.hasNext()){
			            int n = in.nextInt();
			            ArrayList<Integer> als = new ArrayList<Integer>();
			            for (int i = 0; i < n; i++) {
			                 als.add(in.nextInt());
			            }
//			            Collections.sort(als);
//			            Collections.sort(als, new Comparator<Integer>() {
//
//							@Override
//							public int compare(Integer o1, Integer o2) {
//								// TODO Auto-generated method stub
//								return 0;
//							}
//
//						});
			            //����sort���򣬲����Լ�д������дһ���������
			            als.sort(new Comparator<Integer>() {
			                @Override
			                public int compare(Integer o1, Integer o2) {
			                    String a = String.valueOf(o1);
			                    String b = String.valueOf(o2);
			                    return (b + a).compareTo(a + b);	//������Ҫ��������Ĭ����˳����
			                }
			            });

			            for (Integer i:
			                 als) {
			                System.out.print(i);
			            }
			            System.out.println();
			        }
	}
}
