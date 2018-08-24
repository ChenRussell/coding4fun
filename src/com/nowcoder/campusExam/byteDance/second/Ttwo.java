package com.nowcoder.campusExam.byteDance.second;

import java.util.Scanner;

/**
 * 前n1种硬币可以多次选择，后n2种硬币只能选择一次，组成面值为m,一共有多少种方法
 */
public class Ttwo {

    static int f(int weight[], int target, int len) {
        int dp[] = new int[target + 1];
        dp[0] = 1;

        for (int i = 0; i < weight.length - len; i++) {
            for (int j = 1; j < dp.length; j++) {
                if (j>=weight[i]) dp[j] = (dp[j]+dp[j - weight[i]])%1000000007;
            }
        }

        for (int i = weight.length - len; i < weight.length; i++) {
            for (int j = target; j > 0; j--) {
                if (j>=weight[i]) dp[j] = (dp[j]+dp[j - weight[i]])%1000000007;
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int m = sc.nextInt();

        int a[] = new int[n1 + n2];

        for (int i = 0; i < n1; i++) {
            a[i] = sc.nextInt();
//            a[i] = a1[i];
        }
        for (int i = 0; i < n2; i++) {
            a[i+n1] = sc.nextInt();
//            a[i+n1] = a2[i];
        }

//        for (int i = 0; i < a.length; i++) {
//            System.out.println(a[i]);
//        }

        int res = f(a, m, n2);
        System.out.println(res);
    }
}
