package com.nowcoder.campusExam.jd;

import java.util.Scanner;

/**
 * 统计回文子序列的个数
 */
public class Tone {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            String s = input.nextLine();
            int len = s.length();
            int ans = len;
            for (int i = 0; i < len; i++) {
                //连续回文字串长度可能为奇数
                for (int l = i - 1, r = i + 1; l >= 0 && r < len && s.charAt(l) == s.charAt(r); l--, r++, ans++) ;
                //连续回文字串长度可能为偶数
                for (int l = i, r = i + 1; l >= 0 && r < len && s.charAt(l) == s.charAt(r); l--, r++, ans++) ;
            }
            System.out.println(ans);
        }
    }

}
