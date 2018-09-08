package com.nowcoder.campusExam.meituan.second;

import java.util.Scanner;

public class QujianCount {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int t = sc.nextInt();

        int arr[] = new int[n];
        int count[] = new int[10000];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            count[arr[i]]++;
        }

        int left = 0;
        int right = left + k - 1;
        int result = 0;
        for (int i = 0; i < n && right < n; i++) {
            for (int j = left; j <= right; j++) {
                if (count[arr[j]] >= t) {
                    result++;
                    left++;
                    right++;
                    break;
                }
            }
        }
        System.out.println(result);
    }
}
