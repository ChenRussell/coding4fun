package org.cr.campusExam.wangyi;

import java.util.Scanner;

/**
 * Created by ChenRui on 2018/3/27
 *
 * ����n,k
 * ����������n����������������k
 */
public class Wtwo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int count = 0;
        for (int i = k; i <= n; i++) {
            for (int j = k; j <= n; j++) {
                if (i <= n && j <= n && i % j >= k) {
                    ++count;
                    System.out.println(i + " "+j);
                }
            }
        }
        System.out.println(count);
    }
}
