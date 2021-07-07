package org.cr.campusExam.netease.second;

import java.util.Scanner;
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int[] cap = new int[n];
        String c = sc.nextLine();
        String[] s = c.split(" ");
        for (int i = 0; i < n; i++)
            cap[i] = Integer.valueOf(s[i]);
        String[] order = new String[m];
        for (int i = 0; i < m; i++)
            order[i] = sc.nextLine();
        sc.close();
        int[] arr = new int[n];
        for (int i = 0; i <= m-1; i++) {
            String[] t = order[i].split(" ");
            if (t.length == 2) {
                System.out.println(arr[Integer.valueOf(t[1]) - 1]);
            } else {
                int f = Integer.valueOf(t[1]) - 1;
                int num = Integer.valueOf(t[2]);
                while (num > 0 && f <= n-1) {
                    arr[f] += num;
                    if (arr[f] > cap[f]) {
                        num = arr[f] - cap[f];
                        arr[f] = cap[f];
                        f++;
                    } else
                        break;
                }
            }
        }
    }
}
