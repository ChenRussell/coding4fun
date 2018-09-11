package com.nowcoder.campusExam.baicizhan;

import java.util.Scanner;

/**
 * ÅĞ¶ÏËØÊı
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean flag = true;

        double sqrt = Math.sqrt(n);
        for (int i =2; i <=sqrt; i++) {
            if (n % i == 0) {
                flag = false;
                break;
            }
        }
        System.out.println(flag);
    }
}
