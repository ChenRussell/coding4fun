package org.cr.campusExam.netease.second;

import java.util.Scanner;

/**
 * 不需要进行遍历
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            boolean arr[][] = new boolean[n][m];

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    arr[j][k] = !arr[j][k];
                    if (j-1 >= 0) arr[j-1][k] = !arr[j-1][k];
                    if (j+1 < n) arr[j+1][k] = !arr[j+1][k];
                    if (k-1 >=0) arr[j][k - 1] = !arr[j][k - 1];
                    if (k+1 < m) arr[j][k + 1] = !arr[j][k + 1];
                    if (j-1 >= 0 && k-1 >=0) arr[j - 1][k - 1] = !arr[j - 1][k - 1];
                    if (j-1 >= 0 && k+1 < m) arr[j - 1][k + 1] = !arr[j - 1][k + 1];
                    if (j+1 < n && k-1 >= 0) arr[j + 1][k - 1] = !arr[j + 1][k - 1];
                    if (j+1 < n && k+1 < m) arr[j + 1][k + 1] = !arr[j + 1][k + 1];
                }
            }
            int count = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (arr[j][k]) count++;
                }
            }
            System.out.println(count);
        }
    }
}
