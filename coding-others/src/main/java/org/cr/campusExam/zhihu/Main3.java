package org.cr.campusExam.zhihu;

import java.util.Scanner;

/**
 * ��Ŀ���ƣ���¥��
 * ʱ�����ƣ�1000ms
 * ��Ŀ������������һ��¥�ݣ���������ȳ�����һ������ 1 ���� 2 ��¥�ݣ�
 * ��֪��Ҫ�� n ��¥�ݲ����ߵ����Ŀ��¥�㣬��ʵ��һ���������������ߵ�Ŀ��¥��ķ�������
 * ���������������ο������ǻ���ݴ��������������֣�
 * <p>
 * ������������������n��(1<=n<=50)
 * <p>
 * ��������������������
 * ʾ��1
 * ����
 * 5
 * ���
 * 8
 */
public class Main3 {

    static int count  = 0;
    static void f(int n) {
        if (n == 0) {
            count++;
        } else if (n > 0) {
            f(n - 1);
            f(n - 2);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        f(n);
        System.out.println(count);
    }
}
