package com.nowcoder.campusExam.byteDance.second;

import java.util.Scanner;

public class Tfive {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            if (c > Math.max(a, b)) {
                System.out.println(0);
            }

            if (2 * a - b == c) {
                System.out.println(4);
            }
        }
    }
}
