package com.nowcoder.campusExam.ctrip;

import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        while (sc.hasNextInt()) {
            list.add(sc.nextInt());
        }
        int N =  (int)Math.sqrt(list.size());
//        System.out.println(N);
        int arr[][] = new int[N][N];
        int arr2[][] = new int[N][N];

        for (int i = 0; i < N; i++) {
            int row = N*i;
            for (int j = 0; j < N; j++) {
                arr[i][j] = list.get(row+j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr2[j][N-i-1] =  arr[i][j];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(arr2[i][j] + " ");
            }
            System.out.println();
        }
    }
}
