package org.cr.campusExam.yixin;

import java.util.Scanner;

/**
 * Created by ChenRui on 18-4-19
 *
 * �����б��1��W��W������ڣ���ÿ�����ڶ���һ�����������ˣ��������ṩN�ִ��ʽ�������������ˣ�
 * ÿ�������˿���ѡ������һ�з�ʽ����������������ڵ������˵Ĵ��ʽһ���� �򽫿��ܲ������ˣ��������״̬
 * ���ܲ������ˣ�
 *
 * ���룺
 * 2 2
 * �����
 * 2
 */
public class Ttwo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int W = sc.nextInt();

//        int res = C(1,W-1) * C(1,N);
        int res = 0;

        for (int i = 1; i <= W - 1; i++) {
            res += C(i, W - 1) * C(1, N);
        }

        System.out.println(res);
    }

    /**
     * ����C(a,b) �Ľ��
     * @param a
     * @param b
     * @return
     */
    private static int C(int a, int b) {
        int res1 = 1;
        int res2 = 1;
        int res3 = 1;
        for (int i = 1; i <= b; i++) {
            res1 = (res1 * i)%100003;
        }
        int c = b - a;
//        if (b-a == 0) res2 = 1;
        if (b - a > 0) {
            for (int i = 1; i <= b - a; i++) {
                res2 = (res2 * i)%100003;
            }
        }

        for (int i = 1; i <= a; i++) {
            res3 = (res3*i)%100003;
        }
        return (res1 / (res2*res3))%100003;
    }
}
