package org.cr.campusExam.ctrip;

import java.util.Scanner;

public class Test {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int a, b;
        while (cin.hasNextInt()) {
            a = cin.nextInt();
            b = cin.nextInt();
            System.out.println(a + b);
        }
    }
}
