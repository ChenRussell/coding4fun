package com.nowcoder.campusExam.jd;

import java.util.Scanner;

/**
 * X*Y = N, 输入N, x为奇数，y为偶数，y最小的那个
 */
public class Ttwo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
//            int n = sc.nextInt();
            long n = sc.nextLong();

            if (n %2 == 1) System.out.println("No");
            double sqrt = Math.sqrt(n);
            boolean flag = true;
            for (long k = n; k>0 && flag; k--) {
//                for (int j =1; j<n;  j++) {
//                    if (k % 2 == 1 && j % 2 == 0 && k * j == n) {
//                        System.out.println(k+" "+j);
//                        flag = false;
//                        break;
//                    }
//                }
//                long j = n / k;
                if (n % k == 0 && k % 2 == 1 && n / k % 2 == 0) {
                    System.out.println(k+" "+n/k);
                    break;
                }
            }
        }
    }
}
