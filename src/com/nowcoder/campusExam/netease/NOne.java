package com.nowcoder.campusExam.netease;

import java.util.Scanner;

/**
 * Created by ChenRui on 2018/8/11
 */
public class NOne {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr1[] = new int[n];
        int arr2[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt();
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (arr2[i] == 1) {
                sum += arr1[i];
            }
        }
        int max =0;
        for (int i = 0; i < n; i++) {
            if (arr2[i] == 0 ) {
                int num =sum;
                for (int j = i; j < Math.min(i+k,n); j++) {
                    if(arr2[j]==0) num+=arr1[j];
                }
                max = Math.max(max, num);

            }
        }
        System.out.println(max);
    }
}