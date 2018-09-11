package com.nowcoder.campusExam.zhihu;

import java.util.Scanner;

public class Main333 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int f1 = 1, f2 = 2;
        int res = 0;
        if (n == 1) res = 1;
        if (n == 2) res = 2;
        for (int i = 3; i<=n;i++) {
            res = f1 + f2;
            f1 = f2;
            f2 = res;
        }
        System.out.println(res);
    }
}
