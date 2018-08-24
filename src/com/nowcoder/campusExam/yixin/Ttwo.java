package com.nowcoder.campusExam.yixin;

import java.util.Scanner;

/**
 * Created by ChenRui on 18-4-19
 *
 * 银行有编号1到W的W个贷款窗口，且每个窗口都有一个贷款申请人，现银行提供N种贷款方式供给贷款申请人，
 * 每个申请人可以选择其中一中方式。如果相邻两个窗口的申请人的贷款方式一样， 则将可能产生坏账，求多少种状态
 * 可能产生坏账？
 *
 * 输入：
 * 2 2
 * 输出：
 * 2
 */
public class Ttwo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int W = sc.nextInt();

//        int res = C(1,W-1) * C(1,N);
        int res = 0;

        for (int i = 1; i <= W - 1; i++) {
            res += C(i, W - 1) * C(1, N);
        }

        System.out.println(res);
    }

    /**
     * 计算C(a,b) 的结果
     * @param a
     * @param b
     * @return
     */
    private static int C(int a, int b) {
        int res1 = 1;
        int res2 = 1;
        int res3 = 1;
        for (int i = 1; i <= b; i++) {
            res1 = (res1 * i)%100003;
        }
        int c = b - a;
//        if (b-a == 0) res2 = 1;
        if (b - a > 0) {
            for (int i = 1; i <= b - a; i++) {
                res2 = (res2 * i)%100003;
            }
        }

        for (int i = 1; i <= a; i++) {
            res3 = (res3*i)%100003;
        }
        return (res1 / (res2*res3))%100003;
    }
}
