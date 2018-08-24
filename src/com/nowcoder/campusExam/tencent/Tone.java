package com.nowcoder.campusExam.tencent;

import java.util.Scanner;

/**
 * 求-1,-2,3,4,-5,-6,7,8这种的和，return M*n/2
 */

public class Tone {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        if (n % 2*m !=0) return;

        int arr[] = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i+1;
        }


        for (int i = 0; i < n; i+=2*m) {
            for (int j = 0; j < m; j++) {
                if (i+j >= n) break;
                arr[i + j] = -arr[i + j];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] +" ");
        }
        System.out.println();

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        System.out.println(sum);
    }
}
