package com.nowcoder.campusExam.byteDance;

import java.util.Scanner;

/**
 * Created by ChenRui on 2018/3/24
 *
 * 在n个元素的数组中， 找到差值为k的数字对去重后的个数
 */
public class Ttwo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        int count = 0;
        boolean arr2[][] = new boolean[100][100];    // 用set保存
//        System.out.println(arr2[0][0]);

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i] - arr[j] == k) {
                    arr2[arr[i]][arr[j]] = true;
                 }
            }
        }

        for (int i = 0; i < arr2[0].length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                if (arr2[i][j]) count++;
            }
        }

        System.out.println(count);
    }
}
