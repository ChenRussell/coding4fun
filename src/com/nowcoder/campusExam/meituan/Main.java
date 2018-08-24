package com.nowcoder.campusExam.meituan;

/**
 * Created by ChenRui on 2018/3/22
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String t = in.nextLine();
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        int sum = 0;
        int i = 0;
        int j = t.length() - 1;
        while(j < s.length()) {
            int q = 0;
            for(int k = i; k <= j; k++) {
                if(chars[k] != chart[q])
                    sum++;
                q++;
            }
            i++;
            j++;
        }
        System.out.println(sum);
    }
}
