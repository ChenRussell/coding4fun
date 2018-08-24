package com.nowcoder.campusExam.netease;

import java.util.Scanner;

/**
 * Created by ChenRui on 2018/8/11
 */
public class Ntwo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
            if (i > 0) {
                arr[i] = arr[i - 1] + arr[i];
            }
        }

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int value = sc.nextInt();
            int left = 0;
            int right = arr.length - 1;
            while (left <= right) {
                int middle = (left + right) / 2;
                if (arr[middle] >= value && ((middle > 0 && arr[middle - 1] < value) || middle == 0)) {
                    System.out.println(middle + 1);
                    break;
                } else if (arr[middle] > value) {
                    right = middle - 1;
                } else if (arr[middle] < value) {
                    left = middle + 1;
                }
            }
        }
    }

}
