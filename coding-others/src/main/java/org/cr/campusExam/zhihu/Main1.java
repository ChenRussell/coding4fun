package org.cr.campusExam.zhihu;

import java.util.Scanner;

/**
 * ��Ŀ���ƣ��ǽ�������
 * ʱ�����ƣ�1000ms
 * ��Ŀ������дһ�����������������ǽ�����������飨A, B������ A, B �ϲ���һ���ǽ������� C��
 * ���� C����Ҫʹ������ sort �����������������������ο������ǻ���ݴ��������������֣�
 * <p>
 * ������������һ��������������n,m����1<=n,m<=100000���ֱ��ʾ����A,B�Ĵ�С��
 * �ڶ��и���n������a��(1<=a<=10000)
 * �����и���m������b��(1<=b<=10000)
 * <p>
 * �������������ϲ�֮������õ����顣
 * ʾ��1
 * ����
 * 3 3
 * 1 9 10
 * 3 12 41
 * ���
 * 1 3 9 10 12 41
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr1[] = new int[n];
        int arr2[] = new int[m];

        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }

        int[] res = new int[n + m];

        int i = 0, j = 0, k=0;
        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) {
                res[k++] = arr1[i++];
            } else {
                res[k++] = arr2[j++];
            }
        }
        while (i < n) {
            res[k++] = arr1[i++];
        }
        while (j < m) {
            res[k++] = arr2[j++];
        }

        for (int re : res) {
            System.out.print(re+" ");
        }
    }
}
