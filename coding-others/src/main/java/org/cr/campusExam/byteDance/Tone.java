package org.cr.campusExam.byteDance;

import java.util.Scanner;

/**
 * Created by ChenRui on 2018/3/24
 *
 * ���������ַ���������s��m���ٶ������ֲ�����
 * ��һ�ֲ�����
 *  m = s��
 *  s = s+s��
 * �ڶ��ֲ�����
 *  s = s + m��
 *  ����s��m��ʼ�����£�
 *  s = ��a����
 *  m = s��
 *
 *  ����С�Ĳ��������������Խ�sƴ�ӵ����ȵ���n
 */
public class Tone {

    static int min = Integer.MAX_VALUE;
    static void f(int s, int m, int i, int j, int n) {
        if (s == n) {
            if (i+j < min)  min = i+j;
//            System.out.println(i+" "+j);
//            System.out.println(min);
        }else if (s < n){

            f(s * 2, s, i + 1, j, n);
            f(s + m, m, i, j + 1, n);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        f(1,1,0,0,n);
        System.out.println(min);
    }
}
