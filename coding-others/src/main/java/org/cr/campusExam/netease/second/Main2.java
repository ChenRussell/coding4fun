package org.cr.campusExam.netease.second;

import java.util.Scanner;

public class Main2 {

    public static int min(int n, int k) {
        return 0;
    }

    public static int max(int n, int k) {
        if (n < 3) {
            return 0;
        }
        int a = n - k;
        int t = a + 1;
        if (k <= t-1)
            return k - 1 <= 0 ? 0 : k-1;
        else
            return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            System.out.print(min(n, k));
            System.out.print(" ");
            System.out.println(max(n, k));
        }
    }
}
