package org.cr.campusExam.byteDance;

import java.util.Scanner;

/**
 * Created by ChenRui on 2018/3/24
 *
 * ��֪������N���߶Ȼ�����ͬ�����壬�տ�ʼ�ڸ߶�Ϊ0�ĵط���ÿ����Ծ����ѡ�����Լ���ǰ�߶Ⱦ���ֵС�ڵ���H�����壬
 * ��Ծ���󵽴�  ������Ϊ��ľ���  λ�ã����������K�ε���������������ߣ�������ʱ�̸߶Ȳ���Ϊ����
 */
public class Tfive {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int H = sc.nextInt();
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int he = 0;
        // �����K��
        for (int i = 0; i < K; i++) {
            int fit = -1;   // ������������������壬�϶���ѡ���ڸ߶ȵ�����
            boolean flag = false;
            for (int j = 0; j < arr.length; j++) {
                if ((arr[j] - he > 0) && (arr[j] - he <= H) && (fit < arr[j])) {
                    fit = arr[j];
                    flag = true;    // �ҵ������õ�����
                }

            }
            if (flag) {
                he = he + (fit-he)*2;
//                System.out.println(he);
            }
        }

        System.out.println(he);
    }
}
