package com.nowcoder.campusExam.ctrip;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by ChenRui on 18-4-8
 *
 * 3
 * 1 1
 * 1 2
 * 2 1,2
 */
public class Lianjia {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int j = sc.nextInt();
            for (int k = 0; k < j; k++) {
                set.add(sc.nextInt());
            }
        }
        System.out.println(set.size());
    }
}
