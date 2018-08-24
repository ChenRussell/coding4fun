package com.nowcoder.campusExam.tencent;

import java.util.Scanner;

/**
 * 背包问题，歌曲总长度为k，有x首长度为a的，y首长度为b的，求有多少种组成方式
 */
public class Ttwo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int a = sc.nextInt();
        int x = sc.nextInt();   // 数量
        int b = sc.nextInt();
        int y = sc.nextInt();

        int count = 0;
//        int arr1[] = new int[x];
//        int arr2[] = new int[y];
//        for (int i = 0; i < x; i++) {
//            arr1[i] = a;
//        }
//        for (int i = 0; i < y; i++) {
//            arr2[i] = b;
//        }

        int len1 = k / a;
        int len2 = k / b;

        for (int h = 0; h < x; h++) {
            for (int l = 0; l < y; l++) {
                for (int i = 0; i <= len1; i++) {
                    for (int j = 0; j <= len2; j++) {

                        int len = a * i + b * j;
                        if (len == k) count++;
                        if (len > k) break;
                    }
                }
            }
        }


        System.out.println(count % 1000000007);
    }
}
