package com.nowcoder.campusExam.netease;

import java.util.Scanner;

/**
 * Created by ChenRui on 2018/8/11
 */
public class NTwo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }

        for (int i = 0; i < arr2.length; i++) {
            int sum = 0;
            for (int j = 0; j < arr1.length; j++) {
                sum += arr1[j];
                if (arr2[i] <= sum){
                    System.out.println(j+1);
                    break;
                }
            }
        }
    }
}
