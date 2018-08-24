package com.nowcoder.leetcode.dynamicProgramming;

import static java.lang.Integer.max;

/**
 * Created by ChenRui on 2018/4/1
 * <p>
 * 子串应该比较好理解，至于什么是子序列，这里给出一个例子：有两个母串
 * <p>
 * cnblogs
 * belong
 * 比如序列bo, bg, lg在母串cnblogs与belong中都出现过并且出现顺序与母串保持一致，我们将其称为公共子序列。
 * 最长公共子序列（Longest Common Subsequence, LCS），顾名思义，是指在所有的子序列中最长的那一个。
 * 子串是要求更严格的一种子序列，要求在母串中连续地出现。在上述例子的中，最长公共子序列为blog（cnblogs, belong），
 * 最长公共子串为lo（cnblogs, belong）。
 */
public class LCS {

    /**
     * 最长公共子序列
     *
     * @param str1
     * @param str2
     * @return
     */
    public static int lcs(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int c[][] = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0 || j == 0) {
                    c[i][j] = 0;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                } else {
                    c[i][j] = max(c[i - 1][j], c[i][j - 1]);
                }
            }
        }
        return c[len1][len2];
    }

    public static void main(String[] args) {
        int lcs = LCS.lcs("cnblogs", "belong");
        System.out.println(lcs);
    }
}
