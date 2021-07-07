package org.cr.campusExam.ctrip.second_ctrip;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long count = 0;

//        while (n > 0) {
//            if ((n & 1) ==1) count++;
//            n = n >>> 1;
//        }
        for (count = 0; n != 0; ++count) {
            n &= (n - 1); // 清除最低位的1
        }
        System.out.println(count);
    }
}
