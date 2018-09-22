package com.nowcoder.campusExam.baidu;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int pair = sc.nextInt();
        int nums[][] = new int[pair][2];

        for (int i = 0; i < pair; i++) {
            nums[i][0] = sc.nextInt();
            nums[i][1] = sc.nextInt();
        }

        for (int i = 0; i < pair; i++) {
            int hashTable[] = new int[256];
            for (int j = nums[i][0]-1; j<=nums[i][1]-1;j++) {
                hashTable[str.charAt(j)]++;
            }
            int max = -1;
            int flag = -1;
            for (int k=0; k<hashTable.length;k++) {
                if (hashTable[k] > max){
                    flag = k;
                    max = hashTable[k];
                }
            }
            System.out.print((char)flag);
        }
    }
}
