package org.cr.zhenti;

import java.util.Scanner;

public class ScannerTest {

	public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("������������䣺");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.println("���������������");
        String name = sc.nextLine();
        /**
         * next()���������ܿո�nextLine()���������ջس���
         */
        String name2 = sc.nextLine();
        System.out.println("��������Ĺ��ʣ�");
        float salary = sc.nextFloat();
        System.out.println("�����Ϣ���£�");
        System.out.println("������"+name+"\n"+name2+"\n"+"���䣺"+age+"\n"+"���ʣ�"+salary);
}
}
