package org.cr.campusExam.jd;

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

        int y = n - (n & (n - 1));  // Ϊʲô�ܵõ���С��������y�� ��n/y������
        System.out.println(n/y+" "+y);
    }
}
