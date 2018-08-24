package com.nowcoder.campusExam.jd;

import java.util.Scanner;

/**
 * Created by ChenRui on 18-4-10
 *
 *
 */
public class Ttwo2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if ((n & 1) == 1 || (n & (n - 1)) == 0) {
//            return;
            System.out.println("No");
//            return;
        }

        int y = n - (n & (n - 1));  // 为什么能得到最小被整除的y， 且n/y是奇数
        System.out.println(n/y+" "+y);
    }
}
