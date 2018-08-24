package com.nowcoder.leetcode;

/**
 * Created by ChenRui on 18-4-8
 * <p>
 * Given a string s and a string t, check if s is subsequence of t.
 * <p>
 * You may assume that there is only lower case English letters in both s and t. t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).
 * <p>
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).
 * <p>
 * Example 1:
 * s = "abc", t = "ahbgdc"
 * <p>
 * Return true.
 * <p>
 * Example 2:
 * s = "axc", t = "ahbgdc"
 * <p>
 * Return false.
 * <p>
 * Follow up:
 * If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?
 * <p>
 * Credits:
 * Special thanks to @pbrother for adding this problem and creating all test cases.
 */
public class _392IsSubsequence {

    /**
     * 代码写废了!!!!
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        int pre = -1;
        for (int i = 0; i < s.length(); i++) {

            if (!t.contains(String.valueOf(s.charAt(i)))) return false;
            else {
                if (t.indexOf(String.valueOf(s.charAt(i)),pre) < pre) return false;
                pre = t.indexOf(String.valueOf(s.charAt(i)),pre);  // 记录上一次出现的索引
            }

        }
        return true;
    }

    /**
     * 使用两个指针分别指向s和t，向后扫描
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence2(String s, String t) {
        int ps = 0, pt = 0;
        while (pt < t.length()) {
            if (s.charAt(ps) == t.charAt(pt)) {
                ps++;
                if (ps == s.length()) return true;
            }
            pt++;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "letcode";
        String t = "leetcode";
        boolean res = new _392IsSubsequence().isSubsequence2(s, t);
        System.out.println(res);
    }
}
