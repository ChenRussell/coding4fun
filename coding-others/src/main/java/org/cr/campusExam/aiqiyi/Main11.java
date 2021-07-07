package org.cr.campusExam.aiqiyi;

/**
 * Created by ChenRui on 2018/9/15
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int[] pre = new int[3];
        int[] last = new int[3];
        int[] all = new int[6];
        for (int i = 0; i < 6; i++) {
            if (i < 3) {
                pre[i] = str.charAt(i) - '0';
            } else {
                last[i - 3] = str.charAt(i) - '0';
            }
            all[i] = str.charAt(i) - '0';
        }
        int preSum = 0;
        int lastSum = 0;
        for (int i = 0; i < 3; i++) {
            preSum += pre[i];
            lastSum += last[i];
        }
        Arrays.sort(all);
        int abs = Math.abs(preSum - lastSum);
        int head = 0;
        int tail = 5;
        int count = 0;
        while (abs > 0) {
            if (all[tail] < 9 - all[head]) {
                count++;
                abs = abs - (9 - all[head]);
                head++;
            } else {
                count++;
                abs = abs - all[tail];
                tail--;
            }
        }
        System.out.println(count);


    }
}
