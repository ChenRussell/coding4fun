package com.nowcoder.campusExam.byteDance.second;

import java.util.Scanner;

public class Tfour {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int X = sc.nextInt();
            int Y = sc.nextInt();

            char[] chars = str.toCharArray();
            int count = 0;
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == 'u') {
                    X--;
                    count++;
                    if (X<1) break;
                } else if (chars[j] == 'r') {
                    Y++;
                    count++;
                    if (Y>M) break;
                } else if (chars[j] == 'd') {
                    X++;
                    count++;
                    if (X>N) break;
                } else if (chars[j] == 'l') {
                    Y--;
                    count++;
                    if (Y<1) break;
                }
            }
            System.out.println(count);
        }
    }
}
